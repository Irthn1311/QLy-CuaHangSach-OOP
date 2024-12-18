package QuanLyNhanVien;

import java.util.Scanner;

public class QuanLyNhanVien {
    Scanner sc=new Scanner(System.in);
    DSNhanVien quanlyNhanVien= new DSNhanVien();
    public void menu() {
        int choice;
        do {
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.print("║        MENU : Quan ly Nhan Vien          ║\n");
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1. Doc Du Lieu File                     ║\n");
            System.out.print("║  2. Xem Danh Sach Nhan Vien              ║\n");
            System.out.print("║  3. Them Nhan Vien                       ║\n");
            System.out.print("║  4. Sua Nhan Vien                        ║\n");
            System.out.print("║  5. Xoa Nhan Vien                        ║\n");
            System.out.print("║  6. Tim Nhan Vien                        ║\n");
            System.out.print("║  7. Thong Ke Nhan Vien                   ║\n");
            System.err.print("║  8. Ghi Du Lieu Vao File                 ║\n");
            System.out.print("║  0. Thoat                                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    quanlyNhanVien.docFile();
                    break;
                case 2:
                    quanlyNhanVien.xem();
                    break;
                case 3:
                    quanlyNhanVien.them();
                    break;
                case 4:
                    quanlyNhanVien.sua();
                    break;
                case 5:
                    quanlyNhanVien.xoa();
                    break;
                case 6:
                    quanlyNhanVien.timkiem();
                    break;
                case 7:
                    quanlyNhanVien.thongke();
                    break;
                case 8:
                    quanlyNhanVien.ghiFile();
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
