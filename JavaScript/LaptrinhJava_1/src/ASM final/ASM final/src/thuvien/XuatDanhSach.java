package thuvien;

import java.util.ArrayList;
import kieulop.NhanVien;
import static thuvien.dulieu.nhapDouble;
import static thuvien.dulieu.nhapString;


public class XuatDanhSach {
    public static void xuat(ArrayList <NhanVien> dsnv) {
        for( NhanVien x : dsnv) x.xuat();
    }
    
    public static void xuatMa(ArrayList <NhanVien> dsnv) {
        String maNV = nhapString("Nhập mã nhân viên để xuất: ");
        for( NhanVien x : dsnv)
            if(x.maNv.equalsIgnoreCase(maNV)) x.xuat();
    }
    public static void xuatLuong(ArrayList <NhanVien> dsnv) {
        double min = nhapDouble("Nhập lương nhân viên thấp nhất: ");
        double max = nhapDouble("Nhập lương nhân viên cao nhất: ");
        for( NhanVien x : dsnv)
            if(x.luong >= min && x.luong <= max) x.xuat();
    }
    public static void xuat5CaoNhat(ArrayList <NhanVien> dsnv) {
        for (int i = 0; i < 5; i++) dsnv.get(i).xuat();
    }
}
