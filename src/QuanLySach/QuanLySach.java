package QuanLySach;

import java.util.Scanner;
public class QuanLySach {
    dsSach quanlysach = new dsSach();
    Scanner sc = new Scanner(System.in);
    public void menu() {
        int choice;
        do {
            System.out.print("\n1.Doc Du Lieu Tu File");
            System.out.print("\n2.Xem Danh Sach Sach");
            System.out.print("\n3.Them Sach");
            System.out.print("\n4.Sua Sach");
            System.out.print("\n5.Xoa Sach");
            System.out.print("\n6.Tim Sach");
            System.out.print("\n7.Thong Ke Sach");
            System.err.print("\n8.Ghi Du Lieu Vao File");
            System.out.print("\n0.Thoat");
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