package src.QuanLyHoaDon;

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

    private ChiTietHoaDon[] chiTietHoaDon = new ChiTietHoaDon[10];
    private int size;

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

    public HoaDon(String maHD, String maKH, String maNV, LocalDate ngayTaoHD, double tongTien, double tienNhan, double tienThoi)
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
        System.out.print("Nhap ngay tao hoa don (dd/MM/yyyy): ");
        String ngay = sc.nextLine();
        ngayTaoHD = LocalDate.parse(ngay,sdf);
        System.out.print("Nhap tien nhan: ");
        tienNhan = sc.nextDouble();
        tienThoi = tienNhan - tongTien;
    }


    public void themChiTietHoaDon() {
        if (size == chiTietHoaDon.length) {
            chiTietHoaDon = Arrays.copyOf(chiTietHoaDon, size + 5);
        }

        ChiTietHoaDon cthd = new ChiTietHoaDon();
        cthd.Nhap();
        chiTietHoaDon[size++] = cthd;

        capNhatTongTien();
    }

    private void capNhatTongTien() {
        tongTien = 0;
        for (int i = 0; i < size; i++) {
            tongTien += chiTietHoaDon[i].getthanhTien();
        }
        tienThoi = tienNhan - tongTien;
    }

    public void Xuat()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| Ma hoa don: %-5s | Ma khach hang: %-5s | Ma nhan vien: %-5s | Ngay tao hoa don: %-10s | Tong tien: %-8s | Tien nhan: %-8s | Tien thoi: %-8s |\n",maHD,maKH,maNV,ngayTaoHD,tongTien,tienNhan,tienThoi);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void setmaHD(String maHD)
    {
        this.maHD = maHD;
    }

    public String getmaHD()
    {
        return this.maHD;
    }

    public void setmaKH(String maKH)
    {
        this.maKH = maKH;
    }

    public String getmaKH()
    {
        return this.maKH;
    }

    public void setmaNV(String maNV)
    {
        this.maNV = maNV;
    }

    public String getmaNV()
    {
        return this.maNV;
    }

    public LocalDate getngayTaoHD() {
        return ngayTaoHD;
    }

    public void setngayTaoHD(LocalDate ngayTaoHD) {
        this.ngayTaoHD = ngayTaoHD;
    }

    public void settongTien(double tongTien)
    {
        this.tongTien = tongTien;
    }

    public double gettongTien()
    {
        return this.tongTien;
    }

    public void settienNhan(double tienNhan)
    {
        this.tienNhan = tienNhan;
    }

    public double gettienNhan()
    {
        return this.tienNhan;
    }

    public void settienThoi(double tienThoi)
    {
        this.tienThoi = tienThoi;
    }

    public double gettienThoi()
    {
        return this.tienThoi;
    }
}

