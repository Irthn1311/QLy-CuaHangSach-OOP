package QuanLyPhieuNhapHang;

import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PhieuNhapHang {
    Scanner sc = new Scanner(System.in); 
    private String maPNH;
    private LocalDate ngayNhap;
    private String maNXB;
    private String maNV;
    private Double tongTien;
    DateTimeFormatter  formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public PhieuNhapHang(){
        maPNH="";
        ngayNhap=null;
        maNXB="";
        maNV="";
        tongTien=0.0;
    }
    public PhieuNhapHang(String maPNH, String ngayNhap, String maNXB, String maNV, Double tongTien) {
        this.maPNH = maPNH;
        this.ngayNhap = LocalDate.parse(ngayNhap,formatter);
        this.maNXB = maNXB;
        this.maNV = maNV;
        this.tongTien = tongTien;
    }

   
    public String getMaPNH() {return maPNH;}
    public LocalDate getNgayNhap() {return ngayNhap;}
    public String getMaNXB() {return maNXB;}
    public String getMaNV() {return maNV;}
    public Double getTongTien() {return tongTien;}


    public void setMaPNH(String maPNH) {this.maPNH = maPNH; }
    public void setNgayNhap(String ngayNhap) {
        try{
            this.ngayNhap=LocalDate.parse(ngayNhap,formatter);
        }catch (DateTimeException e){
            this.ngayNhap=LocalDate.of(0001,01,01);
        }
    }
    public void setMaNXB(String maNXB) {this.maNXB = maNXB;}
    public void setMaNV(String maNV) {this.maNV = maNV;}
    public void setTongTien(Double tongTien) {this.tongTien = tongTien;}


    public void nhapPNH() {
        System.out.print("Nhap ma Phieu Nhap Hang: ");
        maPNH = sc.nextLine();

        boolean CheckDate = false;
        while (!CheckDate) {
            System.err.printf("Nhap Ngay Nhan Hang (dd-mm-yyyy): ");
            String ngaySinhInput = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                this.ngayNhap = LocalDate.parse(ngaySinhInput, formatter);
                CheckDate = true;
            } catch (DateTimeParseException e) {
                System.err.println("Ngay nhan hang khong hop le. Vui long nhap lai(dd-MM-yyyy).");
            }
        }
        
        System.out.print("Nhap Ma Nha Xuat Ban: ");
        maNXB = sc.nextLine();
        
        System.out.print("Nhap Ma Nhan Vien: ");
        maNV = sc.nextLine();
        
        // System.out.print("Nhap Tong Tien: ");
        // tongTien = sc.nextDouble();
        // sc.nextLine();
    }

   
    public void xuatPNH() {
        
        System.err.print("\n╔══════════════════════════════╦═══════════════════════\n");
        System.err.printf("║     PNH NGAY: %-7s     ║       MA PNH: %-7s \n",ngayNhap.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),maPNH );
        System.err.print("╠══════════════════════════════╩═══════════════════════\n");
        System.err.printf("║ MA NHA XUAT BAN   : %-7s                               \n",maNXB);
        System.err.printf("║ TONG TIEN         : %.2f VND             \n",tongTien);
        System.err.printf("╠══════════════════════════════════════════════════════\n");
        System.err.printf("║ MA NHAN VIEN      : %-7s                                \n",maNV);
        System.err.print("╚══════════════════════════════════════════════════════\n");

    }

 
    
}