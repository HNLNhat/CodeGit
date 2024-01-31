package Lab_4;
public class main {
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
