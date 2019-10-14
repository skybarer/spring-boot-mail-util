package inkollu.akash.mail.util.session.filter;

import inkollu.akash.mail.util.http.ErrorCode;
import inkollu.akash.mail.util.http.client.HttpResponseBuilder;
import inkollu.akash.mail.util.lang.Language;
import inkollu.akash.mail.util.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 05:10 PM
 */
public class SessionFilter implements Filter {
    public static final Logger logger = LoggerFactory.getLogger(SessionFilter.class.getName());
    private static String contextPath;
    private static String contextName;
    private static String whitelistedContextPaths;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        contextPath = filterConfig.getServletContext().getContextPath();
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.printf("Filter init: %s%n", servletContext);

        String providedWhitelist = filterConfig.getServletContext().getInitParameter("whitelistedContextPaths");
        logger.debug("SanitizeContextPathFilter received provided whitelisted context paths from " +
                "NiFi properties: " + providedWhitelist);
        if (providedWhitelist != null) {
            whitelistedContextPaths = providedWhitelist;
        }
        contextName = servletContext.getContextPath().replaceAll("/", "");
        if ("".equals(contextName)) {
            contextName = "root";
        }
        ConfigurableWebApplicationContext appCtx = (ConfigurableWebApplicationContext)
                servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        if (appCtx != null) {
            System.out.printf("ConfigurableWebApplicationContext is not null in LoggerContextFilter for: %s, " +
                    "this indicates a misconfiguration or load order problem%n", contextName);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession(false);
        String sessionAttribute = "";
        String customerRefIdSessionAttribute = "";
        String sessionUploadCount = "";
        List<String> whiteListedUrns = Arrays.asList("/session", "/config", "/start");

        if (session != null) {
            String requestURI = request.getRequestURI().replace(contextPath, "");
            if (whiteListedUrns.stream().noneMatch(requestURI::startsWith)) {
                HttpResponseBuilder.error(response, ErrorCode.UNAUTHORIZED);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            if (session.getAttribute(sessionAttribute) != null) {
                Object refId = session.getAttribute(sessionAttribute);
                Object customerRefId = session.getAttribute(customerRefIdSessionAttribute);
                Object fileUploadCount = session.getAttribute(sessionUploadCount);
                if (refId != null) {
                    Session.setId((Long) refId);
                    Session.setCustomerRefId((String) customerRefId);
                    MDC.put("formId", String.valueOf(customerRefId));
                }
                String languageCode = (String) session.getAttribute(Language.class.getSimpleName());
                if (languageCode == null) {
                    languageCode = Language.ENGLISH.getLanguageCode();
                }
                Session.setLang(languageCode);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                HttpResponseBuilder.error(response, ErrorCode.FORBIDDEN);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
