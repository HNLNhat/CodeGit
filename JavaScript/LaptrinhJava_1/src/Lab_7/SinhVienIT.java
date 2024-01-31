
package com.poly;

public class SinhVienIT extends SinhVienPoly{
    public double diemJava;
    public double diemHtml;
    public double diemCss;

    public SinhVienIT(double diemjava, double diemHtml, double diemCss, String hoTen) {
        super(hoTen,"It");
        this.diemJava = diemjava;
        this.diemHtml = diemHtml;
        this.diemCss = diemCss;
    }

    @Override
    public double getDiem() {
        return (diemJava*2+diemHtml+diemCss)/4;
    }
    
    
}
