package Lab_2;

import java.util.Scanner;

public class Bai_1 {

    public static void giaiPTB1() {
        System.out.println("Moi nhap 2 he so a,b");
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.nextLine());
        int b = Integer.parseInt(s.nextLine());
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            System.out.printf("Nghiem la:x=%.1f", (float) -b / a);
        }
    }

    public static void main(String[] args) {
        giaiPTB1();
    }
}
