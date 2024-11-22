package QuanLySach;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private String maTacGia;
    private String maNXB;
    private String theLoai;
    private double donGiaBan;
    private int soLuongSachHienCo;

    public Sach() {
        maSach = "";
        tenSach = "";
        maTacGia = "";
        maNXB = "";
        theLoai = "";
        donGiaBan = 0;
        soLuongSachHienCo = 0;
    }

    public Sach(String maSach, String tenSach, String maTacGia, String maNXB, String theLoai, double donGiaBan, int soLuongSachHienCo) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maTacGia = maTacGia;
        this.maNXB = maNXB;
        this.theLoai = theLoai;
        this.donGiaBan = donGiaBan;
        this.soLuongSachHienCo = soLuongSachHienCo;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public int getSoLuongSachHienCo() {
        return soLuongSachHienCo;
    }

    public void setSoLuongSachHienCo(int soLuongSachHienCo) {
        this.soLuongSachHienCo = soLuongSachHienCo;
    }
    @SuppressWarnings("resource")
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nhap ma tac gia: ");
        maTacGia = sc.nextLine();
        System.out.print("Nhap ma NXB: ");
        maNXB = sc.nextLine();
        System.out.print("Nhap the loai: ");
        theLoai = sc.nextLine();
        System.out.print("Nhap don gia ban: ");
        donGiaBan = sc.nextDouble();
        System.out.print("Nhap so luong sach hien co: ");
        soLuongSachHienCo = sc.nextInt();
    }

    public void xuat() {
        System.out.println("Ma sach: " + maSach + " | Ten sach: " + tenSach + " | Ma tac gia: " + maTacGia + " | The loai: " + theLoai + " | Don gia ban: " + donGiaBan + " | So luong sach hien co: " + soLuongSachHienCo);
    }

}