package com.hms.Hms;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
       Reception r=new Reception();
       /*r.addCustomer(new Booking("Manoj","Deluxe",6));
       r.addCustomer(new Booking("Sanoj","Standard",2));
       r.addCustomer(new Booking("Nanoj","Deluxe",3));
       r.addCustomer(new Booking("Paloj","Standard",4));
       r.addCustomer(new Booking("Suraj","Deluxe",1));*/
       
      
       r.viewAllBookings();
       
      
       r.updateBooking(new Booking("Goapl","Standard",9),4);
       r.updateBooking(new Booking("Mopal","Deluxe",12),5);
       
     
       r.viewBooking(4);
       
      
       r.deleteBooking(5);
       
       r.viewAllBookings();
       
       
    }
}
