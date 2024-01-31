package Lab_3;
import java.util.Arrays;
import java.util.Scanner;
public class Bai_3 {
  public static void main(String[] args){
  int mang[] = new int[5];
  
  Scanner s=new Scanner(System.in);
  for (int i=0; i < mang.length; i++){
  System.out.printf("Nhap phan tu thu %d:", (i+1));
  mang[i] = s.nextInt();
  }
  System.out.println("Phan tu mang:" + Arrays.toString(mang));
  
  Arrays.sort(mang);
  
  System.out.println("Phan tu mang sau khi sap xep:" + Arrays.toString(mang));
  int min = mang[0];
  for (int i=1; i<mang.length; i++){
    min = Math.min(min,mang[i]);
      }
  System.out.println("Gia tri nho nhat:"+min);
  int sum=0, count=0;
  for (int i=0; i<mang.length; i++){
      if(mang[i] % 3 == 0){
          sum += mang[i];
          count ++;
      }
  }
  float avg = (float) sum / count;
  System.out.println("Gia tri tring binh:" + avg);
  }
  }  

