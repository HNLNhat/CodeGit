package Lab_6;

import java.util.ArrayList;

public class DanhSachSinhVien {
 private ArrayList<SinhVien> list = new ArrayList();
 
 public void nhap(){
     for (int i=0; i<2;i++){
         SinhVien sv = new SinhVien();
         sv.nhap();
         list.add(sv);
     }
 }
 public void xuat(){
     System.out.println("-----------------");
     System.out.println("Danh sách danh viên");
     for (SinhVien item : list){
         item.xuat();
     }
 }
}
