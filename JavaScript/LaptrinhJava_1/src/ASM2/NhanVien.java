
package ASM_2;

import java.util.Scanner;

public class NhanVien {
    
    private String ma,ten;
    Double luong;
   

    public String getMa() {
        return ma;
    }

    public void setMa(String m) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setT(String t) {
        this.ten = ten;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public NhanVien(String m, String t, Double luong) {
        this.ma = ma;
        this.ten = ten;
        this.luong = luong;
    }

    public NhanVien() {
    }
    /* phuong thuc */
    public Double getThuNhap(){
        return luong;
    }
    public Double getThue(){
        Double thue;
        if(this.getThuNhap()<9000000) {
            thue = 0.0;
        }
        else if(this.getThuNhap() < 15000000) {
            thue = 0.10*this.getThuNhap();
        }
        else{
            thue = 0.15*this.getThuNhap();
        }
        return thue;
    }
    public void nhapThongtin(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ma: ");
        this.ma = sc.nextLine();
        if(!this.ma.isEmpty()){
            System.out.printf("Ho ten: ");
            this.ten = sc.nextLine();
            System.out.printf("Luong: ");
            this.luong = sc.nextDouble();
        }
    
    }
    public void xuatThongtin(){
        System.out.println("Ma: "+"" + this.ma);
        System.out.println("Ho va Ten: "+"" + this.ten);
        System.out.println("Luong: "+""+this.luong);
    }
    public double getthunhap(){      
            return this.luong;
    }
  public double getthue(){
      double thue = 0;
      if(this.getthue()<9000000){
          thue = 0.0;
      }else if(this.getthue()<15000000){
          thue = 0.1;
      }else{
          thue = 0.15;
      }
      return thue;
  }
}


