import java.util.Scanner;

public class QuanLyKhachHang {
    Scanner sc=new Scanner(System.in);
    DSKhachHang quanlyKhachHang= new DSKhachHang();
    public void menu() {
        int choice;
        do {
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.print("║        MENU : Quan ly Khach Hang         ║\n");
            System.out.print("╠══════════════════════════════════════════╣\n");
            System.out.print("║  1.Xem Danh Sach Khach Hang              ║\n");
            System.out.print("║  2.Them Khach Hang                       ║\n");
            System.out.print("║  3.Sua Khach Hang                        ║\n");
            System.out.print("║  4.Xoa Khach Hang                        ║\n");
            System.out.print("║  5.Tim Khach Hang                        ║\n");
            System.out.print("║  6.Thong Ke Khach Hang                   ║\n");
            System.out.print("║  7.Doc Du Lieu File                      ║\n");
            System.err.print("║  8.Ghi Du Lieu Vao File                  ║\n");
            System.out.print("║  0.Thoat                                 ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    quanlyKhachHang.xem();
                    break;
                case 2:
                    quanlyKhachHang.them();
                    break;
                case 3:
                    quanlyKhachHang.sua();
                    break;
                case 4:
                    quanlyKhachHang.xoa();
                    break;
                case 5:
                    quanlyKhachHang.timkiem();
                    break;
                case 6:
                    quanlyKhachHang.thongke();
                    break;
                case 7:
                    quanlyKhachHang.docFile();
                    break;
                case 8:
                    quanlyKhachHang.ghiFile();
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
