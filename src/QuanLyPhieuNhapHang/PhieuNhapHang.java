package QuanLyPhieuNhapHang;
import java.sql.Date;
import java.util.Scanner;

public class PhieuNhapHang {
    private String maPNH;
    private Date ngayNhap;
    private String maNXB;
    private String maNV;
    private Double tongTien;
    public PhieuNhapHang(){
    }
    public PhieuNhapHang(String maPNH, Date ngayNhap, String maNXB, String maNV, Double tongTien) {
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
    @SuppressWarnings("resource")
    public void nhapPNH() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập mã phiếu nhập hàng: ");
        maPNH = sc.nextLine();
        
        System.out.print("Nhập ngày nhập (yyyy-mm-dd): ");
        String dateString = sc.nextLine();
        ngayNhap = Date.valueOf(dateString);
        
        System.out.print("Nhập mã nhà xuất bản: ");
        maNXB = sc.nextLine();
        
        System.out.print("Nhập mã nhân viên: ");
        maNV = sc.nextLine();
        
        System.out.print("Nhập tổng tiền: ");
        tongTien = sc.nextDouble();
    }

   
    public void xuatPNH() {
        System.out.println("Mã Phiếu Nhập Hàng: " + maPNH);
        System.out.println("Ngày Nhập: " + ngayNhap);
        System.out.println("Mã Nhà Xuất Bản: " + maNXB);
        System.out.println("Mã Nhân Viên: " + maNV);
        System.out.println("Tổng Tiền: " + tongTien);
    }

 
    @Override
    public String toString() {
        return "PhieuNhapHang{" +
                "maPNH='" + maPNH + '\'' +
                ", ngayNhap=" + ngayNhap +
                ", maNXB='" + maNXB + '\'' +
                ", maNV='" + maNV + '\'' +
                ", tongTien=" + tongTien +
                '}';
    }
}