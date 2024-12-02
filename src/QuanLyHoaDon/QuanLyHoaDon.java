package QuanLyHoaDon;

import java.util.Scanner;

public class QuanLyHoaDon {
    Scanner sc=new Scanner(System.in);
    DanhSachHoaDon quanlyPhieuHoaDon= new DanhSachHoaDon();
    DanhSachChiTietHoaDon quanlyChiTietHoaDon= new DanhSachChiTietHoaDon(quanlyPhieuHoaDon);
    public void menu() {
        int choice;
        do {
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.print("║      MENU : Quan ly HD Va Chi Tiet HD    ║\n");
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1. Xem HD Hoac Chi Tiet HD              ║\n");
            System.out.print("║  2. Them HD Hoac Chi Tiet HD             ║\n");
            System.out.print("║  3. Sua HD Hoac Chi Tiet HD              ║\n");
            System.out.print("║  4. Xoa HD Hoac Chi Tiet HD              ║\n");
            System.out.print("║  5. Tim Kiem HD Hoac Chi Tiet HD         ║\n");
            System.out.print("║  6. Thong Ke HD Hoac Chi Tiet HD         ║\n");
            System.out.print("║  7. Doc Ghi FILE HD                      ║\n");
            System.err.print("║  8. Doc Ghi FILE Chi Tiet HD             ║\n");
            System.out.print("║  0. Thoat                                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.print("\n╔══════════════════════════════════════════╗\n");
                        System.err.print("║              MENU : XEM                  ║\n");
                        System.out.print("╠══════════════════════════════════════════╣\n");
                        System.out.print("║  1. Xem Danh Sach HD                     ║\n");
                        System.out.print("║  2. Xem Danh Sach Chi Tiet HD            ║\n");
                        System.out.print("║  3. Xem HD Va Chi Tiet HD                ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice1 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice1) {
                        case 1:
                            quanlyPhieuHoaDon.xuatHoaDon();
                            break;
                        case 2:
                            quanlyChiTietHoaDon.inDanhSachChiTietHD();
                            break;
                        case 3:
                            quanlyPhieuHoaDon.xuatHDvaChiTietHD(quanlyChiTietHoaDon);
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice1!=0);
                    break;
                case 2:
                    int choice2;
                    do {
                        System.out.print("\n╔══════════════════════════════════════════╗\n");
                        System.err.print("║              MENU : THEM                 ║\n");
                        System.out.print("╠══════════════════════════════════════════╣\n");
                        System.out.print("║  1. Them HD Va Chi Tiet HD               ║\n");
                        System.out.print("║  2. Them Chi Tiet HD                     ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice2 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice2) {
                        case 1:
                            quanlyPhieuHoaDon.nhapHDvaChiTietHD(quanlyChiTietHoaDon);
                            break;
                        case 2:
                            quanlyChiTietHoaDon.themChiTietVaoHD();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice2!=0);
                    break;
                case 3:
                    int choice3;
                    do {
                        System.out.print("\n╔══════════════════════════════════════════╗\n");
                        System.err.print("║              MENU : SUA                  ║\n");
                        System.out.print("╠══════════════════════════════════════════╣\n");
                        System.out.print("║  1. Sua Phieu Nhap Hang                  ║\n");
                        System.out.print("║  2. Sua Chi Tiet HD                      ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice3 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice3) {
                        case 1:
                            quanlyPhieuHoaDon.suaHoaDon();
                            break;
                        case 2:
                            quanlyChiTietHoaDon.suaChiTietHD();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice3!=0);
                    break;
                case 4:
                    int choice4;
                    do {
                        System.out.print("\n╔══════════════════════════════════════════╗\n");
                        System.err.print("║              MENU : XOA                  ║\n");
                        System.out.print("╠══════════════════════════════════════════╣\n");
                        System.out.print("║  1. Xoa Phieu Nhap Hang                  ║\n");
                        System.out.print("║  2. Xoa Chi Tiet HD                      ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice4 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice4) {
                        case 1:
                            quanlyPhieuHoaDon.xoaPhieuTheoMaHD();
                            break;
                        case 2:
                            quanlyChiTietHoaDon.xoaChiTietHD();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice4!=0);
                    break;
                case 5:
                    quanlyPhieuHoaDon.timPhieuTheoMaHD();
                    break;
                case 6:
                    quanlyPhieuHoaDon.thongKe();
                    break;
                case 7:
                    int choice5;
                    do {
                        System.out.print("\n╔══════════════════════════════════════════╗\n");
                        System.err.print("║          MENU : QUAN LY FILE HD          ║\n");
                        System.out.print("╠══════════════════════════════════════════╣\n");
                        System.out.print("║  1. Doc Du Lieu Vao FILE HD              ║\n");
                        System.out.print("║  2. Ghi Du Lieu Vao FILE HD              ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice5 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice5) {
                        case 1:
                            quanlyPhieuHoaDon.docFile();;
                            break;
                        case 2:
                            quanlyPhieuHoaDon.ghiFile();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice5!=0);
                    break;
                case 8:
                    int choice6;
                    do {
                        System.out.print("\n╔══════════════════════════════════════════╗\n");
                        System.err.print("║      MENU : QUAN LY FILE CHI TIET HD     ║\n");
                        System.out.print("╠══════════════════════════════════════════╣\n");
                        System.out.print("║  1. Doc Du Lieu Vao FILE Chi Tiet HD     ║\n");
                        System.out.print("║  2. Ghi Du Lieu Vao FILE Chi Tiet HD     ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice6 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice6) {
                        case 1:
                            quanlyChiTietHoaDon.docFile();
                            break;
                        case 2:
                            quanlyChiTietHoaDon.ghiFile();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice6!=0);
                    break;
                case 0:
                    System.out.print("\nThoat");
                    break;
                default:
                    System.out.print("\nNhap Sai Vui Long Nhap Lai");
                    break;
            }
        } while (choice != 0);
    
    }
}
