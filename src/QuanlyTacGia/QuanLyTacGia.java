package QuanlyTacGia;

import java.util.Scanner;

public class QuanLyTacGia {
    DSTacGia quanlyTacGia = new DSTacGia();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        int choice;
        do {
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.print("║        MENU : Quan ly Tac Gia            ║\n");
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1. Doc Du Lieu File                     ║\n");
            System.out.print("║  2. Xem Danh Sach Tac Gia                ║\n");
            System.out.print("║  3. Them Tac Gia                         ║\n");
            System.out.print("║  4. Sua Tac Gia                          ║\n");
            System.out.print("║  5. Xoa Tac Gia                          ║\n");
            System.out.print("║  6. Tim Tac Gia                          ║\n");
            System.out.print("║  7. Thong Ke Tac Gia                     ║\n");
            System.err.print("║  8. Ghi Du Lieu Vao File                 ║\n");
            System.out.print("║  0. Thoat                                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer after nextInt()
            switch (choice) {
                case 1:
                    quanlyTacGia.docFile();
                    break;
                case 2:
                    quanlyTacGia.xem();
                    break;
                case 3:
                    quanlyTacGia.them();
                    break;
                case 4:
                    quanlyTacGia.sua();
                    break;
                case 5:
                    quanlyTacGia.xoa();
                    break;
                case 6:
                    quanlyTacGia.timkiem();
                    break;
                case 7:
                    quanlyTacGia.thongke();
                    break;
                case 8:
                    quanlyTacGia.ghiFile();
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