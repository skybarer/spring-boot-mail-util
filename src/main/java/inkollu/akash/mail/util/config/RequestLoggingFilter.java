package inkollu.akash.mail.util.config;

import inkollu.akash.mail.util.logger.LogUtils;
import inkollu.akash.mail.util.logger.RequestUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterConfig;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 07:51 AM
 */
public class RequestLoggingFilter implements Filter {
    private static final String PASSWORD_FILTER_REGEX =
            "(password=\\[([\\S\\s])*\\])|(\"password\":\"([\\S\\s])*\")";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final BodyReaderWrapper wrapper = new BodyReaderWrapper((HttpServletRequest) request);
        String requestMessage = RequestUtils.getRequestMessage(wrapper);
        if (!LogUtils.getLogger().isDebugEnabled()) {
            requestMessage = StringUtils.replaceAll(requestMessage, PASSWORD_FILTER_REGEX,
                    "enable password protection, if not debug so do not see");
        }
        LogUtils.getLogger().info(requestMessage);
        chain.doFilter(wrapper, response);
    }

    @Override
    public void destroy() {

    }
}
