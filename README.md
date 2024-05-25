package com.eshopuniverse;

public class AlipayProvider implements PaymentProvider {
    private String username;

    public AlipayProvider(String username) {
        this.username = username;
    }

    @Override
    public String getToken() {
        return username + ":alipay";
    }
}
