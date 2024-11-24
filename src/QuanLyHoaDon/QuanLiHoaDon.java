    package src.QuanLyHoaDon;

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
                System.out.println("4. Tim Kiem Hoa Don.");
                System.out.println("5. Thong Ke Hoa Don.");
                System.out.println("6. Doc Du Lieu File");
                System.out.println("7. Ghi du lieu File.");
                System.out.println("Nhap lua chon cua ban: ");
                luachon = sc.nextInt();
                switch (luachon)
                {
                    case 0:
                        return;
                    case 1:
                        quanLiHoaDon.xem();
                        System.in.read();
                    case 2:
                        quanLiHoaDon.them();
                        System.in.read();
                        break;
                    case 3:
                        quanLiHoaDon.sua();
                        System.in.read();
                        break;
                    case 4:
                        quanLiHoaDon.timkiem();
                        System.in.read();
                        break;
                    case 5:
                        quanLiHoaDon.thongke();
                        System.in.read();
                        break;
                    case 6:
                        quanLiHoaDon.docFile();
                        System.in.read();
                        break;
                    case 7:
                        quanLiHoaDon.ghiFile();
                        System.in.read();
                        break;
                    default:
                        System.out.println("Nhap sai! Vui long nhap dung.");
                        break;
                }
            }
        }
    }
