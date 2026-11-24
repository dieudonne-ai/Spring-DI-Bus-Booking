package ug.busbooking.payment;

public interface PaymentGateway {
    String name();
    boolean pay(String phone, int amount);
}
