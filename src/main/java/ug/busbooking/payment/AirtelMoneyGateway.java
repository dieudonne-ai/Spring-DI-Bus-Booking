package ug.busbooking.payment;

import org.springframework.stereotype.Component;

@Component("airtelMoney")
public class AirtelMoneyGateway implements PaymentGateway {
    public AirtelMoneyGateway() {
        System.out.println("[SPRING] Creating bean: AirtelMoneyGateway");
    }

    public String name() {
        return "Airtel Money";
    }

    public boolean pay(String phone, int amount) {
        System.out.println("    Airtel Money: sent UGX " + amount + " to " + phone);
        return true;
    }
}
