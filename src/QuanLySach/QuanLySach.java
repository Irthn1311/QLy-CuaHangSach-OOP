package QuanLySach;

import java.util.Scanner;
public class QuanLySach {
    dsSach quanlysach = new dsSach();
    Scanner sc = new Scanner(System.in);
    public void menu() {
        int choice;
        do {
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.print("║        MENU : Quan ly Sach               ║\n");
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1. Doc Du Lieu File                     ║\n");
            System.out.print("║  2. Xem Danh Sach Sach                   ║\n");
            System.out.print("║  3. Them Sach                            ║\n");
            System.out.print("║  4. Sua Sach                             ║\n");
            System.out.print("║  5. Xoa Sach                             ║\n");
            System.out.print("║  6. Tim Sach                             ║\n");
            System.out.print("║  7. Thong Ke Sach                        ║\n");
            System.err.print("║  8. Ghi Du Lieu Vao File                 ║\n");
            System.out.print("║  0. Thoat                                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer after nextInt()
            switch (choice) {
                case 1:
                    quanlysach.docFile();
                    break;
                case 2:
                    quanlysach.xem();
                    break;
                case 3:
                    quanlysach.them();
                    break;
                case 4:
                    quanlysach.sua();
                    break;
                case 5:
                    quanlysach.xoa();
                    break;
                case 6:
                    quanlysach.timkiem();
                    break;
                case 7:
                    quanlysach.thongke();
                    break;
                case 8:
                    quanlysach.ghiFile();
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