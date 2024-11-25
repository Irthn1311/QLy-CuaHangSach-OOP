package QuanLyPhieuNhapHang;

import java.util.Scanner;

public class DanhSachPNH {
    private ChiTietPhieuNhapHang[] listPNH;  
    private int size; 
    private Scanner sc;

    // Constructor
    public DanhSachPNH() {
        this.size = 0;  // Initial size is 0
        this.listPNH = new ChiTietPhieuNhapHang[100];  
        this.sc = new Scanner(System.in);
    }

    // Method to display menu
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== Menu Phieu Nhap Hang =====");
            System.out.println("1. Xem Danh Sach Phieu Nhap Hang");
            System.out.println("2. Them Phieu Nhap Hang");
            System.out.println("3. Sua Phieu Nhap Hang");
            System.out.println("4. Xoa Phieu Nhap Hang");
            System.out.println("5. Tim Kiem Phieu Nhap Hang");
            System.out.println("6. Thong Ke Phieu Nhap Hang");
            System.out.println("0. Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    xem();
                    break;
                case 2:
                    them();
                    break;
                case 3:
                    sua();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    timKiem();
                    break;
                case 6:
                    thongKe();
                    break;
                case 0:
                    System.out.println("Thoat!");
                    break;
                default:
                    System.out.println("Nhap sai! Vui long nhap lai.");
                    break;
            }
        } while (choice != 0); 
    }


    public void xem() {
        System.out.println("\nDanh Sach Phieu Nhap Hang:");
        if (size == 0) {
            System.out.println("Danh sach trong!");
        } else {
            for (int i = 0; i < size; i++) {
                listPNH[i].xuat();
            }
        }
    }


    public void them() {
        if (size == listPNH.length) {
            ChiTietPhieuNhapHang[] newList = new ChiTietPhieuNhapHang[listPNH.length * 2];
            System.arraycopy(listPNH, 0, newList, 0, listPNH.length);
            listPNH = newList;
        }

        ChiTietPhieuNhapHang newItem = new ChiTietPhieuNhapHang();
        newItem.nhap(); 
        listPNH[size] = newItem;  
        size++; 
        System.out.println("Phieu Nhap Hang moi da duoc them!");
    }


    public void sua() {
        System.out.print("\nNhap ma CTPNH can sua: ");
        String maCTPNH = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (listPNH[i].getMa_CTPNH().equals(maCTPNH)) {
                listPNH[i].nhap(); 
                found = true;
                System.out.println("Phieu Nhap Hang da duoc sua!");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay Phieu Nhap Hang voi ma: " + maCTPNH);
        }
    }

 
    public void xoa() {
        System.out.print("\nNhap ma CTPNH can xoa: ");
        String maCTPNH = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (listPNH[i].getMa_CTPNH().equals(maCTPNH)) {

                for (int j = i; j < size - 1; j++) {
                    listPNH[j] = listPNH[j + 1];
                }
                listPNH[size - 1] = null;  
                size--; 
                found = true;
                System.out.println("Phieu Nhap Hang da duoc xoa!");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay Phieu Nhap Hang voi ma: " + maCTPNH);
        }
    }


    public void timKiem() {
        System.out.print("\nNhap ma CTPNH can tim: ");
        String maCTPNH = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (listPNH[i].getMa_CTPNH().equals(maCTPNH)) {
                listPNH[i].xuat();  
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay Phieu Nhap Hang voi ma: " + maCTPNH);
        }
    }


    public void thongKe() {
        double totalValue = 0;
        for (int i = 0; i < size; i++) {
            totalValue += listPNH[i].getThanhTien();  
        }
        System.out.println("Tong gia tri cua tat ca phieu nhap hang: " + totalValue);
    }
}
