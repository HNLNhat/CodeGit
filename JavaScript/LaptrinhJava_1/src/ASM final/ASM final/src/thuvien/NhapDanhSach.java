
package thuvien;

import java.util.ArrayList;
import kieulop.NhanVien;
import kieulop.TiepThi;
import kieulop.TruongPhong;
import static thuvien.dulieu.nhapDouble;
import static thuvien.dulieu.nhapString;



public class NhapDanhSach {
    public static void nhapNhanVien (ArrayList <NhanVien> dsnv) {
        String maNV = nhapString("Nhập mã nhân viên: ");
        String tenNV = nhapString("Nhập họ và tên nhân viên: ");
        double luong = nhapDouble("Nhập lương nhân viên: ");
        NhanVien nv = new NhanVien(maNV, tenNV, luong);
        dsnv.add(nv);
    }
    public static void nhapTruongPhong (ArrayList <NhanVien> dsnv) {
        String maNV = nhapString("Nhập mã nhân viên: ");
        String tenNV = nhapString("Nhập họ và tên nhân viên: ");
        double luong = nhapDouble("Nhập lương nhân viên: ");
        double luongTrachNhiem = nhapDouble("Nhập lương trách nhiệm: ");
        NhanVien nv = new TruongPhong(maNV, tenNV, luong, luongTrachNhiem);
        dsnv.add(nv);
    }
      public static void nhapTiepThi (ArrayList <NhanVien> dsnv) {
        String maNV = nhapString("Nhập mã nhân viên: ");
        String tenNV = nhapString("Nhập họ và tên nhân viên: ");
        double luong = nhapDouble("Nhập lương nhân viên: ");
        double doanhSoBanHang = nhapDouble("Nhập doanh số bán hàng: ");
        double tyLeHoaHong = nhapDouble("Nhập tỷ lệ hoa hồng: ");
        NhanVien nv = new TiepThi(luong, doanhSoBanHang, maNV, tenNV, tyLeHoaHong );
        dsnv.add(nv);
    }
}
