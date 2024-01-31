package Lab_4;

import java.util.Scanner;

public class TaiKhoanNganHang {

public String maTk,hoTen;
public int soDu, rut;
static Scanner sc = new Scanner(System.in);

    public TaiKhoanNganHang() {
    }

public void nhap(){
    System.out.println("Ma tai khoan?");
    this.maTk = sc.nextLine();
    System.out.println("Ho va ten?");
    this.hoTen = sc.nextLine();
    System.out.println("So du tai khoan?");
    this.soDu = Integer.parseInt(sc.nextLine());
    
}
 public void xuat(){
     System.out.println("----------------");
     System.out.println("Ma tai khoan:" +this.maTk);
     System.out.println("Ho va ten:" +this.hoTen);
     System.out.println("So du tai khoan:" +this.soDu);
     System.out.println("----------------");
 }
  public TaiKhoanNganHang(String maTk, String hoTen, int soDu) {
        this.maTk = maTk;
        this.hoTen = hoTen;
        this.soDu = soDu;
  }
 
 public void RutTien(){
     System.out.println("Nhap so tien muon rut:");
     int rut  = Integer.parseInt(sc.nextLine());
     if(this.soDu >= rut){
         System.out.println("Giao dich thanh toan thanh cong"); 
     }else{
         System.out.println("So du tai khoan cua quy khach khong du. Giao dich khong thanh công!");
     }     
     }
 public static void main(String[] args){
    TaiKhoanNganHang TK = new TaiKhoanNganHang();
    TaiKhoanNganHang RT = new TaiKhoanNganHang(); 
     TK.nhap();
     System.out.println("Thong tin tai khoan");
     TK.xuat();
     RT.RutTien();
    

  
   
     
    
 }
}