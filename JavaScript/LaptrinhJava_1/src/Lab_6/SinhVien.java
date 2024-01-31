package Lab_6;

import java.util.Scanner;

public class SinhVien {
private String hoTen;
private String email;
private String phone;
private String cmnd;

public SinhVien(){
  
} 
public SinhVien(String hoTen, String email, String phone, String cmnd){
    this.hoTen= hoTen;
    this.email= email;
    this.phone= phone;
    this.cmnd= cmnd;
}

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
public void nhap(){
    Scanner scanner = new Scanner(System.in);
    do{
        System.out.print("Mời nhập họ tên:");
        hoTen = scanner.nextLine();
        if (hoTen == null | hoTen.equals("")){
            System.out.println("Họ tên không hợp lệ!");
        }else{
       break;      
        }
    }while (true);
    
    Data ds = new Data();
    do{
     System.out.print("Nhập email:");
     email = scanner.nextLine();
     if (ds.isEmail(email)){
         break;
     }
     System.out.println("Email không hợp lệ");
     
    }while(true);
    do{
       System.out.print("Nhập số điện thoại:");
       phone = scanner.nextLine();
       if (ds.isPhone(phone)){
           break;
       }
       System.out.println("SDT không hợp lệ!");
    }while(true);
do{
 System.out.print("Nhập số CMND:");
         cmnd = scanner.nextLine();
         
         if(ds.isCMND(cmnd)){
             break;
         }
         System.out.println("CMND không hợp lệ!");
}while(true);
}
public void xuat(){
    System.out.printf("Ho ten: %s - Email: %s - SDT: %s - CMND: %s \n", hoTen,email,phone,cmnd);
}
}
