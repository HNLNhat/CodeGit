package Lab_4;
import java.util.Scanner;
public class Bai_3 {

 String tenSp;
 double donGia;
 double giamGia;

    public Bai_3() {
    }
 
    public Bai_3(String tenSp, double donGia, double giamGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }    
    public Bai_3(String tenSp, double donGia) {
        this(tenSp, donGia, 0);
    }


double getThueNhapKhau(){
    return donGia * 0.1;
}
void nhap(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Tên sản phẩm:");
    tenSp = sc.nextLine();
    System.out.println("Đơn giá:");
    donGia = Double.parseDouble(sc.nextLine());
    System.out.println("Giảm giá:");
    giamGia = Double.parseDouble(sc.nextLine());
}
void xuat(){
    System.out.println("Tên sản phẩm:" + tenSp);
    System.out.println("Đơn giá:" + donGia);
    System.out.println("Giảm giá:" + giamGia);
    System.out.println("Thuế nhập khẩu:" + getThueNhapKhau());
}
public static void main(String[] args){   
   SanPham sp1 = new SanPham();
   SanPham sp2 = new SanPham("Kẹo",10000);
    sp1.nhap();
    System.out.println("Thông tin sản phẩm đã nhập :");
    sp1.xuat();
    sp2.xuat();  
}
}
  

