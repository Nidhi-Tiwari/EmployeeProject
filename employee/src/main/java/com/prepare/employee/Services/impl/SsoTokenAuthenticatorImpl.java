package com.prepare.employee.Services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            Token response = restTemplate.exchange("http://localhost:8082/oauth/token?sso=" + ssoToken,
                    HttpMethod.GET, new HttpEntity<>(headers), Token.class).getBody();
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
}
