
package Lab_7;

public class Vuong extends ChuNhat{
public Vuong(Double canh){
    super (canh,canh);  
  }
    @Override
    public void xuat() {
       System.out.println("Chu vi hinh vuong:" + this.getChuvi());
    }
}
