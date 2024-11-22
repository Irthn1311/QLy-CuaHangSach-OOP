package QuanLySach;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        DSSach sach = new DSSach();
        sach.docFile();
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xem danh sách sách");
            System.out.println("3. Thống kê");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Sửa");
            System.out.println("6. Xóa");
            System.out.println("7. Lưu vào file");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            option = sc.nextInt();
            sc.nextLine(); // Đọc ký tự newline còn lại
            switch (option) {
                case 1:
                    sach.them();
                    break;
                case 2:
                    sach.xem();
                    break;
                case 3:
                    sach.thongke();
                    break;
                case 4:
                    sach.timkiem();
                    break;
                case 5:
                    sach.sua();
                    break;
                case 6:
                    sach.xoa();
                    break;
                case 7:
                    sach.ghiFile();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                    break;
            }
        } while (option != 0);
        sc.close();
    }
}