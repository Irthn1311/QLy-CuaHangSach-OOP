package QuanLySach;

import java.util.Scanner;

public class SachChuyenNganh extends Sach {
    private String monChuyenNganh;

    public SachChuyenNganh() {
        super();
        monChuyenNganh = "";
    }

    public SachChuyenNganh(String maSach, String tenSach, String maTacGia, String maNXB, String theLoai, double donGiaBan, int soLuongSachHienCo, String monChuyenNganh) {
        super(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo);
        this.monChuyenNganh = monChuyenNganh;
    }

    public String getMonChuyenNganh() {
        return monChuyenNganh;
    }

    public void setMonChuyenNganh(String monChuyenNganh) {
        this.monChuyenNganh = monChuyenNganh;
    }
    
    @Override public void nhap() {
        super.nhap();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mon chuyen nganh: ");
        monChuyenNganh = sc.nextLine();
    }

    @Override public void xuat() {
        super.xuat();
        System.out.printf("| Mon chuyen nganh %-10s ",monChuyenNganh);
    }

    @Override public void sua() {
        super.sua();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Mon Chuyen Nganh Hien Tai Cua Sach La: " + getMonChuyenNganh());
        System.out.print("Nhap Mon Chuyen Nganh Moi: ");
        monChuyenNganh = sc.nextLine();
    }

}