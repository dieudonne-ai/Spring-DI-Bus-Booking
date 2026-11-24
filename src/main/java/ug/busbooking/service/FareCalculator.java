package ug.busbooking.service;

public class FareCalculator {
    private final int serviceCharge;

    public FareCalculator(int serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int totalFare(int baseFare, int seats) {
        return baseFare * seats + serviceCharge;
    }
}
