package src.QuanLyHoaDon;

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
     HoaDon[] DSHD;
    private int size = 3;
//    private final int MAX_SIZE = 100;

    Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public DSHoaDon()
    {
        DSHD = new HoaDon[size];
        DSHD[0] = new HoaDon("HD001", "KH001", "NV001", LocalDate.parse("22-11-2024", sdf), 1000000.0, 500000.0, 500000.0);
        DSHD[1] = new HoaDon("HD002", "KH002", "NV002", LocalDate.parse("23-11-2024", sdf), 2000000.0, 1000000.0, 1000000.0);
        DSHD[2] = new HoaDon("HD003", "KH003", "NV003", LocalDate.parse("24-11-2024", sdf), 3000000.0, 2000000.0, 1000000.0);
    }

    @Override
    public void xem() {
        System.out.println("Thong tin hoa don");
        for(HoaDon hoadon : DSHD)
            if(hoadon != null)
                hoadon.Xuat();
    }

    @Override
    public void them() {
        for(int i=0; i< DSHD.length; i++)
        {
            if(DSHD[i] == null)
            {
                DSHD[i] = new HoaDon();
                DSHD[i].Nhap();
                size++;
                return;
            }
        }

        DSHD = Arrays.copyOf(DSHD,DSHD.length+1);
        DSHD[size] = new HoaDon();
        DSHD[size].Nhap();
        size++;
    }


    @Override
    public void sua()
    {
        boolean payFind = false;
        System.out.print("Nhap ma hoa don can sua: ");
        String a = sc.nextLine();
        for(int i=0; i<DSHD.length; i++)
        {
            if(DSHD[i] != null && a.equals(DSHD[i].getmaHD()))
            {
                DSHD[i].Nhap();
                payFind = true;
                break;
            }
        }

        if(!payFind)
        {
            System.out.println("Khong tim thay ma hoa don can sua.");
        }
        else
        {
            System.out.print("Da sua xong.");
        }
    }

    @Override
    public void xoa()
    {
        boolean payFind = false;
        System.out.print("Nhap ma hoa don can xoa: ");
        String a = sc.nextLine();
        for(int i=0; i<DSHD.length; i++)
        {
            if(DSHD[i] != null && a.equals(DSHD[i].getmaHD()))
            {
                System.arraycopy(DSHD, i + 1, DSHD, i, size - i - 1);
                DSHD[size - 1] = null;
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
                    for(int i=0; i<DSHD.length; i++)
                    {
                        if(DSHD[i] != null && find.equals(DSHD[i].getmaHD()))
                        {
                            DSHD[i].Xuat();
                            findCodeHD = true;
                            break;
                        }
                    }

                    if(!findCodeHD)
                    {
                        System.out.println("Khong tim thay ma hoa don." + find);
                    }
                    System.in.read();
                    break;
                case 2:
                    boolean findCustomer = false;
                    System.out.print("Nhap ma khach hang can tim: ");
                    String find1 = sc.nextLine();
                    for(int i=0; i<DSHD.length; i++)
                    {
                        if(DSHD[i] != null && find1.equals(DSHD[i].getmaKH()))
                        {
                            DSHD[i].Xuat();
                            findCustomer = true;
                            break;
                        }
                    }

                    if(!findCustomer)
                    {
                        System.out.println("Khong tim thay hoa don cua ma khach hang: " + find1);
                    }
                    System.in.read();
                    break;
                case 3:
                    boolean findStaff = false;
                    System.out.println("Nhap ma nhan vien can tim: ");
                    String find2 = sc.nextLine();
                    for(int i=0; i<DSHD.length; i++)
                    {
                        if(DSHD[i] != null && find2.equals(DSHD[i].getmaNV()))
                        {
                            DSHD[i].Xuat();
                            findStaff = true;
                            break;
                        }
                    }

                    if(!findStaff)
                    {
                        System.out.println("Khong tim thay hoa don cua ma nhan vien: " + find2);
                    }
                    System.in.read();
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
                    for(int i=0; i< DSHD.length; i++)
                    {
                        if(DSHD[i] != null && findStaff.equals(DSHD[i].getmaNV()))
                        {
                            DSHD[i].Xuat();
                        }
                    }
                    System.in.read();
                    break;

                case 2:
                    //boolean
                    System.out.print("Nhap ma khac hang: ");
                    String findCustomer = sc.nextLine();
                    System.out.println("Hoa don cua ma khach hang: " + findCustomer);
                    for(int i=0; i< DSHD.length; i++)
                    {
                        if(DSHD[i] != null && findCustomer.equals(DSHD[i].getmaKH()))
                        {
                            DSHD[i].Xuat();
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
                        for (int i = 0; i < DSHD.length; i++) {
                            if (DSHD[i] != null &&
                                    (DSHD[i].getngayTaoHD().isEqual(ngayBatDau) || DSHD[i].getngayTaoHD().isAfter(ngayBatDau)) &&
                                    (DSHD[i].getngayTaoHD().isEqual(ngayKetThuc) || DSHD[i].getngayTaoHD().isBefore(ngayKetThuc))) {
                                DSHD[i].Xuat();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Ngay nhap khong hop le!");
                    }
                    break;
                case 4:
                    double quy1=0.0, quy2=0.0, quy3=0.0, quy4=0.0, tongQuy= 0.0;
                    for(int j=1; j<=4; j++)
                    {
                       double tongTienMotQuy = 0.0;
                       for(int i=0; i<DSHD.length; i++)
                       {
                           if(DSHD[i] != null)
                           {
                               int month = DSHD[i].getngayTaoHD().getMonthValue();
                               int quyHD = (month - 1)/3 + 1;

                               if(quyHD == j)
                               {
                                   tongTienMotQuy += DSHD[i].gettongTien();
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
                    System.out.printf("--------------------------------------------------------------");
                    System.out.printf("|Quy 1: %-10s | Quy 2: %-10s | Quy 3: %-10s | Quy 4: %-10s | Tong cong: %-15s|\n",quy1,quy2,quy3,quy4,tongQuy);
            }
        }
    }

    @Override
    public void docFile() {
        File file = new File("HoaDon_Input.txt");

        try {
            if (!file.exists()) {
                System.out.println("File mới đã được tạo.");
                file.createNewFile();
            }

            try (BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
                String line;
                boolean isEmpty = true;

                while ((line = br.readLine()) != null) {
                    isEmpty = false;
                    String[] data = line.split(",");

                    if (data.length == 7) {
                        try {
                            String maHD = data[0].trim();
                            String maKH = data[1].trim();
                            String maNV = data[2].trim();
                            LocalDate ngayTaoHD = LocalDate.parse(data[3].trim(), sdf);
                            double tongTien = Double.parseDouble(data[4].trim());
                            double tienDaThu = Double.parseDouble(data[5].trim());
                            double tienConLai = Double.parseDouble(data[6].trim());

                            // Tạo một hóa đơn mới với dữ liệu đọc được
                            HoaDon hoaDon = new HoaDon(maHD, maKH, maNV, ngayTaoHD, tongTien, tienDaThu, tienConLai);

                            // Thêm vào mảng DSHD
                            boolean add = false;
                            for (int i = 0; i < DSHD.length; i++) {
                                if (DSHD[i] == null) {
                                    DSHD[i] = hoaDon;
                                    add = true;
                                    break;
                                }
                            }

                            if (!add) {
                                // Nếu mảng DSHD đầy, thì mở rộng mảng và thêm hóa đơn mới vào
                                DSHD = Arrays.copyOf(DSHD, DSHD.length + 1);
                                DSHD[DSHD.length - 1] = hoaDon;
                            }
                        } catch (Exception e) {
                            System.out.println("Dữ liệu không hợp lệ trong dòng: " + line);
                        }
                    } else {
                        System.out.println("Dữ liệu không hợp lệ trong dòng: " + line);
                    }
                }

                if (isEmpty) {
                    System.out.println("File rỗng.");
                }

            } catch (Exception e) {
                System.out.println("Đọc file không thành công: ");
            }

        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    @Override
    public void ghiFile() {
        try {
            PrintWriter pw = new PrintWriter("HoaDon_Input.txt", "UTF-8");

            // Duyệt qua danh sách hóa đơn và ghi vào file
            for (HoaDon hoaDon : DSHD) {
                if (hoaDon != null) {
                    // Ghi hóa đơn với định dạng CSV
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
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

}
