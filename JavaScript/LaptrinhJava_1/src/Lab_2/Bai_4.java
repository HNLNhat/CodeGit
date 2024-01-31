package Lab_2;
import java.util.Scanner;
public class Bai_4 {
  public static void menu(){
      System.out.println("Bai 4");
      System.out.println("Moi ban chon chuc nang");
      System.out.println("+----------------------------+");
      System.out.println("| 1. Giai phuong trinh bac 1 |");
      System.out.println("| 2. Giai phuong trinh bac 2 |");
      System.out.println("| 3. Tinh tien dien          |");
      System.out.println("| 4. Thoat chuong trinh      |");
      System.out.println("+----------------------------+");
      Scanner s = new Scanner(System.in);
      int traloi = Integer.parseInt(s.nextLine());
      switch(traloi)
      {
          case 1:
              Bai_1.giaiPTB1();
              menu();
              break;
          case 2:
              Bai_2.giaiPTB2();
              menu();
              break;
          case 3:
              Bai_3.tinhTienDien();
              break;
          case 4:
              System.exit(0);
              break;
          default:
              System.out.println("Khong co chuc nang nay");
      }  
  }
  public static void main(String[]args){
  menu();
  }  
}
