
package thuvien;

import java.util.Scanner;


public class dulieu {
    static Scanner input = new Scanner(System.in);
    public static int nhapInt(String loinhac) {
     int i;
     while(true){
         System.out.print(loinhac);
         try{
             i= Integer.parseInt(input.nextLine());
             break;
         } catch(Exception ex){
             System.out.println("Phải nhập đúng số");
         }
     }
     return i;
    }
    
    
    
     public static String nhapString(String loinhac) {
     String ch;
     while(true){
         System.out.print(loinhac);
         try{
             ch= input.nextLine();
             break;
         } catch(Exception ex){
             System.out.println("Phải nhập đúng ");
         }
     }
     return ch;
    }
     
   public static float nhapfloat(String loinhac) {
     float f;
     while(true){
         System.out.print(loinhac);
         try{
             f= Float.parseFloat(input.nextLine());
             break;
         } catch(Exception ex){
             System.out.println("Phải nhập đúng số");
         }
     }
     return f;
    }   
   
    public static double nhapDouble(String loinhac) {
     double d;
     while(true){
         System.out.print(loinhac);
         try{
             d = Double.parseDouble(input.nextLine());
             break;
         } catch(Exception ex){
             System.out.println("Phải nhập đúng số");
         }
     }
     return d;
    }   
     
}


