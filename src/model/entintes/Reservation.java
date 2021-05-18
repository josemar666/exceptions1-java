/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entintes;

import exceptions.entintes.DomainException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    private Integer rooNumber;
    private Date checkin;
    private Date  checkout;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation(){
        
    }

    public Reservation(Integer rooNumber, Date checkin, Date checkout)  {
         if(!checkout.after(checkin)){
               throw new DomainException ("check - out must  be after  check in date !");
              }
        this.rooNumber = rooNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRooNumber() {
        return rooNumber;
    }

    public void setRooNumber(Integer rooNumber) {
        this.rooNumber = rooNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    

    public Date getCheckout() {
        return checkout;
    }
    public long duration(){
         long diff = checkout.getTime() - checkin.getTime();
         return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
   public void upDate(Date checkin , Date checkout){
               Date now = new Date();
              if(checkin.before(now) || checkout.before(now)){
              throw new DomainException( " Reservation dates of updates  must be future !");
              }
              if(!checkout.after(checkin)){
               throw new DomainException ("check - out must  be after  check in date !");
              }
              this.checkin = checkin;
              this.checkout = checkout;
              
   }

   @Override
   public String toString(){
       return " Room : "
               + rooNumber
               + ", checkin : "
               + sdf.format(checkin)
               + ", checkout : "
               + sdf.format(checkout)
               + " , "
               + duration()
               + " nitghs";
   }
}
