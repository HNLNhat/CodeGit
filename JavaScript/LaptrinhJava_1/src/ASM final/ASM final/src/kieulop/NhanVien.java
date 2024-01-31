package kieulop;

public class NhanVien {
    public String maNv;
    public String hoTen;
    public double luong;

    public NhanVien(String maNv, String hoTen, double luong) {
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.luong = luong;
    }
    public void xuat(){
        System.out.println("Mã Nhân Viên: "+ maNv);
        System.out.println("Tên Nhân Viên: "+ hoTen);
        System.out.println("Lương Nhân Viên: "+ luong);
    }
    public double getThuNhap(){
        return luong;
    }
    public double thueThuNhap(){
        if(getThuNhap()<=9000000) return 0;
        else if(getThuNhap()<=15000000) return (getThuNhap() - 9000000)*0.1;
        else return (getThuNhap()- 150000000)*0.2 + 6000000*0.1;
    }
}
