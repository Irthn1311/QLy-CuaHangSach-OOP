package QuanLySach;

import java.util.Scanner;

public class SachThamKhao extends Sach {
    private String linhVuc;
    private int doTuoi;

    public SachThamKhao() {
        super();
        linhVuc = "";
        doTuoi = 0;
    }

    public SachThamKhao(String maSach, String tenSach, String maTacGia, String maNXB ,String theLoai, double donGiaBan, int soLuongSachHienCo, String linhVuc, int doTuoi) {
        super(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo);
        this.linhVuc = linhVuc;
        this.doTuoi = doTuoi;
    }

    public String getLinhVuc() {return linhVuc;}
    public int getDoTuoi() {return doTuoi;}

    public void setLinhVuc(String linhVuc) {this.linhVuc = linhVuc;}
    public void setDoTuoi(int doTuoi) {this.doTuoi = doTuoi;}
    
    @SuppressWarnings("resource")
    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap linh vuc: ");
        linhVuc = sc.nextLine();
        System.out.print("Nhap do tuoi: ");
        doTuoi = sc.nextInt();
    }

    @Override public void xuat() {
        super.xuat();
        System.out.printf("| Linh vuc: %-10s | Do tuoi: %-5d ",linhVuc, doTuoi);
    }

    @Override
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
        System.out.println("6. Linh Vuc");
        System.out.println("7. Do Tuoi");
        System.out.println("0. Thoat");
        System.out.print("Lua chon cua ban: ");
        choice = sc.nextInt();
        sc.nextLine(); // Xoa bo dem

        switch (choice) {
            case 1:
                System.out.println("Ten hien tai cua sach la: " + getTenSach());
                System.out.print("Nhap Ten Sach Moi: ");
                setTenSach(sc.nextLine());
                break;
            case 2:
                System.out.println("Ma Tac Gia Hien Tai Cua Sach La: " + getMaTacGia());
                System.out.print("Nhap Ma Tac Gia Moi: ");
                setMaTacGia(sc.nextLine());
                break;
            case 3:
                System.out.println("Ma Nha Xuat Ban Hien Tai Cua Sach La: " + getMaNXB());
                System.out.print("Nhap Ma Nha Xuat Ban Moi: ");
                setMaNXB(sc.nextLine());
                break;
            case 4:
                System.out.println("Don Gia Ban Hien Tai Cua Sach La: " + getDonGiaBan());
                System.out.print("Nhap Don Gia Moi: ");
                setDonGiaBan(sc.nextDouble());
                sc.nextLine(); // Xoa bo dem
                break;
            case 5:
                System.out.println("So Luong Ton Kho Hien Tai La: " + getSoLuongSachHienCo());
                System.out.print("Nhap So Luong Ton Kho Moi: ");
                setSoLuongSachHienCo(sc.nextInt());
                sc.nextLine(); // Xoa bo dem
                break;
            case 6:
                System.out.println("Linh Vuc Hien Tai Cua Sach La: " + getLinhVuc());
                System.out.print("Nhap Linh Vuc Moi: ");
                setLinhVuc(sc.nextLine());
                break;
            case 7:
                System.out.println("Do Tuoi Hien Tai Cua Sach La: " + getDoTuoi());
                System.out.print("Nhap Do Tuoi Moi: ");
                setDoTuoi(sc.nextInt());
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