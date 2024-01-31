package Lab_1;
import java.util.Scanner;
public class Bai_1 {
   public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
       String hoTen;
       double diemTB;
       
       System.out.print("Nhap ho ten ?");
       hoTen = sc.nextLine();
       System.out.print("Nhap diem TB ?");
       diemTB = sc.nextDouble();
       System.out.printf("%s %f",hoTen,diemTB);
   }
}
