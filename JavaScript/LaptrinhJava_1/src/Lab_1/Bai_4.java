package Lab_1;
import java.util.Scanner;
import java.lang.Math;
public class Bai_4 {
public static void main(String[]args){
Scanner scan = new Scanner(System.in);
int a,b,c;
double delta;
System.out.print("Nhap he so a:");
a = scan.nextInt();
System.out.print("Nhap he so b:");
b = scan.nextInt();
System.out.print("Nhap he so c:");
c = scan.nextInt();
delta = Math.pow(b,2)-4*a*c;
System.out.println("Delta:"+delta);
System.out.println("Can delta:"+Math.sqrt(delta));
}
}
