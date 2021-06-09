package com.prepare.employee.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
public class Token {
    private Integer userId;
    private String name;

    public Token(){}
    @Builder
    public Token(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
