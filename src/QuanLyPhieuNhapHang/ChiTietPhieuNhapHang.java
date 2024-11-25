package QuanLyPhieuNhapHang;

import java.util.Scanner;

public class ChiTietPhieuNhapHang {
    private String ma_CTPNH;       
    private String masACH_pnhsach;  
    private int soLuong;            
    private double donGia;         
    private double thanhTien;     


    public ChiTietPhieuNhapHang(String ma_CTPNH, String masACH_pnhsach, int soLuong, double donGia) {
        this.ma_CTPNH = ma_CTPNH;
        this.masACH_pnhsach = masACH_pnhsach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }


    public ChiTietPhieuNhapHang() {
   
        this.ma_CTPNH = "";
        this.masACH_pnhsach = "";
        this.soLuong = 0;
        this.donGia = 0.0;
        this.thanhTien = 0.0;
    }


    public String getMa_CTPNH() {
        return ma_CTPNH;
    }

    public void setMa_CTPNH(String ma_CTPNH) {
        this.ma_CTPNH = ma_CTPNH;
    }


    public String getMasACH_pnhsach() {
        return masACH_pnhsach;
    }

    public void setMasACH_pnhsach(String masACH_pnhsach) {
        this.masACH_pnhsach = masACH_pnhsach;
    }


    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = soLuong * donGia;  
    }


    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;  
    }


    public double getThanhTien() {
        return thanhTien;
    }


    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma CTPNH: ");
        ma_CTPNH = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        masACH_pnhsach = sc.nextLine();

        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();

        System.out.print("Nhap don gia: ");
        donGia = sc.nextDouble();
        thanhTien = soLuong * donGia;
    }

    public void xuat() {
        System.out.println("ChiTietPhieuNhapHang{" +
                "ma_CTPNH='" + ma_CTPNH + '\'' +
                ", masACH_pnhsach='" + masACH_pnhsach + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}');
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhapHang{" +
                "ma_CTPNH='" + ma_CTPNH + '\'' +
                ", masACH_pnhsach='" + masACH_pnhsach + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
