
package kieulop;


public class TruongPhong extends NhanVien{
    public double luongTrachNhiem;
    public TruongPhong(String maNv, String hoTen, double luong, double luongTrachNhiem) {
        super(maNv, hoTen, luong);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    
    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Lương trách Nhiệm: "+ luongTrachNhiem);
        
    }
    @Override
    public double getThuNhap(){
        return luong + luongTrachNhiem;
}
}