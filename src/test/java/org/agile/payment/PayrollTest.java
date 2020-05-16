package org.agile.payment;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.agile.payment.PayrollDatabase.*;

public class PayrollTest {

	@Test
    public void testAddSalariedEmployees() {
        int empId = 1;
        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId, "Bob",
                "Home", 1000.0);
        addSalariedEmployee.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
       	assertEquals("Bob", e.getName());

		PaymentClassification classification = e.getClassification();
		SalariedClassification salariedClassification = (SalariedClassification) classification;

		assertEquals(1000.0, salariedClassification.getSalary(), 0.001);

		PaymentSchedule pc = e.getPaymentSchedule();
		assertTrue(pc instanceof MonthlyPaymentSchedule);
		MonthlyPaymentSchedule mpc = (MonthlyPaymentSchedule) pc;

		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);
		HoldMethod hm  = (HoldMethod) pm;
    }

    @Test
    public void testDeleteEmployee() {
		int empId = 3;
		AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId, "Chris",
				"Home", 1000.0);
		addSalariedEmployee.execute();

		Employee e = GpayrollDatabase.getEmployee(empId);
		assertNotNull(e);

		DeleteEmployeeTransaction deleteEmployeeTransaction = new DeleteEmployeeTransaction(empId);
		deleteEmployeeTransaction.execute();
		e = GpayrollDatabase.getEmployee(empId);
		assertNull(e);
	}

	@Test
	public void testTimeCardTransaction() {
		int empId = 2;
		AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId, "Bill",
				"Home", 15.25);
		addHourlyEmployee.execute();

		TimeCardTransaction transaction = new TimeCardTransaction(LocalDate.now(),
				8.0, empId);

		transaction.execute();

		Employee e = GpayrollDatabase.getEmployee(empId);
		assertNotNull(e);

		PaymentClassification paymentClassification = e.getClassification();
		assertTrue(paymentClassification instanceof HourlyClassification);

		HourlyClassification hourlyClassification = (HourlyClassification) paymentClassification;

		TimeCard tc = hourlyClassification.getTimeCard(LocalDate.now());
		assertNotNull(tc);
		assertEquals(8.0, tc.getHours(), 0.001);
	}

}
