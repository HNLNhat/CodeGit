
package com.poly;

public class SinhVienBiz extends SinhVienPoly{
    public double diemMarrketing;
    public double diemSales;

    public SinhVienBiz(double diemMarrketing, double diemSales, String hoTen) {
        super(hoTen,"Biz");
        this.diemMarrketing = diemMarrketing;
        this.diemSales = diemSales;    
        
    }

    @Override
    public double getDiem() {
        return (diemMarrketing*2+diemSales)/3;
    }
       
}
