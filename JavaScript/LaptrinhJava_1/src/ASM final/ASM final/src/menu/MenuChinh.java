
package menu;

import java.util.ArrayList;
import kieulop.NhanVien;
import static menu.MenuTool.menuNhap;
import static menu.MenuTool.menuSua;
import static menu.MenuTool.menuXuat;
import static thuvien.SapXepNhanVien.sapXepTheoTen;
import static thuvien.SapXepNhanVien.sapXepTheoThuNhap;
import static thuvien.TimSuaXoaTheoMa.xoaTheoMa;
import static thuvien.XuatDanhSach.xuat5CaoNhat;
import static thuvien.dulieu.nhapInt;
import static thuvien.dulieu.nhapString;


public class MenuChinh {
    public static void menu (ArrayList <NhanVien> dsnv) {
        while (true) {            
           System.out.println("*     Quản lí nhân viên      *");
           System.out.println("*============================*");
           System.out.println("* 1.Nhập danh sách NV        *");
           System.out.println("* 2.Xuất danh sách NV        *");
           System.out.println("* 3.Tìm và hiển thị NV       *");
           System.out.println("* 4.Xóa nhân viên            *");
           System.out.println("* 5.Cập nhật thông tin NV    *");
           System.out.println("* 6.Tìm các NV               *");
           System.out.println("* 7.Sắp xếp NV theo họ tên   *");
           System.out.println("* 8.Sắp xếp NV theo thu nhập *");
           System.out.println("* 9.Xuất 5 NV                *");
           System.out.println("*============================*");            
            int chon = nhapInt("Hãy chọn 1 chức năng: ");
            switch(chon){
                case 1: menuNhap(dsnv);         break;
                case 2: menuXuat(dsnv);         break;
                case 3: xoaTheoMa(dsnv);        break;
                case 4: menuSua(dsnv);          break;
                case 5: sapXepTheoTen(dsnv);    break;
                case 6: sapXepTheoThuNhap(dsnv);break;
                case 7: xuat5CaoNhat(dsnv);              
            }
            
            String exit = nhapString("Kết thúc trương trình chọn'y' | tiếp tục chọn 'n' ");
            if(exit.equalsIgnoreCase("Y")) break;
        }
    }
    public static void main(String[] args) {
        ArrayList <NhanVien> dsnv = new ArrayList <NhanVien>();
        menu(dsnv);
    }
}