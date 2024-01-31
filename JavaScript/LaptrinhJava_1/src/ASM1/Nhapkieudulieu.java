package thuvien;

import java.util.Scanner;

public class Nhapkieudulieu {
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
      public static String nhapString(String loinhac) {
     String ch;
     while(true){
         System.out.print(loinhac);
         try{
             ch= input.nextLine();
             break;
         } catch(Exception ex){
             System.out.println("Phải nhập đúng số");
         }
     }
     return ch;
    }
}
