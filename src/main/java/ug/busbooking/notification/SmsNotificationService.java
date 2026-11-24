package ug.busbooking.notification;

import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService {
    public SmsNotificationService() {
        System.out.println("[SPRING] Creating bean: SmsNotificationService");
    }

    public void send(String phone, String message) {
        System.out.println("    SMS to " + phone + ": " + message);
    }
}
