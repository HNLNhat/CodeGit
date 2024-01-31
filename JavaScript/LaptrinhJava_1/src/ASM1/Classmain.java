package ASM;
import static thuvien.Nhapkieudulieu.nhapInt;
import static thuvien.Nhapkieudulieu.nhapString;
public class Classmain {
   public static void main(String[]args){
       do{
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
   int n=nhapInt("Moi chon:");
   switch(n){
        case 1: System.out.println("Goi menu nhap");
       break;
        case 2: System.out.println("Goi menu xuat");
       break;
       case 3: System.out.println("Goi menu tim va hien thi NV");
       break;
        case 4: System.out.println("Goi menu xoa NV");
       break; 
        case 5: System.out.println("Goi menu cap nhat thong tin NV");
       break;
        case 6: System.out.println("Goi menu tim NV");
       break;
        case 7: System.out.println("Goi menu sap xep NV theo ho ten");
       break;
        case 8: System.out.println("Goi menu sap xep NV theo thu nhap");
       break;
       case 9: System.out.println("Goi menu xuat 5 NV");
       break;
   }
   String ch= nhapString("Neu muon thoat khoi chuong trinh go N\n:");
   if(ch.equalsIgnoreCase("N"))
       break;
       }while(true);
       }
}

