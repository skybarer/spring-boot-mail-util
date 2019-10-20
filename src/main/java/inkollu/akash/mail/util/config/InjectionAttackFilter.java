package inkollu.akash.mail.util.config;

/**
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 11:35 AM
 */

import inkollu.akash.mail.util.config.handler.DefaultInjectionAttackHandler;
import inkollu.akash.mail.util.config.handler.InjectionAttackHandler;
import inkollu.akash.mail.util.logger.LogUtils;
import inkollu.akash.mail.util.logger.RequestUtils;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;


@Getter
@Setter
@Deprecated
public class InjectionAttackFilter implements Filter {

    private static final String X_FRAME_VALUE = "SAMEORIGIN";
    private static final String X_FRAME_HEADER = "X-FRAME-OPTIONS";
    private static boolean HAS_BODY_READER_WRAPPER = false;
    private static LongAdder LONG_ADDER = new LongAdder();

    private Set<String> passUris;

    private InjectionAttackHandler injectionAttackHandler;

    public InjectionAttackFilter() {
        this.injectionAttackHandler = DefaultInjectionAttackHandler.getInstance();
        this.passUris = Collections.EMPTY_SET;
    }

    public InjectionAttackFilter(Set<String> passUris, InjectionAttackHandler injectionAttackHandler) {
        this.passUris = passUris;
        this.injectionAttackHandler = injectionAttackHandler;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        if (this.pass(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!HAS_BODY_READER_WRAPPER && LONG_ADDER.intValue() <= 0) {
            LONG_ADDER.increment();
            HAS_BODY_READER_WRAPPER = servletRequest instanceof BodyReaderWrapper;
        }

        HttpServletRequest request;
        if (!HAS_BODY_READER_WRAPPER) {
            request = new BodyReaderWrapper((HttpServletRequest) servletRequest);
        } else {
            request = (HttpServletRequest) servletRequest;
        }

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String parameters = RequestUtils.getRequestParameters(request);

        if (this.isInjectionAttack(parameters)) {
            LogUtils.getLogger().debug("参数 {} 被判断为注入攻击", parameters);
            this.injectionHandle(request, response, parameters);
            return;
        }
        if (this.isInjectionAttack(request.getRequestURI())) {
            LogUtils.getLogger().debug("URI {} 被判断为注入攻击", parameters);
            this.injectionHandle(request, response, request.getRequestURI());
            return;
        }
        this.filterClickJack(response);
        filterChain.doFilter(this.requestWrapper(request), response);
    }

    protected boolean pass(ServletRequest servletRequest) {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        return passUris.contains(request.getRequestURI());
    }


    protected HttpServletRequest requestWrapper(HttpServletRequest request) {
        return request;
    }


    private void filterClickJack(HttpServletResponse response) {
        if (!response.containsHeader(X_FRAME_HEADER)) {
            response.addHeader(X_FRAME_HEADER, X_FRAME_VALUE);
        }
    }


    private boolean isInjectionAttack(final String parameters) {
        return this.injectionAttackHandler.isInjectionAttack(parameters);
    }


    protected void injectionHandle(HttpServletRequest request, HttpServletResponse response,
                                   String parameters) throws IOException {
        this.injectionAttackHandler.attackHandle(request, response, parameters);
    }


    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}