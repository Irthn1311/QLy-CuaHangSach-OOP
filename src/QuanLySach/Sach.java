package QuanLySach;

import java.util.Scanner;
public class Sach extends SanPham {
    private String maTacGia;
    private String maNXB;
    private String theLoai;
    private int soLuongSachHienCo;

    public Sach() {
        super("", "", 0.0);
        this.maTacGia = "";
        this.maNXB = "";
        this.theLoai = "";
        this.soLuongSachHienCo = 0;
    }

    public Sach(String maSP, String tenSP, String maTacGia, String maNXB, String theLoai, double giaBan, int soLuongSachHienCo) {
        super(maSP, tenSP, giaBan);
        this.maTacGia = maTacGia;
        this.maNXB = maNXB;
        this.theLoai = theLoai;
        this.soLuongSachHienCo = soLuongSachHienCo;
    }

    @Override
    public double tinhGia() {
        return giaBan * soLuongSachHienCo;
    }

    public void testTinhGia() {
        double gia = this.tinhGia();
        System.out.println("Tong gia tri cua sach: " + gia);
    }

    public String getMaSach() {
        return this.getMaSP();
    }
    
    public void setMaSach(String maSach) {
        this.setMaSP(maSach);
    }

    public String getTenSach() {
        return this.getTenSP();
    }

    public void setTenSach(String tenSach) {
        this.setTenSP(tenSach);
    }

    public double getDonGiaBan() {
        return this.getGiaBan();
    }

    public void setDonGiaBan(double donGiaBan) {
        this.setGiaBan(donGiaBan);
    }

    // Các phương thức getter và setter
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

    public int getSoLuongSachHienCo() {
        return soLuongSachHienCo;
    }

    public void setSoLuongSachHienCo(int soLuongSachHienCo) {
        this.soLuongSachHienCo = soLuongSachHienCo;
    }
    @SuppressWarnings("resource")
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Sach: ");
        maSP = sc.nextLine();

        System.out.print("Nhap Ten Sach: ");
        tenSP = sc.nextLine();

        System.out.print("Nhap Ma Tac Gia: ");
        maTacGia = sc.nextLine();

        System.out.print("Nhap Ma Nha Xuat Ban: ");
        maNXB = sc.nextLine();

        System.out.print("Nhap Don Gia: ");
        giaBan = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhap So Luong Ton Kho: ");
        soLuongSachHienCo = sc.nextInt();
        sc.nextLine();

    }

    public void xuat() {
        System.out.println("╔══════════════════════════════════════════");
        System.out.printf("║          MA SACH: %s          \n",maSP);
        System.out.println("╠══════════════════════════════════════════");
        System.out.printf("║ Ten Sach        : %s                              \n",tenSP);
        System.out.printf("║ Ma Tac Gia      : %s                   \n",maTacGia);
        System.out.printf("║ Ma Nha Xuat Ban : %s                      \n",maNXB);
        System.out.printf("║ Don Gia: %.2f            So Luong: %d          \n",giaBan,soLuongSachHienCo);
        System.out.printf("║ Tong gia tri trong kho: %.2f \n", this.tinhGia());
    }

    public void suaSach() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1. Sua Ten Sach                         ║\n");
            System.out.print("║  2. Sua Ma Tac Gia                       ║\n");
            System.out.print("║  3. Sua Ma Nha Xuat Ban                  ║\n");
            System.out.print("║  4. Sua Don Gia                          ║\n");
            System.out.print("║  5. Sua So Luong Ton Kho                 ║\n");
            System.out.print("║  0. Thoat                                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Xoa bo dem
    
            switch (choice) {
                case 1:
                    System.out.println("Ten hien tai cua sach la: " + getTenSach());
                    System.out.print("Nhap Ten Sach Moi: ");
                    tenSP = sc.nextLine();
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
                    giaBan = sc.nextDouble();
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