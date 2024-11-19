package QuanLyNXB;
import java.sql.Date;
import java.util.Scanner;

public class QuanLyPhieuNhapHang {
    private String maPNH;
    private Date ngayNhap;
    private String maNXB;
    private String maNV;
    private Double tongTien;
    public QuanLyPhieuNhapHang(){
    }
    public QuanLyPhieuNhapHang(String maPNH, Date ngayNhap, String maNXB, String maNV, Double tongTien) {
        this.maPNH = maPNH;
        this.ngayNhap = ngayNhap;
        this.maNXB = maNXB;
        this.maNV = maNV;
        this.tongTien = tongTien;
    }

   
    public String getMaPNH() {
        return maPNH;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    public void nhap

}
