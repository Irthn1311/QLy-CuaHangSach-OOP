package QuanLyHoaDon;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class HoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    private LocalDate ngayTaoHD;
    private double tongTien;
    private double tienNhan;
    private double tienThoi;

    private static final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    Scanner sc = new Scanner(System.in);

    public HoaDon()
    {
        maHD = "";
        maKH = "";
        maNV = "";
        ngayTaoHD = LocalDate.now();
        tongTien = 0;
        tienNhan = 0;
        tienThoi = 0;
    }

    public HoaDon(String maHD, String maKH, String maNV, LocalDate ngayTaoHD, double tienNhan, double tongTien, double tienThoi)
    {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayTaoHD = ngayTaoHD;
        this.tongTien = tongTien;
        this.tienNhan = tienNhan;
        this.tienThoi = tienThoi;
    }



    public void Nhap()
    {
        System.out.print("Nhap ma hoa don: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        maKH = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ngay tao hoa don (dd-MM-yyyy): ");
        String ngay = sc.nextLine();
        ngayTaoHD = LocalDate.parse(ngay,sdf);
        System.out.print("Nhap tien nhan: ");
        tienNhan = sc.nextDouble();
        sc.nextLine();
        sc.nextLine();
        System.out.println("");
    }

    public void Xuat()
    {
        System.out.printf("| %-12s | %-15s | %-15s | %-18s | %-10.2f | %-10.2f | %-10.2f |\n",maHD, maKH, maNV, ngayTaoHD, tongTien, tienNhan, (tienNhan - tongTien));
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    public void setmaHD(String maHD) {this.maHD = maHD;}
    public void setmaKH(String maKH) {this.maKH = maKH;}
    public void setmaNV(String maNV) {this.maNV = maNV;}
    public void setngayTaoHD(LocalDate ngayTaoHD) {this.ngayTaoHD = ngayTaoHD;}
    public void settongTien(double tongTien) {this.tongTien = tongTien;}
    public void settienNhan(double tienNhan) {this.tienNhan = tienNhan;}
    public void settienThoi(double tienThoi) {this.tienThoi = tienThoi;}

    public double gettienThoi() {return this.tienThoi;}
    public String getmaHD() {return this.maHD;}
    public double gettienNhan() {return this.tienNhan;}
    public String getmaNV() {return this.maNV;}
    public LocalDate getngayTaoHD() {return ngayTaoHD;}
    public String getmaKH() {return this.maKH;}
    public double gettongTien() {return this.tongTien;}
}

