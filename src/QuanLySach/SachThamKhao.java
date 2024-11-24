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

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public int getDoTuoi() {
        return doTuoi;
    }

    public void setDoTuoi(int doTuoi) {
        this.doTuoi = doTuoi;
    }
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
        System.out.println("\n Linh vuc: " + linhVuc + "| Do tuoi: " + doTuoi);
    }
}