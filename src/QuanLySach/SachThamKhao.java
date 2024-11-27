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

    @Override public void sua() {
        super.sua();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Linh Vuc Hien Tai Cua Sach La: " + getLinhVuc());
        System.out.print("Nhap linh vuc: ");
        linhVuc = sc.nextLine();
        System.out.println("Do Tuoi Hien Tai Cua Sach La: " + getDoTuoi());
        System.out.print("Nhap do tuoi: ");
        doTuoi = sc.nextInt();
    }
}