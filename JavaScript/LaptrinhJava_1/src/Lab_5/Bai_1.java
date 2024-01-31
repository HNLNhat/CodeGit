package Lab_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai_1{
public static void main(String[] args){
ArrayList<Double> arrDouble = new ArrayList<Double>();
arrDouble = nhapMang();
xuatMang(arrDouble);
}
public static ArrayList<Double> nhapMang(){
    ArrayList<Double> arrDouble = new ArrayList<Double>();
    Scanner scanner = new Scanner(System.in);
    while (true){
        System.out.print("Nhập vào số ?\n");
        Double x = scanner.nextDouble();
        arrDouble.add(x);
        scanner.nextLine();
        System.out.print("Nhập thêm(Y/N)?");
        if(scanner.nextLine().equalsIgnoreCase("N")){
            break;
        }
    }
    return arrDouble;
}
public static void xuatMang(ArrayList<Double>arrDouble2){
System.out.println("Các giá trị của mảng:");
double tong=0;
for(Double d:arrDouble2){
    System.out.print(d+"\t");
    tong = tong + d;
}
    System.out.println("Tổng của mảng:" + tong);
}
}
   


