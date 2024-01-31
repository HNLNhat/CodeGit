package Lab_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai_2{
    private ArrayList<String> ds = new ArrayList<>();
    
    public void nhap(){
        ds.clear();
 Scanner scanner = new Scanner(System.in);
 System.out.println("Nhập danh sách họ tên");
 while(true){
 System.out.print("Nhập họ tên:");
 String ten = scanner.nextLine();
 if (ten.isEmpty()){
     System.out.println("Nhập dữ liệu thành công!");
     break;
 }
         ds.add(ten);
 }
}
 public void xuat(){
 System.out.println("----------------------------");
 for (String item : ds){
     System.out.println(item);
 }
 }
public void xuatNgauNhien(){
    Collections.shuffle(ds);  
        xuat(); 
} 
public void sapXep(){
    Collections.sort(ds);
    Collections.reverse(ds);
    xuat();
}
public void xoa(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập vào tên muốn xóa:");
    String hoTen = scanner.nextLine();
    
    for (String item :ds){
        if (item.equalsIgnoreCase(hoTen)){
            ds.remove(item);
            System.out.println("Xóa họ tên thành công");
            break;
        }
    }
}
   public void menu(){
Scanner scanner = new Scanner(System.in);
int chon = 0;
       do{ 
           System.out.println("*            MENU           *");
           System.out.println("* 1.Nhập danh sách họ tên   *");
           System.out.println("* 2.Xuất danh sách vừa nhập *");
           System.out.println("* 3.Xuất ngẫu nhiên         *");
           System.out.println("* 4.Sắp xếp giảm dần        *");
           System.out.println("* 5.Tìm và xóa              *");
           System.out.println("* 0.Thoát                   *");
           System.out.print  (" Mời chọn:\n               ");
           chon = scanner.nextInt();
           switch(chon){
               case 0: 
               break;
               case 1: nhap();
               break;
               case 2: xuat();
               break;
               case 3: xuatNgauNhien();
               break;
               case 4: sapXep();
               break;
               case 5: xoa();
               break;
                 
           }
                    
}while (chon != 0);
}
   public static void main(String[] args){
   Bai_2 list = new Bai_2();
    list.menu();
}    
}



