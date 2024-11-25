package QuanLyHoaDon;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import Interface.CRUD;

public class DSHoaDon implements CRUD{
    HoaDon[] dsHoaDon;
    ChiTietHoaDon[] dsChiTietHoaDon;
    private int size = 2;

    Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public DSHoaDon()
    {
        dsHoaDon = new HoaDon[size];
        dsChiTietHoaDon = new ChiTietHoaDon[size];
        dsHoaDon[0] = new HoaDon("HD001","KH001","NV001",LocalDate.parse("12-11-2024",sdf),500000.0);
        dsHoaDon[1] = new HoaDon("HD002","KH002","NV002",LocalDate.parse("23-11-2024",sdf),700000.0);

        dsChiTietHoaDon[0] = new ChiTietHoaDon("HD001","S001",3,20000.0);
        dsChiTietHoaDon[1] = new ChiTietHoaDon("HD002","KH002",2,50000);
    }

//    @Override
//    public void nhap() {
//        System.out.print("Nhap so luong hoa don:");
//        size = sc.nextInt();
//        dsHoaDon = new HoaDon[size];
//        dsChiTietHoaDon = new ChiTietHoaDon[size];
//        for(int i=0; i<size; i++)
//        {
//            System.out.println();
//            System.out.println("Nhap thong tin hoa don thu " + (i+1));
//            dsHoaDon[i] = new HoaDon();
//            dsChiTietHoaDon[i] = new ChiTietHoaDon();
//            dsHoaDon[i].Nhap();
//            dsChiTietHoaDon[i].Nhap();
//        }
//    }

    @Override
    public void xem() {
        System.out.println("Thong tin hoa don");
        if(size == 0)
        {
            System.out.println("Khong co hoa don.");
        } else {
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-12s | %-15s | %-15s | %-18s | %-10s | %-10s | %-10s |\n","  Ma hoa don", "  Ma khach hang", "  Ma nhan vien", "  Ngay tao hoa don", " Tong tien", " Tien nhan", " Tien thoi");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            for(int i=0; i<size; i++)
            {
                if(dsChiTietHoaDon[i] != null && dsChiTietHoaDon[i].getmaHD().equals(dsHoaDon[i].getmaHD()))
                {
                    dsHoaDon[i].settongTien(dsChiTietHoaDon[i].getthanhTien());
                    dsHoaDon[i].settienThoi(dsHoaDon[i].gettienNhan() - dsHoaDon[i].gettongTien());
                }
                dsHoaDon[i].Xuat();
            }
        }
    }

    @Override
    public void them() {

        if(size == dsHoaDon.length)
        {
            dsHoaDon = Arrays.copyOf(dsHoaDon,dsHoaDon.length+1);
            dsChiTietHoaDon = Arrays.copyOf(dsChiTietHoaDon, dsChiTietHoaDon.length + 1);
        }

        dsHoaDon[size] = new HoaDon();
        dsChiTietHoaDon[size] = new ChiTietHoaDon();
        dsHoaDon[size].Nhap();
        dsChiTietHoaDon[size].Nhap();
        size++;
    }


    @Override
    public void sua() {
        boolean payFind = false;
        System.out.print("Nhap ma hoa don can sua: ");
        sc.nextLine();
        String a = sc.nextLine().trim();
        for (int i = 0; i < dsHoaDon.length; i++) {
            if (dsHoaDon[i] != null && a.equals(dsHoaDon[i].getmaHD()))
            {
                System.out.println("Nhap lai thong tin hoa don: ");
                sc.nextLine();
                dsHoaDon[i].Nhap();
                dsChiTietHoaDon[i].Nhap();
                payFind = true;
                break;
            }
        }

        if (!payFind) {
            System.out.println("Khong tim thay ma hoa don can sua.");
        } else {
            System.out.println("Da sua xong.");
        }
    }

    @Override
    public void xoa()
    {
        boolean payFind = false;
        System.out.print("Nhap ma hoa don can xoa: ");
        sc.nextLine();
        String a = sc.nextLine();
        for(int i=0; i<dsHoaDon.length; i++)
        {
            if(dsHoaDon[i] != null && a.equals(dsHoaDon[i].getmaHD()))
            {
                System.arraycopy(dsHoaDon, i + 1, dsHoaDon, i, size - i - 1);
                dsHoaDon[size - 1] = null;
                size--;
                payFind = true;
                break;
            }
        }

        if(!payFind)
        {
            System.out.println("Khong tim thay ma hoa don can xoa.");
        } else {
            System.out.println("Da xoa xong.");
        }
    }

