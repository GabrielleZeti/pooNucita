Clase abstracta =>Habitacion
Factory=> HabitacionFactory
Singleton => HotelManager 
sistema principal => HotelSystem 

public class StripeProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":stripe";
        // Authentication logic using the token
        return "Authenticated with Stripe using token: " + token;
    }
}

// Similar classes for Square, Authorize.net, Alipay
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
