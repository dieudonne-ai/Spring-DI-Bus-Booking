package ug.busbooking.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ug.busbooking.notification.NotificationService;
import ug.busbooking.payment.PaymentGateway;
import ug.busbooking.repository.BookingRepository;

@Service
public class TicketService {
    private final PaymentGateway payment;
    private final NotificationService notifier;
    private final BookingRepository repository;
    private final FareCalculator calculator;
    private final String company;

    public TicketService(PaymentGateway payment, NotificationService notifier, BookingRepository repository,
                         FareCalculator calculator, @Value("${company.name}") String company) {
        this.payment = payment;
        this.notifier = notifier;
        this.repository = repository;
        this.calculator = calculator;
        this.company = company;
        System.out.println("[SPRING] Constructor injection into TicketService: payment = " + payment.name());
    }

    public void book(String phone, String route, int baseFare, int seats) {
        int total = calculator.totalFare(baseFare, seats);
        if (payment.pay(phone, total)) {
            repository.save(phone + " | " + route + " | " + seats + " seat(s)");
            notifier.send(phone, company + ": " + seats + " seat(s) " + route + " confirmed, paid UGX " + total);
        }
    }

    public NotificationService getNotifier() {
        return notifier;
    }
}
