package org.agile.payment;

import java.time.LocalDate;

import static org.agile.payment.PayrollDatabase.GpayrollDatabase;

public class TimeCardTransaction extends Transaction {

    private LocalDate date;

    private double hours;

    private int empId;

    public TimeCardTransaction(LocalDate date, double hours, int empId) {
        this.date = date;
        this.hours = hours;
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee e = GpayrollDatabase.getEmployee(empId);
        HourlyClassification hourlyClassification = (HourlyClassification) e.getClassification();
        hourlyClassification.addTimeCard(new TimeCard(date, hours));
    }
}
