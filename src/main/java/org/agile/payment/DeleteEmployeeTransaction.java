package org.agile.payment;

import static org.agile.payment.PayrollDatabase.GpayrollDatabase;

public class DeleteEmployeeTransaction extends Transaction {

    private int empId;

    public DeleteEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    public void execute() {
        GpayrollDatabase.delEmployee(empId);
    }
}
