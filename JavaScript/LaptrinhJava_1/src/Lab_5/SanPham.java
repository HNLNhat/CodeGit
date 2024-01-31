/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5baitap;

/**
 *
 * @author Hp
 */
public class SanPham {
    private String tenSp;
    private double gia;
    public SanPham(){
        this.tenSp = null;
        this.gia=0;
    }
    public SanPham(String tenSp , double gia){
        this.tenSp = tenSp;
        this.gia= gia;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
        
}
