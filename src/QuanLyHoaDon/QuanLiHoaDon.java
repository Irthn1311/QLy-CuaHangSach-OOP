package QuanLyHoaDon;

import java.util.Scanner;

public class QuanLiHoaDon {
    Scanner sc = new Scanner(System.in);
    DSHoaDon quanLiHoaDon = new DSHoaDon();

    public void menu()
    {
        int luachon;
        while(true)
        {
            System.out.println("0. Thoat.");
            System.out.println("1. Xem Hoa Don.");
            System.out.println("2. Them Hoa Don.");
            System.out.println("3. Sua Hoa Don.");
            System.out.println("4. Xoa Hoa Don.");
            System.out.println("5. Tim Kiem Hoa Don.");
            System.out.println("6. Thong Ke Hoa Don.");
            System.out.println("7. Doc Du Lieu File");
            System.out.println("8. Ghi du lieu File.");
            System.out.print("Nhap lua chon cua ban: ");
            luachon = sc.nextInt();
            sc.nextLine();
            switch (luachon)
            {
                case 0:
                    return;
                case 1:
                    quanLiHoaDon.xem();
                    break;
                case 2:
                    quanLiHoaDon.them();
                    break;
                case 3:
                    quanLiHoaDon.sua();
                    break;
                case 4:
                    quanLiHoaDon.xoa();
                    break;
                case 5:
                    quanLiHoaDon.timkiem();
                    break;
                case 6:
                    quanLiHoaDon.thongke();
                    break;
                case 7:
                    quanLiHoaDon.docFile();
                    break;
                case 8:
                    quanLiHoaDon.ghiFile();
                    break;
                default:
                    System.out.println("Nhap sai! Vui long nhap dung.");
                    break;
            }
        }
    }
}

