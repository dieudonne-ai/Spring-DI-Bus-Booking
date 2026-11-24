package ug.busbooking.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mtnMoMo")
@Primary
public class MtnMoMoGateway implements PaymentGateway {
    public MtnMoMoGateway() {
        System.out.println("[SPRING] Creating bean: MtnMoMoGateway (@Primary)");
    }

    public String name() {
        return "MTN Mobile Money";
    }

    public boolean pay(String phone, int amount) {
        System.out.println("    MTN MoMo: charged UGX " + amount + " to " + phone);
        return true;
    }
}
