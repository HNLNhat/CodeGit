package kieulop;

public class TiepThi extends NhanVien{
    public double doanhSoBanHang;
    public double tyLeHoaHong;

    public TiepThi(double doanhSoBanHang, double tyLeHoaHong, String maNv, String hoTen, double luong) {
        super(maNv, hoTen, luong);
        this.doanhSoBanHang = doanhSoBanHang;
        this.tyLeHoaHong = tyLeHoaHong;
    }

    @Override
    public void xuat(){
        super.xuat();
        
    }
    @Override
    public double getThuNhap(){
        return luong + doanhSoBanHang * tyLeHoaHong;
    }
}
