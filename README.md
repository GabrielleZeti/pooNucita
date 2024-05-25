Abstract class =>Room
Factory=> RoomFactory
Singleton => HotelManager 
main system => HotelSystem 



Class 'SquareProvider' is public, should be declared in a file named 'SquareProvider.java'
Class 'AuthorizeNetProvider' is public, should be declared in a file named 'AuthorizeNetProvider.java'
Class 'AlipayProvider' is public, should be declared in a file named 'AlipayProvider.java'

public class StripeProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":stripe";
        // Authentication logic using the token
        return "Autenticacion con Stripe usando token: " + token;
    }
}


public class SquareProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":square";
        return "AAutenticacion con Square usando token: " + token;
    }
}


public class AuthorizeNetProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":authorize.net";
        return "Autenticacion con Authorize.net usando token: " + token;
    }
}


public class AlipayProvider implements PaymentProvider {
    @Override
    public String authenticate(String username, String password) {
        String token = username + ":alipay";
        return "Autenticacion con Alipay usando token: " + token;
    }
}
