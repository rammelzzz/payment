package org.agile.payment;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

	public static final PayrollDatabase GpayrollDatabase = new PayrollDatabase();

	private PayrollDatabase() {
	}

	private Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

	public Employee getEmployee(int empId) {
		return employeeMap.get(empId);
	}

	public void addEmployee(int empId, Employee employee) {
		this.employeeMap.put(empId, employee);
	}

	public void delEmployee(int empId) {
		this.employeeMap.remove(empId);
	}



}
