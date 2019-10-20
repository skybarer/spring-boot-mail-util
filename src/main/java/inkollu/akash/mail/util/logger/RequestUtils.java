package inkollu.akash.mail.util.logger;


import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author : 余峻豪
 * @date : 16/6/16
 */
public abstract class RequestUtils {

    public static final String REQUEST_HEADER_HOST = "host";
    public static final String REQUEST_HEADER_CONNECTION = "connection";
    public static final String REQUEST_HEADER_CACHE_CONTROL = "cache-control";
    public static final String REQUEST_HEADER_UPGRADE_INSECURE_REQUESTS = "upgrade-insecure-requests";
    public static final String REQUEST_HEADER_USER_AGENT = "user-agent";
    public static final String REQUEST_HEADER_ACCEPT = "accept";
    public static final String REQUEST_HEADER_REFERER = "referer";
    public static final String REQUEST_HEADER_ACCEPT_ENCODING = "accept-encoding";
    public static final String REQUEST_HEADER_ACCEPT_LANGUAGE = "accept-language";
    public static final String REQUEST_HEADER_ACCEPT_COOKIE = "cookie";


    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    public static String getRequestIp() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip.trim();
        }
        ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为 真实 ip
            return StringUtils.split(ip, ",")[0].trim();
        }
        ip = request.getHeader("Proxy-Client-IP");
        if (StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip.trim();
        }
        ip = request.getHeader("WL-Proxy-Client-IP");
        if (StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip.trim();
        }
        ip = request.getHeader("HTTP_CLIENT_IP");
        if (StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip.trim();
        }
        ip = request.getHeader("X-Cluster-Client-IP");
        if (StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip.trim();
        }
        return request.getRemoteAddr();
    }


    public static boolean isApplicationJsonHeader(HttpServletRequest request) {
        String contentType = request.getHeader(HttpHeaders.CONTENT_TYPE);
        return contentType != null && StringUtils.replaceAll(
                contentType.trim(),
                StringUtils.SPACE,
                StringUtils.EMPTY
        ).contains(MediaType.APPLICATION_JSON_VALUE);
    }

    public static String getRequestHeader(String headerName) {
        return getRequest().getHeader(headerName);
    }

    public static String getUserAgentHeader() {
        return getRequestHeader(REQUEST_HEADER_USER_AGENT);
    }

    public static UserAgent getUserAgent() {
        return UserAgent.parseUserAgentString(getUserAgentHeader());
    }

    public static String getRequestReferrerUrl() {
        return getRequestHeader(REQUEST_HEADER_REFERER);
    }

    public static String getRequestMessage(HttpServletRequest request, Object userId, String username) throws
            IOException {
        StringBuilder parameters = new StringBuilder();
        parameters.append("\n用户ID : ")
                .append(userId)
                .append("\n用户姓名 : ")
                .append(username);
        return getRequestMessage(request, parameters);
    }

    public static String getRequestMessage(HttpServletRequest request) throws IOException {
        StringBuilder parameters = new StringBuilder();
        return getRequestMessage(request, parameters);
    }

    public static String getRequestParameters(HttpServletRequest request) throws IOException {
        StringBuilder parameters = new StringBuilder();
        if (RequestUtils.isApplicationJsonHeader(request)) {
            parameters.append(IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8.displayName()));
        } else {
            request.getParameterMap().forEach(
                    (String key, String[] values) -> parameters.append(key)
                            .append("=")
                            .append(Arrays.toString(values))
                            .append("\t")
            );
        }
        return parameters.toString();
    }

    private static String getRequestMessage(HttpServletRequest request, StringBuilder parameters) throws
            IOException {
        parameters.append("\n请求URL : ")
                .append(request.getRequestURI())
                .append("\n请求URI : ")
                .append(request.getRequestURL())
                .append("\n请求方式 : ")
                .append(request.getMethod())
                .append(RequestUtils.isAjaxRequest(request) ? "\tajax请求" : "\t同步请求")
                .append("\n请求者IP : ")
                .append(request.getRemoteAddr())
                .append("\n请求时间 : ")
                .append(Instant.now());

        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            final String element = headerNames.nextElement();
            if (null != element) {
                String header = request.getHeader(element);
                parameters.append("\n请求头内容 : ").append(element).append("=").append(header);
            }
        }
        parameters.append("\n请求参数 : ").append(getRequestParameters(request));

        final Enumeration<String> sessionAttributeNames = request.getSession().getAttributeNames();
        while (sessionAttributeNames.hasMoreElements()) {
            parameters.append("\nSession内容 : ").append(sessionAttributeNames.nextElement());
        }
        return parameters.toString();
    }


}
