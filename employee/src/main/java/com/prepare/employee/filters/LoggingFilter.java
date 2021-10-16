package com.prepare.employee.filters;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@Component
@Slf4j // used for logging
@Order(1)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String requestId = req.getHeader("request-id");
        MDC.put("requestId", requestId);
        log.info("Request Uri :: {}", req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("Request Response :: {}", res.getContentType());
    }
}
