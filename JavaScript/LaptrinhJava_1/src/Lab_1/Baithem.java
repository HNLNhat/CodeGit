package Lab_1;
import java.util.Scanner;
public class Baithem {
public static void main(String[]args){
Scanner scan = new Scanner(System.in);
int x1,y1,x2,y2;
float AB;
System.out.println("Nhap toa do diem A:");
x1=scan.nextInt();
x2=scan.nextInt();
System.out.println("Nhap toa do diem B:");
y1=scan.nextInt();
y2=scan.nextInt();
AB=(float)Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
System.out.println(AB);
}
}
