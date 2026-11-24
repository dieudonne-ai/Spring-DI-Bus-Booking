package ug.busbooking;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ug.busbooking.config.AppConfig;
import ug.busbooking.repository.BookingRepository;
import ug.busbooking.service.RefundService;
import ug.busbooking.service.TicketService;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== SPRING DEPENDENCY INJECTION DEMO: KAMPALA BUS BOOKING ===");
        System.out.println("\n[1] Spring container starts: it creates the beans and injects them");
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            System.out.println("\n[2] Beans managed by the Spring container");
            for (String name : context.getBeanDefinitionNames()) {
                if (!name.startsWith("org.springframework")) {
                    System.out.println("    - " + name + " : " + context.getType(name).getSimpleName());
                }
            }

            System.out.println("\n[3] Booking tickets (TicketService never calls 'new' for its dependencies)");
            TicketService tickets = context.getBean(TicketService.class);
            tickets.book("0772 123456", "Kampala -> Gulu", 45000, 2);
            tickets.book("0701 987654", "Kampala -> Mbarara", 40000, 1);

            System.out.println("\n[4] Refund through Airtel Money, chosen with @Qualifier");
            RefundService refunds = context.getBean(RefundService.class);
            refunds.refund("0701 987654", 42000);

            System.out.println("\n[5] Reusability: one bean shared by many classes");
            boolean shared = tickets.getNotifier() == refunds.getNotifier();
            System.out.println("    TicketService and RefundService use the SAME SmsNotificationService: " + shared);
            System.out.println("    Bookings stored in BookingRepository: " + context.getBean(BookingRepository.class).count());
        }

        System.out.println("\nDone: Spring container closed.");
    }
}
