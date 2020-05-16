package org.agile.payment;

import static org.agile.payment.PayrollDatabase.GpayrollDatabase;

public abstract class AddEmployeeTransaction extends Transaction {

    private int empId;

    private String name;

    private String address;

    public AddEmployeeTransaction(int empId, String name, String address) {
        super();
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    protected abstract PaymentClassification getPaymentClassification();

    protected abstract PaymentSchedule getPaymentSchedule();

    public void execute() {
        PaymentClassification paymentClassification = getPaymentClassification();
        PaymentSchedule paymentSchedule = getPaymentSchedule();
        PaymentMethod paymentMethod = new HoldMethod();

        Employee e = new Employee(empId, name, address);
        e.setPaymentClassification(paymentClassification);
        e.setPaymentSchedule(paymentSchedule);
        e.setPaymentMethod(paymentMethod);

        GpayrollDatabase.addEmployee(empId, e);
    }


}
