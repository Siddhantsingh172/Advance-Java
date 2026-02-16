package com.hms.Hms;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
public class Reception {
	
	private static final String Print = null;
	static Configuration config=new Configuration().configure();
	static SessionFactory factory =config.buildSessionFactory();
	static Session session=factory.openSession();
	static Transaction t;
	
	public void addCustomer(Booking book)
	{
		try {
		t=session.beginTransaction();
		session.persist(book);
		t.commit();
		System.out.println("Booking Successful");
		
		}
		catch(Exception e)
		{
			System.out.println("ALready Booked");
		}
	}
	
	public void viewBooking(int bookId)
	{
		t=session.beginTransaction();
		Booking book=session.get(Booking.class,bookId);
		t.commit();
		System.out.println(book.getBookingId()+" "+book.getCustomerName()+" "+book.getRoomType()+" "+book.getDays()+" "+book.getTotalAmount());
	}
	public void updateBooking(Booking book,int bookId)
	{
		t = session.beginTransaction();
		Booking oldBooking = session.get(Booking.class,bookId);
		oldBooking.setCustomerName(book.getCustomerName());
		oldBooking.setRoomType(book.getRoomType());
		oldBooking.setDays(book.getDays());
		oldBooking.setTotalAmount(book.getTotalAmount());
		session.saveOrUpdate(oldBooking);
		t.commit();
		System.out.println("Booking has been updated...");
	}
	
	public void deleteBooking(int bookId)
	{
		t = session.beginTransaction();
		session.delete(session.get(Booking.class,bookId));
		t.commit();
		System.out.println("Booking has been deleted...");
	}
	public void viewAllBookings()
	{
		t = session.beginTransaction();
		try {
			List<Booking> bookings = session.createQuery("from Booking",Booking.class).getResultList();
			t.commit();
			for(Booking booking:bookings)
			{
				System.out.println(booking.getBookingId()+" "+booking.getCustomerName()+" "+booking.getRoomType()+" "+booking.getDays()+" "+booking.getTotalAmount());
			}
		}catch(Exception e)
		{t.rollback();
			System.out.println("Error occurred...");
		}
	}
}



