package thuvien;

import java.util.ArrayList;
import kieulop.NhanVien;
import kieulop.TiepThi;
import kieulop.TruongPhong;
import static thuvien.dulieu.nhapDouble;
import static thuvien.dulieu.nhapString;


public class TimSuaXoaTheoMa {
    public static int timTheoMa(ArrayList <NhanVien> dsnv, String ma) {
        int i;
        for (i = 0; i < dsnv.size(); i++) 
            if(dsnv.get(i).maNv.equalsIgnoreCase(ma)) break;
        return i;   
    }
    public static void xoaTheoMa(ArrayList <NhanVien> dsnv){
        String maNv = nhapString("Nhập mã nhân viên cần xóa: ");
        int i = timTheoMa(dsnv, maNv);
        dsnv.remove(i);
    }
    public static void suaTen(ArrayList <NhanVien> dsnv) {
        String maNv = nhapString("Nhập mã nhân viên: ");
        String hoTen = nhapString("Nhập họ và tên nhân viên: ");
        int i = timTheoMa(dsnv, maNv);
        dsnv.get(i).hoTen = hoTen;
    }
    public static void suaLuong(ArrayList <NhanVien> dsnv) {
        String maNv = nhapString("Nhập mã nhân viên: ");
        double luong = nhapDouble("Nhập lương nhân viên: ");
        int i = timTheoMa(dsnv, maNv);
        dsnv.get(i).luong = luong;
    }
    public static void suaLuongTrachNhiem(ArrayList <NhanVien> dsnv) {
        String maNv = nhapString("Nhập mã nhân viên: ");
        int i = timTheoMa(dsnv, maNv);
        if(dsnv.get(i) instanceof TruongPhong){
            double luongTrachNhiem = nhapDouble("Nhập lương trách nhiệm: ");
            ((TruongPhong)dsnv.get(i)).luongTrachNhiem = luongTrachNhiem;
        }else System.out.println("Không phải là Trưởng Phòng");
    }
    public static void suaDoanhSoBanHang(ArrayList <NhanVien> dsnv) {
        String maNv = nhapString("Nhập mã nhân viên: ");
        int i = timTheoMa(dsnv, maNv);
        if(dsnv.get(i) instanceof TiepThi){
            double doanhSoBanHang = nhapDouble("Nhập doanh số bán hàng: ");
            ((TiepThi)dsnv.get(i)).doanhSoBanHang = doanhSoBanHang;
        }else System.out.println("Không phải là Tiếp Thị");
    }
    public static void suaTyLeHoaHong(ArrayList <NhanVien> dsnv) {
        String maNv = nhapString("Nhập mã nhân viên: ");
        int i = timTheoMa(dsnv, maNv);
        if(dsnv.get(i) instanceof TiepThi){
            double tyLeHoaHong = nhapDouble("Nhập tỷ lệ hoa hồng: ");
            ((TiepThi)dsnv.get(i)).tyLeHoaHong = tyLeHoaHong;
        }else System.out.println("Không phải là Tiếp Thị");
    }
}