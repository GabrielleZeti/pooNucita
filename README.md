package com.eshopuniverse;

public class SquareProvider implements PaymentProvider {
    private String username;

    public SquareProvider(String username) {
        this.username = username;
    }

    @Override
    public String getToken() {
        return username + ":square";
    }
}
