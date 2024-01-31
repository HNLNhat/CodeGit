
package com.poly;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab7Bai4 {

    static ArrayList<SinhVienPoly> arlSV = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
 
        while (true) {            
            menu();
        }
    }
    private static void menu() {
        int chon;
        do{
        System.out.println("Chuong Trinh Quan Ly Sinh Vien\n");
        System.out.println("1 Nhap danh sach sinh vien");
        System.out.println("2 Xuat thong tin sinh vien");
        System.out.println("3 Xuat danh sach sinh vien co hoc luc gioi");
        System.out.println("4 Sap xep danh sach sinh vien theo diem");
        System.out.println("5 Ket thuc");
        System.out.print("\nMoi chon chuc nang: ");
        chon = sc.nextInt();
        
    }while ( chon <1 || chon >5);
    sc.nextLine();
    switch (chon){
        case 1:
           System.out.println("1 Nhap danh sach sinh vien");
           nhapDSSV();
           break;
        case 2:
           System.out.println("1 Nhap danh sach sinh vien");
           xuatDSSV();
           break;
        case 3:
           System.out.println("1 Nhap danh sach sinh vien");
           SVGioi();
           break;
        case 4:
           System.out.println("1 Nhap danh sach sinh vien");
           sapXep();
           break;
        case 5:
            System.out.println("5 Ket thuc");
           break;
    } 
    }

    private static void nhapDSSV() {
        for (int i = 0; i < 3; i++) {
                    SinhVienPoly sv = null;
        System.out.print("Nhap ho ten Sv: ");
        String hoTen = sc.nextLine();
        System.out.print("Chon Nghanh Hoc (1-> IT; 2-> Biz): ");
        int nghanh = sc. nextInt();
        if (nghanh == 1){
            System.out.println("Nhap diem java: ");
            double java = sc . nextDouble();
            System.out.println("Nhap diem Html: ");
            double html = sc . nextDouble();
            System.out.println("Nhap diem Css: ");
            double css = sc . nextDouble();
            sv = new SinhVienIT(java, html, css, hoTen);
        }else{
            
        }
        sc.nextLine();
        arlSV.add(sv);
        }

    }

    private static void xuatDSSV() {
        System.out.println("Xuat thong tin sinh vien co trong danh sach.\n");
        for(SinhVienPoly sv: arlSV){
            sv.xuat();
        }
        System.out.println("");
    }

    private static void SVGioi() {
        System.out.println("Xuat thong tin sinh vien gioi.\n");
        for(SinhVienPoly sv: arlSV){
            if(sv.getDiem()>=7.5 && sv.getDiem()<9){
                sv.xuat();
            }
        }
        System.out.println("");  
    }

    private static void sapXep() {
        
    }
}

