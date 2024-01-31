package Lab_4;
import java.util.Scanner;
public class Bai_1 {
 String tenSp;
 double donGia,giamGia;
 static Scanner sc = new Scanner(System.in);
 
 public void nhap(){
     System.out.println("Ten san pham ?");
     this.tenSp= sc.nextLine();
     System.out.println("Don gia ?");
     this.donGia= Double.parseDouble(sc.nextLine());
     System.out.println("Giam gia ?");
     this.giamGia = Double.parseDouble(sc.nextLine());
 }
public void xuat(){
System.out.println("---------------------------------------");
System.out.println("Ten san pham"+ this.tenSp);
System.out.println("Don gia"+ this.donGia);
System.out.println("Giam gia"+ this.giamGia);
System.out.println("Thue nhap khau"+ this.getThueNhapKhau());
System.out.println("---------------------------------------");
}
public double getThueNhapKhau(){
  return this.donGia*0.1;  
}
public static void main(String[]args){
    Bai_1 sp1 = new Bai_1();
    sp1.nhap();
    sp1.xuat();
}
}
