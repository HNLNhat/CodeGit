package Lab_2;

import java.util.Scanner;
public class Bai_2 {
 public static void giaiPTB2(){
     System.out.println("Moi nhap 3 he so a,b,c");
     Scanner s = new Scanner(System.in);
     int a = Integer.parseInt(s.nextLine());
     int b = Integer.parseInt(s.nextLine());
     int c = Integer.parseInt(s.nextLine());
     if (a==0){
         if(b==0){
             if(c==0){
                 System.out.println("PT vo so nghiem");            
             }else{
                 System.out.println("PT vo nghiem");
             }
         }
         else
         {
   System.out.printf("PT co nghiem: x=%.1f",(float)(-c/b));
         }
     }
     else{
         int delta = b*b-4*a*c;
         if(delta<0)
         {
             System.out.println("PT vo nghiem");    
         }
         else if(delta==0){
             System.out.printf("PT co nghiem duy nhat: x=%.1f",(float)(-b/2*a));
         }else{
             float canDelta = ((float)Math.sqrt(delta));
             float x1 = (-b+canDelta)/(2*a);
             float x2 = (-b-canDelta)/(2*a);
             System.out.printf("x1=%.1f; x2=%.1f",x1,x2);
         }   
     }    
 }
 public static void main(String[] args){
giaiPTB2();     
 }
}
         

