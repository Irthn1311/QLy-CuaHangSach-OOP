package QuanLyHoaDon_NEW;

import java.util.Scanner;

public class ChiTietHoaDon {
    Scanner sc = new Scanner(System.in);
    private String MaCTHD;       
    private String maSach;  
    private int soLuong;            
    private double donGia;         
    private double thanhTien;     

    public ChiTietHoaDon(String MaCTHD, String maSach, int soLuong, double donGia) {
        this.MaCTHD = MaCTHD;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }

    public ChiTietHoaDon() {
        this.MaCTHD = "";
        this.maSach = "";
        this.soLuong = 0;
        this.donGia = 0.0;
        this.thanhTien = 0.0;
    }

    public String getMaCTHD() {return MaCTHD; }
    public String getMaSach() { return maSach;}
    public int getSoLuong() {return soLuong; }
    public double getDonGia() {return donGia;}
    public double getThanhTien() { return thanhTien;}

    public void setMaCTHD(String MaCTHD) {this.MaCTHD = MaCTHD;}
    public void setmaSach(String maSach) {this.maSach = maSach;}
    public void setSoLuong(int soLuong) {this.soLuong = soLuong;this.thanhTien = soLuong * donGia;  }
    public void setDonGia(double donGia) {this.donGia = donGia;this.thanhTien = soLuong * donGia;  }
    

    public void nhap(boolean skipMaPNH) {
        
        if(skipMaPNH){
            System.out.print("Nhap ma CTPNH: ");
            MaCTHD = sc.nextLine();
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
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.printf("║    MA CHI TIET HOA DON: %-9s          ║\n",MaCTHD);
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.printf("║ MA SACH: %-5s                             ║\n",maSach);
        System.out.printf("║ SO LUONG: %-3d       DON GIA: %-6.2f        ║\n",soLuong,donGia);
        System.out.printf("║ THANH TIEN: %-8.2f                       ║\n",thanhTien);
        System.out.println("╚════════════════════════════════════════════╝");
    }


}