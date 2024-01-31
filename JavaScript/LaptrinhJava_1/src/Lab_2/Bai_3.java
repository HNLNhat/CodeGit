package Lab_2;
import java.util.Scanner;
public class Bai_3 {
    public static void tinhTienDien(){
      System.out.println("Nhap so dien su dung:");
      Scanner s = new Scanner(System.in);
      float soDien = Float.parseFloat(s.nextLine());
      float tien=0;
      if (soDien<50)
      {
     tien = soDien*1000;    
      }
      else
      {
    tien = 50*1000+(soDien - 50)*1200;      
      }
      System.out.printf("So tien la:%.1f",tien);
    }
 public static void main(String[] args){
  tinhTienDien();//goi ham     
 }   
}
