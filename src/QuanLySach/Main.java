package QuanLySach;

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        QuanLySach ql1 = new QuanLySach();
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("\n1.Quan Ly Sach");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    ql1.menu();
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