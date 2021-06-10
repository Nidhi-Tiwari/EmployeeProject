package com.prepare.employee.util;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.prepare.employee.domain.request.UserRequestBody;
import com.prepare.employee.domain.response.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ExternalHitHelper2 {
    @HystrixCommand(fallbackMethod = "postTokenHitFallBack", commandKey = "postTokenCommand", groupKey = "postTokenCommand")
    public Token postTokenHit(String ssoToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        UserRequestBody userRequestBody = UserRequestBody.builder().id(5).departmentName("paytm").name("lalala").build();
        HttpEntity<UserRequestBody> httpEntity = new HttpEntity<UserRequestBody>(userRequestBody,headers);
        Token response = restTemplate.exchange("http://localhost:8082/oauth/postData",
                HttpMethod.POST, httpEntity, Token.class).getBody();
        return response;
    }

    public Token postTokenHitFallBack(String ssoToken) {
        log.info("Default response for getToken Hit");
        return Token.builder().name("Default").userId(0).build();
    }
}
