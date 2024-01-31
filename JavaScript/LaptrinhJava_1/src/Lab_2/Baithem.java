package Lab_2;
import java.util.Scanner;
public class Baithem{ 
public static void main(String[]args){
    try(Scanner sc = new Scanner(System.in)){
    double x1,y1,x2,y2,x3,y3;   
    double AB,BC,AC;
        System.out.println("Nhap toa do A :\n");
        x1 = sc.nextDouble();
        System.out.println("Nhap toa do A :\n");
        y1 = sc.nextDouble();
         System.out.println("Nhap toa do B :\n");
        x2 = sc.nextDouble();
         System.out.println("Nhap toa do B :\n");
        y2 = sc.nextDouble();
         System.out.println("Nhap toa do C :\n");
        x3 = sc.nextDouble();
         System.out.println("Nhap toa do C :\n");
        y3 = sc.nextDouble();
        AB = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        BC = Math.sqrt(Math.pow(x3-x2,2)+Math.pow(y3-y2,2));
        AC = Math.sqrt(Math.pow(x3-x1,2)+Math.pow(y3-y1,2));
        System.out.println("AB =" + AB);
        System.out.println("BC =" + BC);
        System.out.println("AC =" + AC);
    if((AB==AC)||(AB==BC)||(AC==BC)){
        System.out.println("Tam giac can");
    }else{
        System.out.println("Khong phai tam giac can");
}
}
}
}

         


