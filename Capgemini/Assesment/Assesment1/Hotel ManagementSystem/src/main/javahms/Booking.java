package com.hms.Hms;



import javax.persistence.*;

@Entity
@Table(name = "bookings_details")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private String customerName;
	private String roomType;
	private int days;
	private double totalAmount;
	
	public Booking()
	{
		
	}
	public Booking(String customerName,String roomType,int days)
	{
		this.setCustomerName(customerName);
		this.setDays(days);
		this.setRoomType(roomType);
		this.setTotalAmount(calculateTotalAmount());
	}
	
	public int getBookingId()
	{
		return this.bookingId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public void setDays(int days)
	{
		this.days = days;
	}
	public int getDays()
	{
		return this.days;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double calculateTotalAmount()
	{
		String type = this.getRoomType();
		double price = 0;
		if(type.equals("Standard"))
			price = 2000;
		else if(type.equals("Deluxe"))
			price = 3500;
		else 
			price = 5000;
		return days * price;
	}
	
}
