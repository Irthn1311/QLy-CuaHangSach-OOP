import java.util.Scanner;

public class QuanLyNhanVien {
    Scanner sc=new Scanner(System.in);
    DSNhanVien quanlyNhanVien= new DSNhanVien();
    public void menu() {
        int choice;
        do {
            System.out.print("\n1.Xem Danh Sach Nhan Vien");
            System.out.print("\n2.Them Nhan Vien");
            System.out.print("\n3.Sua Nhan Vien Theo Ma");
            System.out.print("\n4.Xoa Nhan Vien Theo Ma");
            System.out.print("\n5.Tim Nhan Vien");
            System.out.print("\n6.Thong Ke Nhan Vien");
            System.out.print("\n7.Doc Du Lieu File");
            System.out.print("\n8.Ghi Du Lieu Vao File");
            System.out.print("\n0.Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    quanlyNhanVien.xem();
                    break;
                case 2:
                    quanlyNhanVien.them();
                    break;
                case 3:
                    quanlyNhanVien.sua();
                    break;
                case 4:
                    quanlyNhanVien.xoa();
                    break;
                case 5:
                    quanlyNhanVien.timkiem();
                    break;
                case 6:
                    quanlyNhanVien.thongke();
                    break;
                case 7:
                    quanlyNhanVien.docFile();
                    break;
                case 8:
                    quanlyNhanVien.ghiFile();
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
