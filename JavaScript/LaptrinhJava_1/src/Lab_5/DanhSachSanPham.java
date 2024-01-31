
package lab5baitap;

import Lab_4.SanPham;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachSanPham {
    private ArrayList<SanPham> list = new ArrayList();
    public void nhap(){
        System.out.println("Nhap danh sach san pham");
        do{
            Scanner sc = new Scanner(System.in);
            int i = 1;
            System.out.printf("Nhap ten san pham thu %d",i);
            String ten = sc.nextLine();
            if(ten == null || ten.equals("")){
                System.out.println("Nhap thong tin xong");
                break;
            }
            i++;
            System.out.println("gia san pham: ");
            double gia = sc.nextDouble();
            list.add(new SanPham(ten, gia));
        }while(true);
    }
    public static void xuat(){
        for (SanPham sp : list){
            System.out.println("%s | %2f \n",sp.getTenSp(),sp.getGia());
        }
    }
    public void sapXep(){
        Comparator<SanPham> comp = new Comparator<SanPham>() {
            @Override
            public int compare(SanPham o1, SanPham o2) {
                return Double.compare(o1.getGia(),o2.getGia());
            }
        };
        Collections.sort(list,comp);
        xuat();
    }
    public void timVaxoa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten muon xoa");
        String ten = sc.nextLine();
        SanPham sp = null;
        for(SanPham sp1:list){
            if(sp1.getTenSp().equals(ten)){
                sp = sp1;
                break;
            }
        }
        if(sp!=null){
          list.remove(sp);
            System.out.println("da xoa san pham");
        }else{
            System.out.println("Khong tim thay san pham");   
        }
    }
    public tinhGiaTrungBinh(){
        double avg = 0 , sum = 0;
        for(SanPham sp : list){
            sum+=sp.getGia();
        }
        avg = sum/list.size();
        System.out.println("gia trung binh la:"+ avg);
    }
    public void menuSanPham(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("1. Nhap danh sach san pham tu ban phim");
            System.out.println("2. Sap xep giam dan theo gia va xuat ra man hinh");
            System.out.println("3. Tim va xoa san pham theo ten nhap tu ban phim");
            System.out.println("4. Xuat gia tring binh cua cac san pham");
            chon = sc.nextInt();
              switch(chon){
            case 1:
             nhap();
                break;
            case 2:
             sapXep();
                break;
            case 3:
              timVaxoa();
                break;
            case 4:
               
                break;
            case 5:
               
                break;
        }
        }while(chon!=0);
}
}
