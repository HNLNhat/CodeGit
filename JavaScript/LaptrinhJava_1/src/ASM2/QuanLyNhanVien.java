
package ASM_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import static thuvien.Nhapkieudulieu.nhapString;

public class QuanLyNhanVien {
      ArrayList<text.NhanVien> dsnv = new ArrayList();

    public QuanLyNhanVien(){
        menu();
    }
    
    public static void main(String[] args) {
        new text.QuanLyNhanVien();
    }
    public void menu()
            {
        Scanner sc = new Scanner(System.in);
        int choose;
            do {
           System.out.println("*     Quan li nhan vien      *");
           System.out.println("*============================*");
           System.out.println("* 1.Nhap danh sach nv        *");
           System.out.println("* 2.Xuat danh sach nv        *");
           System.out.println("* 3.Tim va hien thi nv       *");
           System.out.println("* 4.Xoa nhan vien            *");
           System.out.println("* 5.Cap nhat thong tin nv    *");
           System.out.println("* 6.Tim cac NV               *");
           System.out.println("* 7.Sap xep NV theo ho ten   *");
           System.out.println("* 8.Sap xep NV theo thu nha  *");
           System.out.println("* 9.Xuat 5 NV                *");
           System.out.println("*============================*");
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    NhapDSNV();
                    break;
                case 2:
                    XuatDSNV();
                    break;
                case 3:
                    Timtheoma();
                    break;
                case 4:
                    Xoanvtheoma();
                    break;
                case 5:
                    Capnhatnhanvien();
                    break;
                case 6:
                    TimNVtheoluong();
                    break;
                case 7:
                    SXNVtheoten();
                    break;    
                case 8:
                    SXNVtheoluong();
                    break;
                case 9:
                    Xuat5NVluongcaonhat();
                    break;   
                default:
                    System.out.print("\nBan chon khong dung chuc nang");
            }
String ch= nhapString("Neu muon thoat khoi chuong trinh go N\n:");
   if(ch.equalsIgnoreCase("N"))
       break;
        } while (true);
    }
   public void NhapDSNV(){
        Scanner sc = new Scanner(System.in);
        do{
            text.NhanVien nv = new text.NhanVien();
            nv.nhapThongtin();
            if(!nv.getMa().isEmpty()){
                dsnv.add(nv);
            }
            else{
                break;
            }
        }while(true);
    }
    public void XuatDSNV(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh Sach Nhan Vien");
        for(text.NhanVien nv: dsnv){
            nv.xuatThongtin();
        }
    }
    public void Timtheoma(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ma nv can tim: ");
        String manv =sc.nextLine();
        int k = -1;
        for(text.NhanVien nv: dsnv) {
            if(nv.getMa().equalsIgnoreCase(manv)){
                k = dsnv.indexOf(nv);
                break;
            }
        }
        if (k >= 0) {
            text.NhanVien nv = dsnv.get(k);
            nv.xuatThongtin();
        } else {
            System.out.println("Khong tim thay nhan vien.");
        }
    }
    public void Xoanvtheoma(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nv can xoa: ");
        String Ma = sc.nextLine();
        int k = -1;
        for(text.NhanVien nv: dsnv){
            if(nv.getMa().equalsIgnoreCase(Ma)){
                k = dsnv.indexOf(nv);
                break;
            }
        }
        if(k>=0){
            text.NhanVien nv = dsnv.remove(k);
            System.out.println("Hoan tat xoa nhan vien.");
        }
        else{
            System.out.println("Nhan vien khong ton tai.");
        }
    }
    public void Capnhatnhanvien(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien:");
        String manv = sc.nextLine();
        int k = -1;
        for (text.NhanVien nv : dsnv) {
            if (nv.getMa().equalsIgnoreCase(manv)) {
                k = dsnv.indexOf(nv);
                break;
            }
        }
        if (k >= 0) {
            System.out.println("Cap nhat thong tin: ");
            text.NhanVien nvm = new text.NhanVien();
            nvm.nhapThongtin();
            text.NhanVien nv = dsnv.set(k, nvm);
        } else {
            System.out.println("Thong tin nhap vao khong ton tai.");
        }
    }
    public void TimNVtheoluong(){
        Scanner sc = new Scanner(System.in);
        Double min, max;
        System.out.print("Nhap khoang luong nho nhat: ");
        min = sc.nextDouble();
        System.out.print("Nhap khoang luong lon nhat: ");
        max = sc.nextDouble();
        for (text.NhanVien nv : dsnv){
            if (nv.getLuong() >= min && nv.getLuong() <= max) {
                nv.xuatThongtin();
            }
        }
    }
    public void SXNVtheoten(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Xin moi chon phuong thuc sap xep(T/G): ");
        String choose = sc.nextLine();
        if(choose.equalsIgnoreCase("T")){
            Comparator<text.NhanVien> name = new Comparator<text.NhanVien>(){
                @Override
                public int compare(text.NhanVien o1, text.NhanVien o2){
                    return o1.getTen().compareTo(o2.getTen());
                }
            };
            Collections.sort(dsnv, name);
        }
        else if(choose.equalsIgnoreCase("G")) {
            Comparator<text.NhanVien> name = new Comparator<text.NhanVien>(){
                @Override
                public int compare(text.NhanVien o1, text.NhanVien o2){
                    return o1.getTen().compareTo(o2.getTen());
                }
            };
            Collections.sort(dsnv, name);
            Collections.reverse(dsnv);
        }else{
            System.out.println("Vui long chi chon phuong phap sap xep T hoac G: ");
        }
    }
    public void SXNVtheoluong(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Xin moi chon phuong thuc sap xep(T/G): ");
        String choose = sc.nextLine();
        if(choose.equalsIgnoreCase("T")){
            Comparator<text.NhanVien> salary = new Comparator<text.NhanVien>(){
                @Override
                public int compare(text.NhanVien o1, text.NhanVien o2){
                    return o1.getLuong().compareTo(o2.getLuong());
                }
            };
            Collections.sort(dsnv, salary);
        }
        else if(choose.equalsIgnoreCase("G")) {
            Comparator<text.NhanVien> salary = new Comparator<text.NhanVien>(){
                @Override
                public int compare(text.NhanVien o1, text.NhanVien o2){
                    return o1.getLuong().compareTo(o2.getLuong());
                }
            };
            Collections.sort(dsnv, salary);
            Collections.reverse(dsnv);
        }else{
            System.out.println("Vui long chi chon phuong phap sap xep T hoac G: ");
        }
    }
    public void Xuat5NVluongcaonhat(){
    System.out.println("Xuat 5 nhan vien co thu nhap cao nhat");
}
}
