import java.util.Scanner;

public class QuanLyHoaDon {
    Scanner sc=new Scanner(System.in);
    DanhSachHoaDon quanlyHoaDon= new DanhSachHoaDon();
    DanhSachChiTietHoaDon quanlyChiTietHoaDon= new DanhSachChiTietHoaDon(quanlyHoaDon);
    public void menu() {
        int choice;
        do {
            System.out.print("\n1.Xem ");
            System.out.print("\n2.Them ");
            System.out.print("\n3.Sua ");
            System.out.print("\n4.Xoa ");
            System.out.print("\n5.Tim kiem Hoa Don Theo Ma");
            System.out.print("\n6.Thong Ke Hoa Don");
            System.out.print("\n7.Doc Va Ghi File Hoa Don Va Chi Tiet Hoa Don");
            System.out.print("\n0.Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.print("\n1.Xem Danh Sach Hoa Don");
                        System.out.print("\n2.Xem Danh Sach Chi Tiet Hoa Don");
                        System.out.print("\n3.Xem Hoa Don va Chi Tiet Hoa Don");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice1 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice1) {
                        case 1:
                            quanlyHoaDon.xuatHoaDon();
                            break;
                        case 2:
                            quanlyChiTietHoaDon.inDanhSachChiTietHD();
                            break;
                        case 3:
                            quanlyHoaDon.xuatHDvaChiTietHD(quanlyChiTietHoaDon);
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice1!=0);
                    break;
                case 2:
                    int choice2;
                    do {
                        System.out.print("\n1.Them Hoa Don va Chi Tiet Hoa Don");
                        System.out.print("\n2.Them Chi Tiet Hoa Don");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice2 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice2) {
                        case 1:
                            quanlyHoaDon.nhapHDvaChiTietHD(quanlyChiTietHoaDon);
                            break;
                        case 2:
                            quanlyChiTietHoaDon.themChiTietVaoHD();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice2!=0);
                    break;
                case 3:
                    int choice3;
                    do {
                        System.out.print("\n1.Sua Hoa Don");
                        System.out.print("\n2.Sua Chi Tiet Hoa Don");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice3 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice3) {
                        case 1:
                            quanlyHoaDon.suaHoaDon();
                            break;
                        case 2:
                            quanlyChiTietHoaDon.suaChiTietHD();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice3!=0);
                    break;
                case 4:
                    int choice4;
                    do {
                        System.out.print("\n1.Xoa Hoa Don");
                        System.out.print("\n2.Xoa Chi Tiet Hoa Don");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice4 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice4) {
                        case 1:
                            quanlyHoaDon.xoaPhieuTheoMaHD();
                            break;
                        case 2:
                            quanlyChiTietHoaDon.xoaChiTietHD();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice4!=0);
                    break;
                case 5:
                    quanlyHoaDon.timPhieuTheoMaHD();
                    break;
                case 6:
                    quanlyHoaDon.thongKe();
                    break;
                case 7:
                    int choice5;
                    do {
                        System.out.print("\n1.Doc Du Lieu Vao File Hoa Don");
                        System.out.print("\n2.Ghi Du Lieu Vao File Hoa Don");
                        System.out.print("\n3.Doc Du Lieu File Chi Tiet Hoa Don");
                        System.out.print("\n4.Ghi Du Lieu Vao File Chi Tiet Hoa Don");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice5 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice5) {
                        case 1:
                            quanlyHoaDon.docFile();;
                            break;
                        case 2:
                            quanlyHoaDon.ghiFile();
                            break;
                        case 3:
                            quanlyChiTietHoaDon.docFile();
                            break;
                        case 4:
                            quanlyChiTietHoaDon.ghiFile();
                            break;
                        case 0:
                            System.out.print("\nThoat");
                            break;
                        default:
                            System.out.print("\nNhap Sai Vui Long Nhap Lai");
                            break;
                        }
                        
                    } while (choice5!=0);
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
