package Lab_1;
import java.lang.Math;
import java.util.Scanner;
public class Bai_3 {
public static void main(String[]args){
Scanner scan = new Scanner(System.in);
double canh,theTich;
System.out.print("Nhap vao canh cua khoi lap phuong(cm):");
canh = scan.nextDouble();
theTich = Math.pow(canh,3);
System.out.println("The tich cua khoi lap phuong la"+theTich+"cm^3");
}   
}
