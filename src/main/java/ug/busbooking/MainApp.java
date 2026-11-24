package ug.busbooking;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ug.busbooking.config.AppConfig;

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
        }

        System.out.println("\nDone: Spring container closed.");
    }
}
