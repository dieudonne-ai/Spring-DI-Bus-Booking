package ug.busbooking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ug.busbooking.service.FareCalculator;

@Configuration
@ComponentScan(basePackages = "ug.busbooking")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public FareCalculator fareCalculator(@Value("${fare.service.charge}") int serviceCharge) {
        System.out.println("[SPRING] @Bean method creates FareCalculator, service charge UGX " + serviceCharge);
        return new FareCalculator(serviceCharge);
    }
}
