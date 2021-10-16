package com.prepare.employee.Services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.prepare.employee.Services.SsoTokenAuthenticator;
import com.prepare.employee.domain.response.Token;
import com.prepare.employee.util.ExternalHitHelper;
import com.prepare.employee.util.ExternalHitHelper2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class SsoTokenAuthenticatorImpl implements SsoTokenAuthenticator {
    @Autowired
    private ExternalHitHelper externalHitHelper;
    @Autowired
    private ExternalHitHelper2 externalHitHelper2;

    @Override
    public boolean authenticate(String ssoToken) {
        try {
            if (Strings.isBlank(ssoToken)) {
                return false;
            }
            Token response = externalHitHelper.getTokenHit(ssoToken);
            log.info("Response name ={} ", response.getName());
            log.info("Response userId ={} ", response.getUserId());
            if (ssoToken.equals("usr-123_9"))
                return true;
            return false;
        } catch (RestClientException e) {
            log.error("Not able to authenticate");
            return false;
        }
    }

    @Override
    public boolean authentication2(String ssoToken) {
        try {
            if (Strings.isBlank(ssoToken)) {
                return false;
            }
            Token response = externalHitHelper2.postTokenHit(ssoToken, MDC.get("requestId"));
            log.info("Response name ={} ", response.getName());
            log.info("Response userId ={} ", response.getUserId());
            if (ssoToken.equals("usr-123_9"))
                return true;
            return false;
        } catch (
                RestClientException e) {
            log.error("Not able to authenticate");
            return false;
        }
    }

}
