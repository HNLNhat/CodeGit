
package com.poly;

public class ChuNhat {
    double dai;
    double rong;

    public ChuNhat() {
    }

    public ChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }
    
    public double getChuVi(){      
        return (dai+rong)*2;
    }
    
    public double getDienTich(){
        return dai*rong;
    }
    
    public void xuat(){
        System.out.printf("Hình chữ nhật có chiều dài là %.1f, chiều rộng %.1f",dai,rong);
        System.out.printf("\nHình chữ nhật có chu vi là %.1f, diện tích là %.1f",getChuVi(),getDienTich());
        System.out.println();
    }
   
}

