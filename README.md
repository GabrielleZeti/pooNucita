Clase abstracta =>Habitacion
Factory=> HabitacionFactory
Singleton => HotelManager 
sistema principal => HotelSystem 

public class PaymentContext {
    private PaymentProvider provider;

    public void setPaymentProvider(PaymentProvider provider) {
        this.provider = provider;
    }

    public String authenticate(String username, String password) {
        return provider.authenticate(username, password);
    }
}
