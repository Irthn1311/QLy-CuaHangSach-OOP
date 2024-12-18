package QuanLyNXB;

import java.util.Scanner;

public class QuanLyNhaXuatBan{
    Scanner sc=new Scanner(System.in);
    DanhSachNXB nxb=new DanhSachNXB();
    public void menu() {
        int choice;
        do{
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.print("║        MENU : Quan ly Nha Xuat Ban       ║\n");
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1. Doc Du Lieu File                     ║\n");
            System.out.print("║  2. Xem Danh Sach Nha Xuat Ban           ║\n");
            System.out.print("║  3. Them Nha Xuat Ban                    ║\n");
            System.out.print("║  4. Sua Nha Xuat Ban                     ║\n");
            System.out.print("║  5. Xoa Nha Xuat Ban                     ║\n");
            System.out.print("║  6. Tim Nha Xuat Ban                     ║\n");
            System.err.print("║  7. Ghi Du Lieu Vao File                 ║\n");
            System.out.print("║  0. Thoat                                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    nxb.docFile();
                    break;
                case 2:
                    nxb.xem();
                    break;
                case 3:
                    nxb.them();
                    break;
                case 4:
                    nxb.sua();
                    break;
                case 5:
                    nxb.xoa();
                    break;
                case 6:
                    nxb.timkiem();
                    break;
                case 7:
                    nxb.ghiFile();
                    break;
                case 0:
                    System.out.print("Thoat");
                    break;
                default:
                    System.out.print("\nLoi lua chon!");
            }
        }while(choice!=0);
    }
}