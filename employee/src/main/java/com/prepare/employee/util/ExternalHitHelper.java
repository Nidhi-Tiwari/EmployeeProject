package com.prepare.employee.util;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.prepare.employee.domain.response.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ExternalHitHelper {
    @HystrixCommand(fallbackMethod = "getTokenHitFallBack", commandKey = "getTokenCommand", groupKey = "getTokenCommand")
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
