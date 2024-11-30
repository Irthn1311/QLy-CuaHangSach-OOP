import QuanLySach.QuanLySach;
import QuanLyNhanVien.QuanLyNhanVien;
import QuanLyKhachHang.QuanLyKhachHang;
import QuanlyTacGia.QuanLyTacGia;
import QuanLyNXB.QuanLyNhaXuatBan;
import QuanLyPhieuNhapHang_NEW.QuanLyPhieuNhapHang;

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        QuanLySach qlSach = new QuanLySach();
        QuanLyNhanVien qlNV = new QuanLyNhanVien();
        QuanLyKhachHang qlKH = new QuanLyKhachHang();
        QuanLyTacGia qlTG = new QuanLyTacGia();
        QuanLyNhaXuatBan qlNXB = new QuanLyNhaXuatBan();
        QuanLyPhieuNhapHang qlPNH = new QuanLyPhieuNhapHang();
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("\n1.Quan Ly Sach");
            System.out.print("\n2.Quan Ly Nhan Vien");
            System.out.print("\n3.Quan Ly Khach Hang");
            System.out.print("\n4.Quan Ly Tac Gia");
            System.out.print("\n5.Quan Ly Nha Xuat Ban");
            System.out.print("\n6.Quan Ly Phieu Nhap Hang");
            System.out.print("\n0.Ket thuc chuong trinh");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    qlSach.menu();
                    break;
                case 2:
                    qlNV.menu();
                    break;
                case 3:
                    qlKH.menu();
                    break;
                case 4:
                    qlTG.menu();
                    break;
                case 5:
                    qlNXB.menu();
                    break;
                case 6:
                    qlPNH.menu();
                    break;
                case 0:
                    System.out.print("\nThoat");
                    break;
                default:
                    System.out.print("\nNhap Lai");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}