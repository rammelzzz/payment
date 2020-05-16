package org.agile.payment;

import java.time.LocalDate;

public class TimeCard {

    public LocalDate getDate() {
        return date;
    }

    private LocalDate date;

    private double hours;

    public TimeCard(LocalDate date, double hours) {
        this.date = date;
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }
}
