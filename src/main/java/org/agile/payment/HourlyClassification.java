package org.agile.payment;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HourlyClassification implements PaymentClassification {

    private Map<LocalDate, TimeCard> map;

    private double hourlyRate;

    public HourlyClassification(double hourlyRate) {
        this.map = new HashMap<>();
        this.hourlyRate = hourlyRate;
    }

    public TimeCard getTimeCard(LocalDate localDate) {
        return this.map.get(localDate);
    }

    public void addTimeCard(TimeCard timeCard) {
        this.map.put(timeCard.getDate(), timeCard);
    }

    @Override
    public double getSalary() {
        return 0;
    }
}
