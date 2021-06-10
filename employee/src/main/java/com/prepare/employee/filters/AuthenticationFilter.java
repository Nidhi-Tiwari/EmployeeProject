package com.prepare.employee.filters;

import com.prepare.employee.Exceptions.CustomExceptions;
import com.prepare.employee.Services.SsoTokenAuthenticator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
@Order(2)
public class AuthenticationFilter implements Filter {
    @Autowired
    private SsoTokenAuthenticator ssoTokenAuthenticator;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String ssoToken = req.getHeader("sso-token");
        log.info("Request Validation :: {}",ssoToken);
        if(!ssoTokenAuthenticator.authentication2(ssoToken)){
            throw new CustomExceptions("sso token not valid");
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
