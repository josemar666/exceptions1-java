
package aplicattion;

import exceptions.entintes.DomainException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.Scanner;
import model.entintes.Reservation;


public class Program {
    public static void main(String args[]) {
                 
                 Scanner sc = new Scanner(System.in);
                 SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
                try{
                
                
                System.out.println("Room Number :");
                Integer rooNumber = sc.nextInt();
                System.out.println("check-in data ( dd/mm/yyyy) :");
                Date checkin = sdf.parse(sc.next());
                System.out.println("check - out data ( dd/mm/yyyy) :");
                Date checkout = sdf.parse(sc.next());
        
                Reservation reservation = new Reservation(rooNumber , checkin , checkout );
                  System.out.println("Reservation : " + reservation);
                  System.out.println("");
                  System.out.println("Enter data to update the reservation :");
                  System.out.println("check-in data ( dd/mm/yyyy) :");
                  checkin = sdf.parse(sc.next());
                  System.out.println("check - out data ( dd/mm/yyyy) :");
                  checkout = sdf.parse(sc.next());

                   reservation.upDate(checkin, checkout);
                   System.out.println("Reservation : " + reservation);
                }catch(ParseException e ){
                    System.out.println("Invalid date format");
                }
                catch(DomainException e){
                    System.out.println("Error in reservation : " + e.getMessage());
                }
                catch(RuntimeException e){
                    System.out.println("Erro inesperado !!!");
                }

        
                 sc.close();
        
        
        
        
        
        
        
    }
}
