package com.eshopuniverse;

public class AuthorizeNetProvider implements PaymentProvider {
    private String username;

    public AuthorizeNetProvider(String username) {
        this.username = username;
    }

    @Override
    public String getToken() {
        return username + ":authorize.net";
    }
}
