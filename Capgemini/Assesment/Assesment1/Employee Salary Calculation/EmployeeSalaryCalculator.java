package com.EmployeeSalaryCalculator;

public class EmployeeSalaryCalculator {
	private double baseSalary;
	private double bonus;
	private double taxPercent;
	
	public EmployeeSalaryCalculator(double baseSalary,double bonus,double taxPercent)
	{
		this.baseSalary = baseSalary;
		this.bonus = bonus;
		this.taxPercent = taxPercent;
	}
	public boolean validateSalary()
	{
		if(this.getBaseSalary()<=0)
			throw new IllegalArgumentException();
		if(this.getTaxPercent()<0 || this.getTaxPercent()>100)
			throw new IllegalArgumentException();
		return true;
	}
	public double calculateHRA() {
		return  this.getBaseSalary() * 0.2;
	}
	public double calculateDA()
	{
		return this.getBaseSalary() * 0.1;
	}
	public double calculateGrossSalary()
	{
		return this.getBaseSalary()+this.calculateDA()+ this.calculateHRA()+ this.getBonus();
	}
	public double calculateNetSalary()
	{
		return (this.calculateGrossSalary() - ((this.getTaxPercent()/100)*this.calculateGrossSalary())); 
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getTaxPercent() {
		return taxPercent;
	}
	public void setTaxPercent(double taxPercent) {
		this.taxPercent = taxPercent;
	}
	
}