    @Override
    public void timkiem()
    {
        while (true)
        {
            System.out.println("0. Ket thuc.");
            System.out.println("1. Tim kiem hoa don.");
            System.out.println("2. Tim kiem theo ma khach hang.");
            System.out.println("3. Tim kiem theo ma nhan vien.");
            System.out.print("Nhap lua chon: ");
            int luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon)
            {
                case 0:
                    return;
                case 1:
                    boolean findCodeHD = false;
                    System.out.print("Nhap ma hoa don cam tim: ");
                    String find = sc.nextLine();
                    for(int i=0; i<dsHoaDon.length; i++)
                    {
                        if(dsHoaDon[i] != null && find.equals(dsHoaDon[i].getmaHD()))
                        {
                            dsHoaDon[i].Xuat();
                            findCodeHD = true;
                            break;
                        }
                    }

                    if(!findCodeHD)
                    {
                        System.out.println("Khong tim thay ma hoa don." + find);
                    }
                    break;
                case 2:
                    boolean findCustomer = false;
                    System.out.print("Nhap ma khach hang can tim: ");
                    String find1 = sc.nextLine();
                    for(int i=0; i<dsHoaDon.length; i++)
                    {
                        if(dsHoaDon[i] != null && find1.equals(dsHoaDon[i].getmaKH()))
                        {
                            dsHoaDon[i].Xuat();
                            findCustomer = true;
                            break;
                        }
                    }

                    if(!findCustomer)
                    {
                        System.out.println("Khong tim thay hoa don cua ma khach hang: " + find1);
                    }
                    break;
                case 3:
                    boolean findStaff = false;
                    System.out.println("Nhap ma nhan vien can tim: ");
                    String find2 = sc.nextLine();
                    for(int i=0; i<dsHoaDon.length; i++)
                    {
                        if(dsHoaDon[i] != null && find2.equals(dsHoaDon[i].getmaNV()))
                        {
                            dsHoaDon[i].Xuat();
                            findStaff = true;
                            break;
                        }
                    }

                    if(!findStaff)
                    {
                        System.out.println("Khong tim thay hoa don cua ma nhan vien: " + find2);
                    }
                    break;
                default:
                    System.out.println("Nhap sai! Ban vui long nhap dung.");
                    break;
            }
        }
    }

    @Override
    public void thongke() {
        while(true)
        {
            System.out.println("Chon tieu chi thong ke:");
            System.out.println("0. Ket thuc.");
            System.out.println("1. Theo ma nhan vien.");
            System.out.println("2. Theo ma khach hang.");
            System.out.println("3. Từ ngay A đến ngay B.");
            System.out.println("4. Theo quy.");
            System.out.print("Lua chon cua ban: ");
            int luachon = sc.nextInt();
            sc.nextLine();
            switch (luachon)
            {
                case 0:
                    return;

                case 1:
                    System.out.print("Nhap ma nhan vien: ");
                    String findStaff = sc.nextLine();
                    System.out.println("Hoa don lap boi ma nhan vien: " + findStaff);
                    for(int i=0; i< dsHoaDon.length; i++)
                    {
                        if(dsHoaDon[i] != null && findStaff.equals(dsHoaDon[i].getmaNV()))
                        {
                            dsHoaDon[i].Xuat();
                        }
                    }
                    break;

                case 2:
                    //boolean
                    System.out.print("Nhap ma khac hang: ");
                    String findCustomer = sc.nextLine();
                    System.out.println("Hoa don cua ma khach hang: " + findCustomer);
                    for(int i=0; i< dsHoaDon.length; i++)
                    {
                        if(dsHoaDon[i] != null && findCustomer.equals(dsHoaDon[i].getmaKH()))
                        {
                            dsHoaDon[i].Xuat();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhap ngay bat dau (dd-MM-yyyy): ");
                    String ngayBatDauStr = sc.nextLine();
                    System.out.print("Nhap ngay ket thuc (dd-MM-yyyy): ");
                    String ngayKetThucStr = sc.nextLine();

                    try {
                        LocalDate ngayBatDau = LocalDate.parse(ngayBatDauStr, sdf);
                        LocalDate ngayKetThuc = LocalDate.parse(ngayKetThucStr, sdf);

                        System.out.println("Hoa don tu ngay " + ngayBatDau + " den ngay " + ngayKetThuc + ":");
                        double tongTien = 0.0;

                        for (int i = 0; i < size; i++) {
                            if (dsHoaDon[i] != null &&
                                    (dsHoaDon[i].getngayTaoHD().isEqual(ngayBatDau) || dsHoaDon[i].getngayTaoHD().isAfter(ngayBatDau)) &&
                                    (dsHoaDon[i].getngayTaoHD().isEqual(ngayKetThuc) || dsHoaDon[i].getngayTaoHD().isBefore(ngayKetThuc))) {
                                tongTien += dsHoaDon[i].gettongTien();
                            }
                        }

                        System.out.println("Tong tien tu ngay " + ngayBatDau + " den ngay " + ngayKetThuc + " la: " + tongTien);

                    } catch (Exception e) {
                        System.out.println("Ngay nhap khong hop le!");
                    }
                    break;
                case 4:
                    double quy1=0.0, quy2=0.0, quy3=0.0, quy4=0.0, tongQuy= 0.0;
                    for(int j=1; j<=4; j++)
                    {
                        double tongTienMotQuy = 0.0;
                        for(int i=0; i<dsHoaDon.length; i++)
                        {
                            if(dsHoaDon[i] != null)
                            {
                                int month = dsHoaDon[i].getngayTaoHD().getMonthValue();
                                int quyHD = (month - 1)/3 + 1;

                                if(quyHD == j)
                                {
                                    tongTienMotQuy += dsHoaDon[i].gettongTien();
                                }
                            }
                        }

                        if(j == 1)
                            quy1 = tongTienMotQuy;
                        else if(j == 2)
                            quy2 = tongTienMotQuy;
                        else if(j ==3)
                            quy3 = tongTienMotQuy;
                        else if(j ==4)
                            quy4 = tongTienMotQuy;

                    }
                    tongQuy = quy1 + quy2 + quy3 + quy4;
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-20s |\n","Quy 1", "Quy 2", "Quy 3", "Quy 4", "Tong cong");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.printf("| %-15.2f | %-15.2f | %-15.2f | %-15.2f | %-20.2f |\n",quy1, quy2, quy3, quy4, tongQuy);
                    System.out.println("------------------------------------------------------------------------------------------------");

            }
        }
    }

    @Override
    public void docFile() {
        try {
            // Kiểm tra nếu dsHoaDon chưa được khởi tạo thì khởi tạo với kích thước mặc định
            if (dsHoaDon == null) {
                dsHoaDon = new HoaDon[10]; // Kích thước khởi tạo ban đầu
            }

            BufferedReader br = Files.newBufferedReader(new File("src/QuanLyHoaDon/HoaDon_Input.txt").toPath(), StandardCharsets.UTF_8);
            String line;
            size = 0; // Reset lại size để đếm số lượng hóa đơn

            // Đọc từng dòng trong file và lưu vào dsHoaDon
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setmaHD(fields[0]);
                    hoaDon.setmaKH(fields[1]);
                    hoaDon.setmaNV(fields[2]);
                    hoaDon.setngayTaoHD(LocalDate.parse(fields[3], sdf));
                    hoaDon.settienNhan(Double.parseDouble(fields[5])); // Tiền nhận

                    // Tăng kích thước mảng nếu cần thiết
                    if (size == dsHoaDon.length) {
                        dsHoaDon = Arrays.copyOf(dsHoaDon, size + 10); // Tăng thêm 10 phần tử mỗi lần mở rộng
                    }
                    dsHoaDon[size++] = hoaDon; // Thêm hóa đơn vào mảng và tăng size
                }
            }

            br.close();
            System.out.println("Đọc file thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }



    public void ghiFile() {
        try {
            for (int i = 0; i < size; i++) {
                if (dsHoaDon[i] != null) {
                    if (dsChiTietHoaDon[i] != null && dsChiTietHoaDon[i].getmaHD().equals(dsHoaDon[i].getmaHD())) {
                        dsHoaDon[i].settongTien(dsChiTietHoaDon[i].getthanhTien());
                    } else {
                        dsHoaDon[i].settongTien(0.0);
                    }

                    dsHoaDon[i].settienThoi(dsHoaDon[i].gettienNhan() - dsHoaDon[i].gettongTien());
                }
            }

            // Tiến hành ghi file
            PrintWriter pw = new PrintWriter("src/QuanLyHoaDon/HoaDon_Input.txt", "UTF-8");

            for (HoaDon hoaDon : dsHoaDon) {
                if (hoaDon != null) {
                    pw.println(String.join(",",
                            hoaDon.getmaHD(),
                            hoaDon.getmaKH(),
                            hoaDon.getmaNV(),
                            hoaDon.getngayTaoHD().format(sdf),
                            String.valueOf(hoaDon.gettongTien()),
                            String.valueOf(hoaDon.gettienNhan()),
                            String.valueOf(hoaDon.gettienThoi())
                    ));
                }
            }

            pw.close();
            System.out.println("Ghi file thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi khi ghi file!");
        }
    }


}

