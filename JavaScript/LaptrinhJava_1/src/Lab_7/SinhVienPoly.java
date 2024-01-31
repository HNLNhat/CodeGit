
package com.poly;

abstract public class SinhVienPoly { 
    public String hoTen;
    public String nghanh;

    public SinhVienPoly() {

    }

    public SinhVienPoly(String hoTen, String nghanh) {
        this.hoTen = hoTen;
        this.nghanh = nghanh;
    }

    abstract public double getDiem();

    
    
    public String getHocLuc() {
        double diem = getDiem();
        String hocLuc;
        if(diem<5){
            hocLuc="yeu";
        }else if(diem<7.5){
            hocLuc="Kha";
        }else if(diem<9){
            hocLuc="Gioi";
        }else{
            hocLuc="XuatSac";
        }
        return hocLuc;
    }
    
    public void xuat(){
        System.out.printf("\n- %s, %.1f diem, hoc luc %s, nghanh hoc %s,", hoTen,getDiem(),getHocLuc(),nghanh);
    }
    
    
}
