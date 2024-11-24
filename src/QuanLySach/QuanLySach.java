import java.util.Scanner;
public class QuanLySach {
    DSSach quanlysach = new DSSach();
    Scanner sc = new Scanner(System.in);
    public void menu() {
        int choice;
        do {
            System.out.print("\n1.Xem Danh Sach Sach");
            System.out.print("\n2.Them Sach");
            System.out.print("\n3.Sua Sach");
            System.out.print("\n4.Xoa Sach");
            System.out.print("\n5.Tim Sach");
            System.out.print("\n6.Thong Ke Sach");
            System.out.print("\n7.Doc Du Lieu File");
            System.err.print("\n8.Ghi Du Lieu Vao File");
            System.out.print("\n0.Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer after nextInt()
            switch (choice) {
                case 1:
                    quanlysach.xem();
                    break;
                case 2:
                    quanlysach.them();
                    break;
                case 3:
                    quanlysach.sua();
                    break;
                case 4:
                    quanlysach.xoa();
                    break;
                case 5:
                    quanlysach.timkiem();
                    break;
                case 6:
                    quanlysach.thongke();
                    break;
                case 7:
                    quanlysach.docFile();
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