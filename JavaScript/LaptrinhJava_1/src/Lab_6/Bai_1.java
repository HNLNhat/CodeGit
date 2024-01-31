
package Lab_6;

import java.util.Scanner;

public class Bai_1 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hoten;
        System.out.println("Nhập họ tên: ");
        hoten = sc.nextLine();
        int k,n;
        k = hoten.indexOf(" ");
        System.out.println("Họ : " + hoten.substring(0, k).toUpperCase());
        
        n = hoten.lastIndexOf(" ");
        System.out.println("Tên : " +hoten.substring(n).toUpperCase());
        }
}
