
package Lab_6;

import java.util.Scanner;

public class SanPham {
      private String ten,hang;
    private Double  dongia;

    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHang() {
        return hang;
    }
    public void setHang(String hang) {
        this.hang = hang;
    }

    public Double getDongia() {
        return dongia;
    }

    public void setDongia(Double dongia) {
        this.dongia = dongia;
    }
    public SanPham(String ten, String hang, Double dongia) {
        this.ten = ten;
        this.hang = hang;
        this.dongia = dongia;
    }

    public SanPham() {
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập tên :");
        this.ten=sc.nextLine();
        System.out.println("Nhập hàng :");
        this.hang=sc.nextLine();
        System.out.println("Nhập đơn giá :");
        this.dongia=sc.nextDouble();
    }
    public void xuat(){
        System.out.println("Danh sách sản phẩm "+this.ten);
        System.out.println("Danh sách sản phẩm "+this.hang);
        System.out.println("Danh sách sản phẩm "+this.dongia);
    }
    
}


