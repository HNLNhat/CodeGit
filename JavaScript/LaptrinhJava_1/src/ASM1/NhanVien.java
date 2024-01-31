package ASM2;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryan
 */
public class NhanVien {
    private String m,t;
    Double luong;

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public NhanVien(String m, String t, Double luong) {
        this.m = m;
        this.t = t;
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
        this.m = sc.nextLine();
        if(!this.m.isEmpty()){
            System.out.printf("Ho ten: ");
            this.t = sc.nextLine();
            System.out.printf("Luong: ");
            this.luong = sc.nextDouble();
        }
    }
    public void xuatThongtin(){
        System.out.println("Ma: "+"" + this.m);
        System.out.println("Ho va Ten: "+"" + this.t);
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
