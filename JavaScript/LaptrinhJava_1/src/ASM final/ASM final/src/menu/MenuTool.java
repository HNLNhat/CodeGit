
package menu;

import java.util.ArrayList;
import kieulop.NhanVien;
import static thuvien.NhapDanhSach.nhapNhanVien;
import static thuvien.NhapDanhSach.nhapTiepThi;
import static thuvien.NhapDanhSach.nhapTruongPhong;
import static thuvien.TimSuaXoaTheoMa.suaDoanhSoBanHang;
import static thuvien.TimSuaXoaTheoMa.suaLuong;
import static thuvien.TimSuaXoaTheoMa.suaLuongTrachNhiem;
import static thuvien.TimSuaXoaTheoMa.suaTen;
import static thuvien.TimSuaXoaTheoMa.suaTyLeHoaHong;
import static thuvien.XuatDanhSach.xuat;
import static thuvien.XuatDanhSach.xuatLuong;
import static thuvien.XuatDanhSach.xuatMa;
import static thuvien.dulieu.nhapInt;
import static thuvien.dulieu.nhapString;

public class MenuTool {
    public static void menuNhap(ArrayList <NhanVien> dsnv){
        while(true){
            System.out.println("1. Nhập Nhân Viên");
            System.out.println("2. Nhập Trưởng Phòng");
            System.out.println("3. Nhập Tiếp Thị");
            int chon = nhapInt("Chọn kiểu nhập nhân viên: ");
            switch(chon){
                case 1: nhapNhanVien(dsnv); break;
                case 2: nhapTruongPhong(dsnv); break;
                case 3: nhapTiepThi(dsnv);
            }
            String exit = nhapString("Thoát khỏi chức năng nhập chọn 'n':  ");
            if(exit.equalsIgnoreCase("N")) break;
        }                
    }
    public static void menuXuat (ArrayList <NhanVien> dsnv) {
        while(true){
            System.out.println("1. Xuất tất cả nhân viên:  ");
            System.out.println("2. Xuất nhân viên theo mã:  ");
            System.out.println("3. Xuất nhân viên theo khoảng lương:  ");
            int chon = nhapInt("Chọn kiểu xuất nhân viên: ");
            switch(chon){
                case 1:  xuat(dsnv); break;
                case 2:  xuatMa(dsnv); break;
                case 3:  xuatLuong(dsnv); 
            }
            String exit = nhapString("Thoát khỏi chức năng nhập chọn 'n':  ");
            if(exit.equalsIgnoreCase("N")) break;
         }
    }
    public static void menuSua(ArrayList <NhanVien> dsnv) {
        while(true){
            System.out.println("1. Sửa họ và tên nhân viên: ");
            System.out.println("2. Sửa lương nhân viên");
            System.out.println("3. Sửa lương trách nhiệm");
            System.out.println("4. Sửa doanh số bán hàng");
            System.out.println("5. Sửa tỷ lệ hoa hồng");
            int chon = nhapInt("Chọn kiểu sửa nhân viên: ");
            switch(chon){
                case 1: suaTen(dsnv); break;
                case 2: suaLuong(dsnv); break;
                case 3: suaLuongTrachNhiem(dsnv); break;
                case 4: suaDoanhSoBanHang(dsnv); break;
                case 5: suaTyLeHoaHong(dsnv); 
            }
            String exit = nhapString("Thoát khỏi chức năng nhập chọn 'n':  ");
            if(exit.equalsIgnoreCase("N")) break;
}
    }
}