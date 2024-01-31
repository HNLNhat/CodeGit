package Lab_3;
import java.util.Scanner;
public class Bai_1 {
public static void main(String[] args){
int n;
boolean ok = true;
Scanner s = new Scanner(System.in);
System.out.println("Nhap n:");
n = s.nextInt();
for (int i=2; i<n-1; i++){
    if(n % i == 0){
        ok = false;
        break;
    }
    i++;
}
if (ok == true){
    System.out.println(""+ n + " La so nguyen to");
}else{
    System.out.println(""+ n + " Khong phai so nguyen to");
}
}    
}
