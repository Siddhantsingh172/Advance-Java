package com.EmployeeSalaryCalculator;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestEmployeeSalary {
	static EmployeeSalaryCalculator calc;
	
	@Test
	public void testValidSalary()
	{
		calc=new EmployeeSalaryCalculator(20000,5000,10);
		assertTrue(calc.validateSalary());
		assertEquals(2000.0,calc.calculateDA());
		assertEquals(4000.0d,calc.calculateHRA());
		assertEquals(31000.0d,calc.calculateGrossSalary());
		assertEquals(27900.0d,calc.calculateNetSalary());
	}
	
	@Test
	public void testThrows()
	{
		calc = new EmployeeSalaryCalculator(0, 0, 100);
		assertThrows(IllegalArgumentException.class,() -> calc.validateSalary());
		assertThrows(IllegalArgumentException.class,() -> calc.validateSalary());
	}
	

}
