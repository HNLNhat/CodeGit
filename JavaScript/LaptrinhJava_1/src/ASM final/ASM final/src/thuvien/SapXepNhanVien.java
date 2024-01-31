package thuvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kieulop.NhanVien;

public class SapXepNhanVien {
    public static void sapXepTheoTen(ArrayList <NhanVien> dsnv) {
        Comparator <NhanVien> cmp = new Comparator <NhanVien>(){
            @Override
            public int compare(NhanVien t, NhanVien t1){
                return t.hoTen.compareTo(t1.hoTen);
            }
        };
        Collections.sort(dsnv, cmp);
        System.out.println("Đã sắp xếp xong");
    }
    public static void sapXepTheoThuNhap(ArrayList <NhanVien> dsnv) {
        Comparator <NhanVien> cmp = new Comparator <NhanVien>(){
            @Override
            public int compare(NhanVien t, NhanVien t1){
                return t.getThuNhap()< t1.getThuNhap()? 1: -1;
            }
        };
        Collections.sort(dsnv, cmp);
        System.out.println("Đã sắp xếp xong");
    }
}
