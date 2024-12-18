import QuanLySach.QuanLySach;
import QuanLyNhanVien.QuanLyNhanVien;
import QuanLyKhachHang.QuanLyKhachHang;
import QuanlyTacGia.QuanLyTacGia;
import QuanLyNXB.QuanLyNhaXuatBan;
import QuanLyPhieuNhapHang.QuanLyPhieuNhapHang;
import QuanLyHoaDon.QuanLyHoaDon;

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        QuanLySach qlSach = new QuanLySach();
        QuanLyNhanVien qlNV = new QuanLyNhanVien();
        QuanLyKhachHang qlKH = new QuanLyKhachHang();
        QuanLyTacGia qlTG = new QuanLyTacGia();
        QuanLyNhaXuatBan qlNXB = new QuanLyNhaXuatBan();
        QuanLyPhieuNhapHang qlPNH = new QuanLyPhieuNhapHang();
        QuanLyHoaDon qlHD = new QuanLyHoaDon();

        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.print("║               MENU : Tong                ║\n");
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1. Quan Ly Sach                         ║\n");
            System.out.print("║  2. Quan Ly Nhan Vien                    ║\n");
            System.out.print("║  3. Quan Ly Khach Hang                   ║\n");
            System.out.print("║  4. Quan Ly Tac Gia                      ║\n");
            System.out.print("║  5. Quan Ly Nha Xuat Ban                 ║\n");
            System.out.print("║  6. Quan Ly Phieu Nhap Hang              ║\n");
            System.out.print("║  7. Quan Ly Hoa Don                      ║\n");
            System.out.print("║  0. Ket thuc chuong trinh                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
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
                case 7:
                    qlHD.menu();
                    break;
                case 0:
                    System.out.print("\nThoat");
                    break;
                default:
                System.err.print("\n╔══════════════════════════════════════════\n");
                System.err.printf("║ Nhap Lai             \n");
                System.err.print("╚══════════════════════════════════════════");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}