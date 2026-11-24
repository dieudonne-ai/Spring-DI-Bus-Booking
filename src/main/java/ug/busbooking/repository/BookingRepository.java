package ug.busbooking.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {
    private final List<String> bookings = new ArrayList<>();

    public BookingRepository() {
        System.out.println("[SPRING] Creating bean: BookingRepository");
    }

    public void save(String booking) {
        bookings.add(booking);
    }

    public int count() {
        return bookings.size();
    }
}
