
package aplicattion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.Scanner;
import model.entintes.Reservation;


public class Program {
    public static void main(String args[]) throws ParseException{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Room Number :");
        Integer rooNumber = sc.nextInt();
        System.out.println("check-in data ( dd/mm/yyyy) :");
        Date checkin = sdf.parse(sc.next());
        System.out.println("check - out data ( dd/mm/yyyy) :");
        Date checkout = sdf.parse(sc.next());
        if(!checkout.after(checkin)){
            System.out.println("Erro in Reseravation : check - out must  be after  check in date !");
        }
        else{
            Reservation reservation = new Reservation(rooNumber , checkin , checkout );
              System.out.println("Reservation : " + reservation);
              System.out.println("");
              System.out.println("Enter data to update the reservation :");
              System.out.println("check-in data ( dd/mm/yyyy) :");
              checkin = sdf.parse(sc.next());
              System.out.println("check - out data ( dd/mm/yyyy) :");
              checkout = sdf.parse(sc.next());
              
            
              
             String error =  reservation.upDate(checkin, checkout);
             if(error != null){
                 System.out.println("Error in reservation :" + error);
                            }
             else {
             System.out.println("Reservation : " + reservation);
        }
        }
        
        
        
        
        
        sc.close();
        
        
    }
}
