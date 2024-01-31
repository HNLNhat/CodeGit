/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASM2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

/**
 *
 * @author ryan
 */
public class QuanlyNhanVien {
    ArrayList<NhanVien> dsnv = new ArrayList();

    public QuanlyNhanVien(){
        menu();
    }
    
    public static void main(String[] args) {
        new QuanlyNhanVien();
    }
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int choose;
            do {
            System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
            System.out.println("|1.Nhap danh sach nhan vien                  |");
            System.out.println("|2.Xuat danh sach nhan vien                  |");
            System.out.println("|3.Tim va hien thi nhan vien theo ma         |");
            System.out.println("|4.Xoa nhan vien theo ma                     |");
            System.out.println("|5.Cap nhat thong tin nhan vien theo ma      |");
            System.out.println("|6.Tim nhan vien theo luong                  |");
            System.out.println("|7.Sap xep nhan vien theo ho va ten          |");
            System.out.println("|8.Sap xep nhan vien theo thu nhap           |");
            System.out.println("|9.Xuat 5 nhan vien co thu nhap cao nhat     |");
            System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
            System.out.println("Chon chuc nang: ");
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    NhapDSNV();
                    break;
                case 2:
                    XuatDSNV();
                    break;
                case 3:
                    Timnvtheoma();
                    break;
                case 4:
                    Xoanvtheoma();
                    break;
                case 5:
                    Capnhatnhanvien();
                    break;
                case 6:
                    Tinnvtheoluong();
                    break;
                case 7:
                    Sxnvtheoten();
                    break;    
                case 8:
                    Sxnvtheoluong();
                    break;
                case 9:
                    Xuat5nvluongcaonhat();
                    break;   
                default:
                    System.out.print("\nBan chon khong dung chuc nang");
            }

        } while (true);
    }
    
    public void NhapDSNV(){
        Scanner sc = new Scanner(System.in);
        do{
            NhanVien nv = new NhanVien();
            nv.nhapThongtin();
            if(!nv.getM().isEmpty()){
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
        for(NhanVien nv: dsnv){
            nv.xuatThongtin();
        }
    }
    public void Timnvtheoma(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ma nv can tim: ");
        String manv =sc.nextLine();
        int k = -1;
        for(NhanVien nv: dsnv) {
            if(nv.getM().equalsIgnoreCase(manv)){
                k = dsnv.indexOf(nv);
                break;
            }
        }
        if (k >= 0) {
            NhanVien nv = dsnv.get(k);
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
        for(NhanVien nv: dsnv){
            if(nv.getM().equalsIgnoreCase(Ma)){
                k = dsnv.indexOf(nv);
                break;
            }
        }
        if(k>=0){
            NhanVien nv = dsnv.remove(k);
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
        for (NhanVien nv : dsnv) {
            if (nv.getM().equalsIgnoreCase(manv)) {
                k = dsnv.indexOf(nv);
                break;
            }
        }
        if (k >= 0) {
            System.out.println("Cap nhat thong tin: ");
            NhanVien nvm = new NhanVien();
            nvm.nhapThongtin();
            NhanVien nv = dsnv.set(k, nvm);
        } else {
            System.out.println("Thong tin nhap vao khong ton tai.");
        }
    }
    public void Tinnvtheoluong(){
        Scanner sc = new Scanner(System.in);
        Double min, max;
        System.out.print("Nhap khoang luong nho nhat: ");
        min = sc.nextDouble();
        System.out.print("Nhap khoang luong lon nhat: ");
        max = sc.nextDouble();
        for (NhanVien nv : dsnv){
            if (nv.getLuong() >= min && nv.getLuong() <= max) {
                nv.xuatThongtin();
            }
        }
    }
    public void Sxnvtheoten(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Xin moi chon phuong thuc sap xep(T/G): ");
        String choose = sc.nextLine();
        if(choose.equalsIgnoreCase("T")){
            Comparator<NhanVien> name = new Comparator<NhanVien>(){
                @Override
                public int compare(NhanVien o1, NhanVien o2){
                    return o1.getT().compareTo(o2.getT());
                }
            };
            Collections.sort(dsnv, name);
        }
        else if(choose.equalsIgnoreCase("G")) {
            Comparator<NhanVien> name = new Comparator<NhanVien>(){
                @Override
                public int compare(NhanVien o1, NhanVien o2){
                    return o1.getT().compareTo(o2.getT());
                }
            };
            Collections.sort(dsnv, name);
            Collections.reverse(dsnv);
        }else{
            System.out.println("Vui long chi chon phuong phap sap xep T hoac G: ");
        }
    }
    public void Sxnvtheoluong(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Xin moi chon phuong thuc sap xep(T/G): ");
        String choose = sc.nextLine();
        if(choose.equalsIgnoreCase("T")){
            Comparator<NhanVien> salary = new Comparator<NhanVien>(){
                @Override
                public int compare(NhanVien o1, NhanVien o2){
                    return o1.getLuong().compareTo(o2.getLuong());
                }
            };
            Collections.sort(dsnv, salary);
        }
        else if(choose.equalsIgnoreCase("G")) {
            Comparator<NhanVien> salary = new Comparator<NhanVien>(){
                @Override
                public int compare(NhanVien o1, NhanVien o2){
                    return o1.getLuong().compareTo(o2.getLuong());
                }
            };
            Collections.sort(dsnv, salary);
            Collections.reverse(dsnv);
        }else{
            System.out.println("Vui long chi chon phuong phap sap xep T hoac G: ");
        }
    }
    public void Xuat5nvluongcaonhat(){

    }
}
