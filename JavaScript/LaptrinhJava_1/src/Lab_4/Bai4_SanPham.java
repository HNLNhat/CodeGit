package Lab_4;

import java.util.Scanner;

public class Bai4_SanPham {
 private String tenSp;
 private double donGia;
 private double giamGia;

    public Bai4_SanPham() {
    }

    public Bai4_SanPham(String tenSp, double donGia, double giamGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }    

    public Bai4_SanPham(String tenSp, double donGia) {
        this(tenSp, donGia, 0);
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
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
    SanPham sp2 = new SanPham();
    SanPham sp3 = new SanPham("Kẹo",12000);
    sp1.nhap();
    System.out.println("");
    sp2.nhap();
    System.out.println("Thông tin sản phẩm đã nhập :");
    sp1.xuat();
    sp2.xuat();
    sp3.xuat();
}
}
   
