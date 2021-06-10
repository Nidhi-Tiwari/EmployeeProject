package com.prepare.employee.Services;

public interface SsoTokenAuthenticator {
    public boolean authenticate(String ssoToken);
    public boolean authentication2(String ssoToken);
}
