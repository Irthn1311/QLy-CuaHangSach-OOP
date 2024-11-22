import java.util.Scanner;

public class QuanLyTacGia {
    DSTacGia quanlyTacGia = new DSTacGia();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        int choice;
        do {
            System.out.print("\n1.Xem Danh Sach Tac Gia");
            System.out.print("\n2.Them Tac Gia");
            System.out.print("\n3.Sua Tac Gia");
            System.out.print("\n4.Xoa Tac Gia");
            System.out.print("\n5.Tim Tac Gia");
            System.out.print("\n6.Thong Ke Tac Gia");
            System.out.print("\n7.Doc Du Lieu File");
            System.err.print("\n8.Ghi Du Lieu Vao File");
            System.out.print("\n0.Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer after nextInt()
            switch (choice) {
                case 1:
                    quanlyTacGia.xem();
                    break;
                case 2:
                    quanlyTacGia.them();
                    break;
                case 3:
                    quanlyTacGia.sua();
                    break;
                case 4:
                    quanlyTacGia.xoa();
                    break;
                case 5:
                    quanlyTacGia.timkiem();
                    break;
                case 6:
                    quanlyTacGia.thongke();
                    break;
                case 7:
                    quanlyTacGia.docFile();
                    break;
                case 8:
                    quanlyTacGia.ghiFile();
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