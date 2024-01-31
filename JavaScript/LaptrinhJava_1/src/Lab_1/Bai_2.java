package Lab_1;
import java.util.Scanner;
import java.lang.Math;
public class Bai_2 {
public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    float dai,rong,dienTich,chuVi,canhNho;
    System.out.print("Nhap chieu dai(cm)");
    dai = scan.nextFloat();
    System.out.print("Nhap chieu rong (cm)");
    rong = scan.nextFloat();
    
    chuVi=(dai + rong)*2;
    dienTich=dai*rong;
    canhNho=Math.min(dai,rong);
    System.out.println("Chu vi hinh chu nhat:"+chuVi+"cm");
    System.out.println("Dien tich hinh chu nhat:"+dienTich+"cm");
    System.out.println("Canh nho nhat:"+canhNho+"cm");
}    
}
