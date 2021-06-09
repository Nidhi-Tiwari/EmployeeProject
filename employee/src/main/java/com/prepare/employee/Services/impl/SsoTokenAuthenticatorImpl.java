package com.prepare.employee.Services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.prepare.employee.Services.SsoTokenAuthenticator;
import com.prepare.employee.domain.response.Token;
import lombok.extern.slf4j.Slf4j;
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
    @Override
    public boolean authenticate(String ssoToken) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            Token response = getTokenHit(ssoToken);
            log.info("Response name ={} " , response.getName());
            log.info("Response userId ={} " , response.getUserId());
            if (ssoToken.equals("usr-123_9"))
                return true;
            return false;
        } catch (RestClientException e) {
            log.error("Not able to authenticate");
            return false;
        }
    }
    @HystrixCommand(fallbackMethod = "getTokenHitFallBack")
    public Token getTokenHit(String ssoToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        Token response = restTemplate.exchange("http://localhost:8082/oauth/token?sso=" + ssoToken,
                HttpMethod.GET, new HttpEntity<>(headers), Token.class).getBody();
        return response;
    }

    public Token getTokenHitFallBack(String ssoToken) {

        log.info("Default response for getToken Hit");
        return Token.builder().name("Default").userId(0).build();
    }
}
