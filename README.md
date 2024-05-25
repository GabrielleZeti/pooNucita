public interface PaymentProvider {
    String getToken();
}

public class PayPalProvider implements PaymentProvider {
    private String username;
    private String password;

    public PayPalProvider(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getToken() {
        return username + ":" + password;
    }
}

public class StripeProvider implements PaymentProvider {
    private String username;

    public StripeProvider(String username) {
        this.username = username;
    }

    @Override
    public String getToken() {
        return username + ":stripe";
    }
}

// Similar classes for Square, AuthorizeNet, Alipay, etc.


public class PaymentProviderFactory {
    public static PaymentProvider createProvider(String providerName, String username, String password) {
        switch (providerName.toLowerCase()) {
            case "paypal":
                return new PayPalProvider(username, password);
            case "stripe":
                return new StripeProvider(username);
            case "square":
                return new SquareProvider(username);
            case "authorize.net":
                return new AuthorizeNetProvider(username);
            case "alipay":
                return new AlipayProvider(username);
            default:
                throw new IllegalArgumentException("Unknown provider: " + providerName);
        }
    }
}


public class PaymentProviderBuilder {
    private String providerName;
    private String username;
    private String password;

    public PaymentProviderBuilder setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public PaymentProviderBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public PaymentProviderBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public PaymentProvider build() {
        return PaymentProviderFactory.createProvider(providerName, username, password);
    }
}


public class PaymentProviderDirector {
    private PaymentProviderBuilder builder;

    public PaymentProviderDirector(PaymentProviderBuilder builder) {
        this.builder = builder;
    }

    public PaymentProvider construct(String providerName, String username, String password) {
        return builder.setProviderName(providerName)
                      .setUsername(username)
                      .setPassword(password)
                      .build();
    }
}


public class Main {
    public static void main(String[] args) {
        PaymentProviderBuilder builder = new PaymentProviderBuilder();
        PaymentProviderDirector director = new PaymentProviderDirector(builder);

        PaymentProvider paypalProvider = director.construct("paypal", "user@example.com", "password123");
        System.out.println("PayPal Token: " + paypalProvider.getToken());

        PaymentProvider stripeProvider = director.construct("stripe", "user@example.com", null);
        System.out.println("Stripe Token: " + stripeProvider.getToken());

        // Add similar usage for other providers
    }
}
