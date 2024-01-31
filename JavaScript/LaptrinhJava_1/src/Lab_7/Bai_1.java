
package Lab_7;

import java.util.Scanner;

public class Bai_1 {
public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    Double dai,rong,canh;
    System.out.print("Nhập dài,rộng,cạnh:");
    dai = sc.nextDouble();
    rong = sc.nextDouble();
    canh = sc.nextDouble();
    ChuNhat cn = new ChuNhat(dai,rong);
    Vuong vu = new Vuong(canh);
    cn.xuat();  
    vu.xuat();
}
}
