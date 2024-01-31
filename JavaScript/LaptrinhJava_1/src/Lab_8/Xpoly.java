
package Lab_8;

import java.util.Scanner;

public class Xpoly {
public static final double sum(double...num){
      double tong = 0;
      for(double item : num){
          tong += item;
      }
      return tong;
}
public static final double min(double...num ){
     double min = num[0];
      for (double item : num){
          min = Math.min(min,item);
      }
      return min;
 }
public static final double max(double...num){
     double max = num[0];
      for (double item : num){
          max = Math.max(max,item);
      }
      return max;   
 }
public static String toUpperFirstChar (String s){

     String[] ars = s.split(" ");
   
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<ars.length; i++){
        String item =ars[i];
        if(!item.equals("")){
            String ch = item.substring(0, 1).toUpperCase();
            item = ch + item.substring(1).toLowerCase();
            sb.append(item).append(" ");
        }
    }
  return sb.toString().trim();
}
public static void main(String[]args){
 
    double sum = sum(5,4,3,2,6);
    System.out.println("Ket qua=" +sum);
    
    double ketqua;
    ketqua=min(5,6,7,8);
    System.out.println("Min ="+ketqua);
    ketqua=max(5,6,7,8,10);
    System.out.println("Max ="+ketqua);
    
    String ten = toUpperFirstChar("huynh     nhat     nam");
    System.out.println("Ten:"+ten);
    
    String name = "huynh ngoc long nhat";
    String newTen = toUpperFirstChar(name);
    System.out.println("Ho ten:"+newTen);
   
}
}





