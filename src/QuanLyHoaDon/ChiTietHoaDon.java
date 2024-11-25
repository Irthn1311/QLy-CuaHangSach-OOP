package QuanLyHoaDon;

import java.util.Scanner;

public class ChiTietHoaDon {
    private String maHD;
    private String maSach;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    Scanner sc = new Scanner(System.in);

    public ChiTietHoaDon()
    {
        maHD = "";
        maSach = "";
        soLuong = 0;
        donGia = 0.0;
        thanhTien = 0.0;
    }

    public ChiTietHoaDon(String maHD, String maSach, int soLuong, double donGia)
    {
        this.maHD = maHD;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = this.donGia * this.soLuong;
    }

    public void Nhap()
    {
        System.out.println("================Bat dau nhap chi tiet hoa don.================");
        System.out.print("Nhap ma hoa don: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = sc.nextDouble();
        sc.nextLine();
        thanhTien = soLuong * donGia;
    }

    public void Xuat()
    {
        System.out.println("Ma hoa don: " + maHD);
        System.out.println("Ma sach: " + maSach);
        System.out.println("So luong: " + soLuong);
        System.out.println("Don gia: " + donGia);
        System.out.println("Thanh tien: " + thanhTien);
    }

    public void setmaHD(String maHD) {this.maHD = maHD;}

    public String getmaHD() {return this.maHD;}

    public void setmaSach(String maSach) {this.maSach = maSach;}

    public String getmaSach() {return this.maSach;}

    public void setsoLuong(int soLuong){this.soLuong = soLuong;}

    public int getsoLuong() {return this.soLuong;}

    public void setdonGia(double donGia){this.donGia = donGia;}

    public double getdonGia() {return this.donGia;}

    public double getthanhTien() {return this.soLuong * this.donGia;}
}

