//package QuanLyPhieuNhapHang;

import java.util.Scanner;

public class QuanLyPhieuNhapHang {
    Scanner sc=new Scanner(System.in);
    DanhSachPhieuNhapHang quanlyPhieuNhapHang= new DanhSachPhieuNhapHang();
    DanhSachChiTietPhieuNhapHang quanlyChiTietPhieuNhapHang= new DanhSachChiTietPhieuNhapHang(quanlyPhieuNhapHang);
    public void menu() {
        int choice;
        do {
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.print("║      MENU : Quan ly PNH Va Chi Tiet PNH  ║\n");
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1. Xem PNH Hoac Chi Tiet PNH            ║\n");
            System.out.print("║  2. Them PNH Hoac Chi Tiet PNH           ║\n");
            System.out.print("║  3. Sua PNH Hoac Chi Tiet PNH            ║\n");
            System.out.print("║  4. Xoa PNH Hoac Chi Tiet PNH            ║\n");
            System.out.print("║  5. Tim Kiem PNH Hoac Chi Tiet PNH       ║\n");
            System.out.print("║  6. Thong Ke PNH Hoac Chi Tiet PNH       ║\n");
            System.out.print("║  7. Doc Ghi FILE PNH                     ║\n");
            System.err.print("║  8. Doc Ghi FILE Chi Tiet PNH            ║\n");
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
                        System.out.print("║  1. Xem Danh Sach PNH                    ║\n");
                        System.out.print("║  2. Xem Danh Sach Chi Tiet PNH           ║\n");
                        System.out.print("║  3. Xem PNH Va Chi Tiet PNH              ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice1 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice1) {
                        case 1:
                            quanlyPhieuNhapHang.xuatPhieuNhapHang();
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.inDanhSachChiTietPNH();
                            break;
                        case 3:
                            quanlyPhieuNhapHang.xuatPNHvaChiTietPNH(quanlyChiTietPhieuNhapHang);
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
                        System.out.print("║  1. Them PNH Va Chi Tiet PNH             ║\n");
                        System.out.print("║  2. Them Chi Tiet PNH                    ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice2 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice2) {
                        case 1:
                            quanlyPhieuNhapHang.nhapPNHvaChiTietPNH(quanlyChiTietPhieuNhapHang);
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.themChiTietVaoPNH();
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
                        System.out.print("║  2. Sua Chi Tiet PNH                     ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice3 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice3) {
                        case 1:
                            quanlyPhieuNhapHang.suaPhieuNhapHang();
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.suaChiTietPNH();
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
                        System.out.print("║  2. Xoa Chi Tiet PNH                     ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice4 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice4) {
                        case 1:
                            quanlyPhieuNhapHang.xoaPhieuTheoMaPNH();
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.xoaChiTietPNH();
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
                    quanlyPhieuNhapHang.timPhieuTheoMaPNH();
                    break;
                case 6:
                    quanlyPhieuNhapHang.thongKe();
                    break;
                case 7:
                    int choice5;
                    do {
                        System.out.print("\n╔══════════════════════════════════════════╗\n");
                        System.err.print("║          MENU : QUAN LY FILE PNH         ║\n");
                        System.out.print("╠══════════════════════════════════════════╣\n");
                        System.out.print("║  1. Doc Du Lieu Vao FILE PNH             ║\n");
                        System.out.print("║  2. Ghi Du Lieu Vao FILE PNH             ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice5 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice5) {
                        case 1:
                            quanlyPhieuNhapHang.docFile();;
                            break;
                        case 2:
                            quanlyPhieuNhapHang.ghiFile();
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
                        System.err.print("║      MENU : QUAN LY FILE CHI TIET PNH    ║\n");
                        System.out.print("╠══════════════════════════════════════════╣\n");
                        System.out.print("║  1. Doc Du Lieu Vao FILE Chi Tiet PNH    ║\n");
                        System.out.print("║  2. Ghi Du Lieu Vao FILE Chi Tiet PNH    ║\n");
                        System.out.print("║  0. Thoat                                ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice6 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice6) {
                        case 1:
                            quanlyChiTietPhieuNhapHang.docFile();
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.ghiFile();
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
