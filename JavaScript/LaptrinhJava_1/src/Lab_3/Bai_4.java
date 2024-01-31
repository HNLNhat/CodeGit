package Lab_3;

import java.util.Scanner;

public class Bai_4 {
 static String Tensv[] = new String[50];
    static double Diemsv[] = new double[50];
    static int n = 0;
    static void  nhap(){
            Scanner sc ;
            String choice = "y";
            do {  
                sc = new Scanner(System.in);
                System.out.println("Nhập tên sv");
                Tensv[n] = sc.nextLine();
                System.out.println("Nhập điểm cho sv");
                Diemsv[n] = sc.nextDouble();
                n++;
                System.out.println("Bạn có muốn tiếp tục nhập thông tin sv?(Y/N)");
                choice = sc.next();
            } while (choice.equalsIgnoreCase("y"));
    }
        static void xuat(){
            for(int i = 0; i < n; i++){
                  String hocluc = "";
            if (Diemsv[i]< 5) {
                hocluc = "YẾU";
            }else
                if(Diemsv[i]< 6.5){
                    hocluc = "TRUNG BÌNH";
                }else
                    if(Diemsv[i]< 7.5){
                        hocluc = "KHÁ";
                    }else 
                        if(Diemsv[i] < 9){
                            hocluc = "GIỎI";
                        }else{
                            hocluc = "XUẤT SẮC";
                        }
                    
                System.out.println("Tên sinh viên :"+ Tensv[i]+"- Diem :"+Diemsv[i]+"- Học lực :"+hocluc);
            }
        }
    public static void main(String[] args) {
        nhap();
        xuat();
    }    
}    

