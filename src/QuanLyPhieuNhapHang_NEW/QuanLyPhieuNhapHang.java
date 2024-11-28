import java.util.Scanner;

public class QuanLyPhieuNhapHang {
    Scanner sc=new Scanner(System.in);
    DanhSachPhieuNhapHang quanlyPhieuNhapHang= new DanhSachPhieuNhapHang();
    DanhSachChiTietPhieuNhapHang quanlyChiTietPhieuNhapHang= new DanhSachChiTietPhieuNhapHang(quanlyPhieuNhapHang);
    public void menu() {
        int choice;
        do {
            System.out.print("\n1.Xem ");
            System.out.print("\n2.Them ");
            System.out.print("\n3.Sua ");
            System.out.print("\n4.Xoa ");
            System.out.print("\n5.Tim kiem Phieu Nhap Hang Theo Ma");
            System.out.print("\n6.Thong Ke Phieu Nhap Hang");
            System.out.print("\n7.Doc Va Ghi File Phieu Nhap Hang Va Chi Tiet Phieu Nhap Hang");
            System.out.print("\n0.Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.print("\n1.Xem Danh Sach Phieu Nhap Hang");
                        System.out.print("\n2.Xem Danh Sach Chi Tiet Phieu Nhap Hang");
                        System.out.print("\n3.Xem Phieu Nhap Hang va Chi Tiet Phieu Nhap Hang");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice1 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice1) {
                        case 1:
                            quanlyPhieuNhapHang.xuatPhieuNhapHang();
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.inDanhSachChiTietPNH();
                            break;
                        case 3:
                            quanlyPhieuNhapHang.xuatPNHvaChiTietPNH(quanlyChiTietPhieuNhapHang);
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
                        System.out.print("\n1.Them Phieu Nhap Hang va Chi Tiet Phieu Nhap Hang");
                        System.out.print("\n2.Them Chi Tiet Phieu Nhap Hang");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice2 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice2) {
                        case 1:
                            quanlyPhieuNhapHang.nhapPNHvaChiTietPNH(quanlyChiTietPhieuNhapHang);
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.themChiTietVaoPNH();
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
                        System.out.print("\n1.Sua Phieu Nhap Hang");
                        System.out.print("\n2.Sua Chi Tiet Phieu Nhap Hang");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice3 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice3) {
                        case 1:
                            quanlyPhieuNhapHang.suaPhieuNhapHang();
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.suaChiTietPNH();
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
                        System.out.print("\n1.Xoa Phieu Nhap Hang");
                        System.out.print("\n2.Xoa Chi Tiet Phieu Nhap Hang");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice4 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice4) {
                        case 1:
                            quanlyPhieuNhapHang.xoaPhieuTheoMaPNH();
                            break;
                        case 2:
                            quanlyChiTietPhieuNhapHang.xoaChiTietPNH();
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
                    quanlyPhieuNhapHang.timPhieuTheoMaPNH();
                    break;
                case 6:
                    quanlyPhieuNhapHang.thongKe();
                    break;
                case 7:
                    int choice5;
                    do {
                        System.out.print("\n1.Doc Du Lieu Vao File Phieu Nhap Hang");
                        System.out.print("\n2.Ghi Du Lieu Vao File Phieu Nhap Hang");
                        System.out.print("\n3.Doc Du Lieu File Chi Tiet Phieu Nhap Hang");
                        System.out.print("\n4.Ghi Du Lieu Vao File Chi Tiet Phieu Nhap Hang");
                        System.out.print("\n0.Thoat");
                        System.out.print("\nLua Chon Cua Ban: ");
                        choice5 = sc.nextInt();
                        sc.nextLine(); 
                        switch (choice5) {
                        case 1:
                            quanlyPhieuNhapHang.docFile();;
                            break;
                        case 2:
                            quanlyPhieuNhapHang.ghiFile();
                            break;
                        case 3:
                            quanlyChiTietPhieuNhapHang.docFile();
                            break;
                        case 4:
                            quanlyChiTietPhieuNhapHang.ghiFile();
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
