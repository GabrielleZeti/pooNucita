Clase abstracta =>Habitacion
Factory=> HabitacionFactory
Singleton => HotelManager 
sistema principal => HotelSystem 


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
