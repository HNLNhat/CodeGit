package Lab_1;
import java.util.Scanner;
public class Bai_5 {
public static void main(String[]args){
Scanner scan = new Scanner(System.in);
System.out.print("Ten hang:");
String name = scan.nextLine();
System.out.print("So luong:");
int soLuong = scan.nextInt();
System.out.print("Don gia (VND):");
double gia = scan.nextDouble();
double thanhTien = soLuong*gia;
System.out.printf("Thanh tien:%.0f vnd",thanhTien);
}
}
