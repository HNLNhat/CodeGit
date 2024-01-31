
package Lab_6;

import java.util.ArrayList;

public class Bai_2 {
    ArrayList<SanPham> list = new ArrayList<>();
    public Bai_2(){
    System.out.println("Nhập 5 sản phẩm:");
    for(int i=0;i<2;i++){
    SanPham sp=new SanPham();
    sp.nhap();
    list.add(sp);
    }
    System.out.println("Xuất sản phẩm");
            for(SanPham sp:sp){
  
    if(sp.getHang().equalsIgnoreCase("nokia")){
          sp.xuat();
          System.out.println("");
    }
    };
    
    }
    public static void main(String[] args) {
        new Bai_2();
    }
}
   

