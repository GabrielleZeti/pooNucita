Abstract class =>Room
Factory=> RoomFactory
Singleton => HotelManager 
main system => HotelSystem 

public interface PaymentProvider {
    String authenticate(String username, String password);
}

public class PayPalProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        // Simple authentication logic for PayPal
        return "Authenticated with PayPal using username: " + username;
    }
}


public class StripeProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":stripe";
        // Authentication logic using the token
        return "Authenticated with Stripe using token: " + token;
    }
}


public class SquareProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":square";
        return "Authenticated with Square using token: " + token;
    }
}


public class AuthorizeNetProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":authorize.net";
        return "Authenticated with Authorize.net using token: " + token;
    }
}


public class AlipayProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":alipay";
        return "Authenticated with Alipay using token: " + token;
    }
}


public class PaymentContext {
    private PaymentProvider provider;

    public void setPaymentProvider(PaymentProvider provider) {
        this.provider = provider;
    }

    public String authenticate(String username, String password) {
        return provider.authenticate(username, password);
    }
}



 public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        
        // Set PayPal as the current provider and authenticate
        context.setPaymentProvider(new PayPalProvider());
        System.out.println(context.authenticate("user1", "pass1"));
        
        // Set Stripe as the current provider and authenticate
        context.setPaymentProvider(new StripeProvider());
        System.out.println(context.authenticate("user1", "pass1"));
        
        // Set Square as the current provider and authenticate
        context.setPaymentProvider(new SquareProvider());
        System.out.println(context.authenticate("user1", "pass1"));
        
        // Set Authorize.net as the current provider and authenticate
        context.setPaymentProvider(new AuthorizeNetProvider());
        System.out.println(context.authenticate("user1", "pass1"));
        
        // Set Alipay as the current provider and authenticate
        context.setPaymentProvider(new AlipayProvider());
        System.out.println(context.authenticate("user1", "pass1"));
    }
}
