package com.prepare.employee.Services.impl;

import com.prepare.employee.Services.SsoTokenAuthenticator;
import org.springframework.stereotype.Service;

@Service
public class SsoTokenAuthenticatorImpl implements SsoTokenAuthenticator {
    @Override
    public boolean authenticate(String ssoToken) {
        if(ssoToken.equals("usr-123_9"))
            return true;
        return false;
    }
}
