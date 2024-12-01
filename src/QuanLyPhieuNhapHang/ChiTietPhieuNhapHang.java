//package QuanLyPhieuNhapHang;

import java.util.Scanner;

public class ChiTietPhieuNhapHang {
    Scanner sc = new Scanner(System.in);
    private String ma_CTPNH;       
    private String maSach;  
    private int soLuong;            
    private double donGia;         
    private double thanhTien;     


    public ChiTietPhieuNhapHang(String ma_CTPNH, String maSach, int soLuong, double donGia) {
        this.ma_CTPNH = ma_CTPNH;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }


    public ChiTietPhieuNhapHang() {
   
        this.ma_CTPNH = "";
        this.maSach = "";
        this.soLuong = 0;
        this.donGia = 0.0;
        this.thanhTien = 0.0;
    }


    public String getMa_CTPNH() {return ma_CTPNH; }
    public String getMaSach() { return maSach;}
    public int getSoLuong() {return soLuong; }
    public double getDonGia() {return donGia;}
    public double getThanhTien() { return thanhTien;}

    public void setMa_CTPNH(String ma_CTPNH) {this.ma_CTPNH = ma_CTPNH;}
    public void setmaSach(String maSach) {this.maSach = maSach;}
    public void setSoLuong(int soLuong) {this.soLuong = soLuong;this.thanhTien = soLuong * donGia;  }
    public void setDonGia(double donGia) {this.donGia = donGia;this.thanhTien = soLuong * donGia;  }
    

    public void nhap(boolean skipMaPNH) {
        
        if(skipMaPNH){
            System.out.print("Nhap ma CTPNH: ");
            ma_CTPNH = sc.nextLine();
        }
        System.out.print("Nhap Ma Sach: ");
        maSach = sc.nextLine();

        System.out.print("Nhap So Luong: ");
        soLuong = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap Don Gia: ");
        donGia = sc.nextDouble();
        sc.nextLine();
        thanhTien = soLuong * donGia;
    }

    public void xuat() {
        System.out.println("\n╔════════════════════════════════════════════");
        System.out.printf("║    MA CHI TIET PNH : %-9s          \n",ma_CTPNH);
        System.out.println("╠════════════════════════════════════════════");
        System.out.printf("║ MA SACH   : %-5s                             \n",maSach);
        System.out.printf("║ SO LUONG  : %-3d       DON GIA: %-6.2f        \n",soLuong,donGia);
        System.out.printf("║ THANH TIEN: %-8.2f                       \n",thanhTien);
        System.out.println("╚════════════════════════════════════════════");

    }


}