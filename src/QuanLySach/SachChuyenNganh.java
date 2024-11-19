package QuanLySach;

import java.util.Scanner;

public class SachChuyenNganh extends Sach {
    private String monChuyenNganh;

    public SachChuyenNganh() {}

    public SachChuyenNganh(String maSach, String tenSach, String maTacGia, String theLoai, double donGiaBan, int soLuongSachHienCo, String monChuyenNganh) {
        super(maSach, tenSach, maTacGia, theLoai, donGiaBan, soLuongSachHienCo);
        this.monChuyenNganh = monChuyenNganh;
    }

    public String getMonChuyenNganh() {
        return monChuyenNganh;
    }

    public void setMonChuyenNganh(String monChuyenNganh) {
        this.monChuyenNganh = monChuyenNganh;
    }
    @SuppressWarnings("resource")
    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mon chuyen nganh: ");
        monChuyenNganh = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Mon chuyen nganh: " + monChuyenNganh);
    }
}