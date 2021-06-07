package com.prepare.employee.Services;

public interface SsoTokenAuthenticator {
    public boolean authenticate(String ssoToken);
}
