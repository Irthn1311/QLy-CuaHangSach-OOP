package QuanLyPhieuNhapHang;

import java.util.Scanner;

public class ChiTietPhieuNhapHang {
    private String ma_CTPNH;       
    private String masACH_pnhsach;  
    private int soLuong_Nhap;     //nhap       
    private double donGia_Nhap;       //nhap  
    private double thanhTien_Nhap;    //nhap,, 


    public ChiTietPhieuNhapHang(String ma_CTPNH, String masACH_pnhsach, int soLuong_Nhap, double donGia_Nhap) {
        this.ma_CTPNH = ma_CTPNH;
        this.masACH_pnhsach = masACH_pnhsach;
        this.soLuong_Nhap = soLuong_Nhap;
        this.donGia_Nhap= donGia_Nhap;
        this.thanhTien_Nhap = soLuong_Nhap * donGia_Nhap;
    }


    public ChiTietPhieuNhapHang() {
        this.ma_CTPNH = "";
        this.masACH_pnhsach = "";
        this.soLuong_Nhap = 0;
        this.donGia_Nhap= 0.0;
        this.thanhTien_Nhap = 0.0;
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


    public int getSoLuong_Nhap() {
        return soLuong_Nhap;
    }

    public void setSoLuong_Nhap(int soLuong_Nhap) {
        this.soLuong_Nhap = soLuong_Nhap;
        this.thanhTien_Nhap = soLuong_Nhap* donGia_Nhap;  
    }


    public double getDonGia_Nhap() {
        return donGia_Nhap;
    }

    public void setDonGia_Nhap(double donGia_Nhap) {
        this.donGia_Nhap = donGia_Nhap;
        this.thanhTien_Nhap = soLuong_Nhap * donGia_Nhap;  
    }


    public double getThanhTien() {
        return thanhTien_Nhap;
    }

    @SuppressWarnings("resource")
    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma CTPNH: ");
        ma_CTPNH = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        masACH_pnhsach = sc.nextLine();

        System.out.print("Nhap so luong: ");
        soLuong_Nhap= sc.nextInt();

        System.out.print("Nhap don gia: ");
        donGia_Nhap = sc.nextDouble();
        thanhTien_Nhap = soLuong_Nhap * donGia_Nhap;
    }

    public void xuat() {
      System.out.print("\n====================");
      System.out.print("\nMa chi tiet phieu nhap hang: "+ma_CTPNH+
                        "\nMa sach:  "+masACH_pnhsach+
                        "\nso luong nhap: "+soLuong_Nhap+
                        "\nDon gia nhap: "+donGia_Nhap+
                        "\nThanh tien nhap: "+thanhTien_Nhap);
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhapHang{" +
                "ma_CTPNH='" + ma_CTPNH + '\'' +
                ", masACH_pnhsach='" + masACH_pnhsach + '\'' +
                ", soLuong=" + soLuong_Nhap +
                ", donGia=" + donGia_Nhap +
                ", thanhTien=" + thanhTien_Nhap +
                '}';
    }
}