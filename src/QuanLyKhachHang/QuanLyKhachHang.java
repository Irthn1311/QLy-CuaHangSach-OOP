import java.util.Scanner;

public class QuanLyKhachHang {
    Scanner sc=new Scanner(System.in);
    DSKhachHang quanlyKhachHang= new DSKhachHang();
    public void menu() {
        int choice;
        do {
            System.out.print("\n1.Xem Danh Sach Khach Hang");
            System.out.print("\n2.Them Khach Hang");
            System.out.print("\n3.Sua Khach Hang");
            System.out.print("\n4.Xoa Khach Hang");
            System.out.print("\n5.Tim Khach Hang");
            System.out.print("\n6.Thong Ke Khach Hang");
            System.out.print("\n7.Doc Du Lieu File");
            System.err.print("\n8.Ghi Du Lieu Vao File");
            System.out.print("\n0.Thoat");
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
