package ug.busbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ug.busbooking.notification.NotificationService;
import ug.busbooking.payment.PaymentGateway;

@Service
public class RefundService {
    @Autowired
    private NotificationService notifier;

    private PaymentGateway refundGateway;

    @Autowired
    public void setRefundGateway(@Qualifier("airtelMoney") PaymentGateway refundGateway) {
        this.refundGateway = refundGateway;
        System.out.println("[SPRING] Setter injection into RefundService: gateway = " + refundGateway.name());
    }

    public void refund(String phone, int amount) {
        refundGateway.pay(phone, amount);
        notifier.send(phone, "Refund of UGX " + amount + " sent via " + refundGateway.name());
    }

    public NotificationService getNotifier() {
        return notifier;
    }
}
