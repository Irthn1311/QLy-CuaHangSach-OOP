package QuanLySach;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        dsSach ds = new dsSach();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Them sach");
            System.out.println("2. Xuat danh sach sach");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    ds.them();
                    break;
                case 2:
                    ds.xuat();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);

        sc.close();
    }
}