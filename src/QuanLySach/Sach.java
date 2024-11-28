package QuanLySach;

import java.util.Scanner;
public class Sach {
    private String maSach;
    private String tenSach;
    private String maTacGia;
    private String maNXB;
    private String theLoai;
    private Double donGiaBan;
    private int soLuongSachHienCo;

    public Sach() {
        maSach = "";
        tenSach = "";
        maTacGia = "";
        maNXB = "";
        theLoai = "";
        donGiaBan = 0.0;
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

    public String getMaSach() {return maSach;}
    public String getTenSach() {return tenSach;}
    public String getMaTacGia() {return maTacGia;}
    public String getMaNXB() {return maNXB;} 
    public String getTheLoai() {return theLoai;}
    public double getDonGiaBan() {return donGiaBan;}
    public int getSoLuongSachHienCo() {return soLuongSachHienCo;}

    public void setMaSach(String maSach) {this.maSach = maSach;}    
    public void setTenSach(String tenSach) {this.tenSach = tenSach;}
    public void setMaTacGia(String maTacGia) {this.maTacGia = maTacGia;}
    public void setMaNXB(String maNXB) {this.maNXB = maNXB;}
    public void setTheLoai(String theLoai) {this.theLoai = theLoai;}
    public void setDonGiaBan(double donGiaBan) {this.donGiaBan = donGiaBan;}
    public void setSoLuongSachHienCo(int soLuongSachHienCo) {this.soLuongSachHienCo = soLuongSachHienCo;}

    @SuppressWarnings("resource")
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Sach: ");
        maSach = sc.nextLine();

        System.out.print("Nhap Ten Sach: ");
        tenSach = sc.nextLine();

        System.out.print("Nhap Ma Tac Gia: ");
        maTacGia = sc.nextLine();

        System.out.print("Nhap ma Nha Xuat Ban: ");
        maNXB = sc.nextLine();

        System.out.print("Nhap Don Gia: ");
        donGiaBan = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhap So Luong Ton Kho: ");
        soLuongSachHienCo = sc.nextInt();
        sc.nextLine();

    }

    public void xuat() {
        System.out.print("\n-------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| Ma Sach: %-5s | Ten Sach: %-16s | Ma Tac Gia: %-10s | Ma NXB: %-10s",maSach,tenSach,maTacGia,maNXB);
        System.out.printf("| The Loai: %-10s | Don Gia: %-13.2f | So Luong Ton: %-16d",theLoai,donGiaBan,soLuongSachHienCo);
    }

    public void suaSach() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nChon thong tin can sua:");
            System.out.println("1. Ten Sach");
            System.out.println("2. Ma Tac Gia");
            System.out.println("3. Ma Nha Xuat Ban");
            System.out.println("4. Don Gia Ban");
            System.out.println("5. So Luong Ton Kho");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Xoa bo dem
    
            switch (choice) {
                case 1:
                    System.out.println("Ten hien tai cua sach la: " + getTenSach());
                    System.out.print("Nhap Ten Sach Moi: ");
                    tenSach = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Ma Tac Gia Hien Tai Cua Sach La: " + getMaTacGia());
                    System.out.print("Nhap Ma Tac Gia Moi: ");
                    maTacGia = sc.nextLine();
                    break;
                case 3:
                    System.out.println("Ma Nha Xuat Ban Hien Tai Cua Sach La: " + getMaNXB());
                    System.out.print("Nhap Ma Nha Xuat Ban Moi: ");
                    maNXB = sc.nextLine();
                    break;
                case 4:
                    System.out.println("Don Gia Ban Hien Tai Cua Sach La: " + getDonGiaBan());
                    System.out.print("Nhap Don Gia Moi: ");
                    donGiaBan = sc.nextDouble();
                    sc.nextLine(); // Xoa bo dem
                    break;
                case 5:
                    System.out.println("So Luong Ton Kho Hien Tai La: " + getSoLuongSachHienCo());
                    System.out.print("Nhap So Luong Ton Kho Moi: ");
                    soLuongSachHienCo = sc.nextInt();
                    sc.nextLine(); // Xoa bo dem
                    break;
                case 0:
                    System.out.println("Ket thuc chinh sua.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        } while (choice != 0);
    }
}