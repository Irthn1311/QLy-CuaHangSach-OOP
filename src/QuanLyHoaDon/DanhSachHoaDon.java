package QuanLyHoaDon;

import Interface.CRUD2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
public class DanhSachHoaDon implements CRUD2 {
    Scanner sc=new Scanner(System.in);
    private HoaDon[] dsHD;
    private int size;

    public DanhSachHoaDon() {
        // Khởi tạo mảng phiếu nhập hàng với kích thước mặc định
        dsHD = new HoaDon[100]; // Hoặc kích thước cần thiết
        size = 0; // Số lượng phiếu bắt đầu là 0
    }

    // Kiểm tra mã phiếu trùng lặp
    private boolean KiemTraMaHDTonTai(String maHD_New){
        for(HoaDon HD: dsHD){
            if(HD!=null && HD.getmaHD().equals(maHD_New) ){
                return true;  // Mã phiếu đã tồn tại
            }
        }
        return false; // Mã phiếu chưa tồn tại  
    }

    public HoaDon[] getdsHD() {
        return dsHD;
    }

    public void xuatHoaDon(){
        if (size == 0) {
            System.out.println("Danh Sach Rong.");
            return;
        }

        // In danh sách các phiếu nhập (phần thông tin cơ bản của từng phiếu)
        System.out.println("Danh Sach Hoa Don");
        for(HoaDon HD: dsHD){
            if (HD!=null) {
                HD.xuat();
            }

        }
    }

    public void nhapHDvaChiTietHD(DanhSachChiTietHoaDon dsChiTietHD){
        while(true){
            // Tạo phiếu mới
            HoaDon HD_new= new HoaDon();
            HD_new.nhap();

            // Kiểm tra mã phiếu trùng lặp
            if(KiemTraMaHDTonTai(HD_new.getmaHD())){
                System.out.println("\nMa Hoa Don Da Ton Tai. Vui Long Nhap Lai!");
            }else{
                // Mã phiếu hợp lệ, thêm vào danh sách phiếu
                dsHD=Arrays.copyOf(dsHD, size+1);
                dsHD[size] = HD_new;
                size++;

                // Nhập danh sách chi tiết cho phiếu này
                System.out.print("Nhap So Luong Chi Tiet Cho Phieu: ");
                int soChiTiet = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < soChiTiet; i++) {
                    System.out.println("Nhap Chi Tiet Thu " + (i + 1) + ":");
                    dsChiTietHD.themChiTietVaoHD(HD_new.getmaHD());
                }
                break;
            }
        }
    }

    public void xuatHDvaChiTietHD(DanhSachChiTietHoaDon dsChiTietHD){
        if (size == 0) {
            System.out.println("Danh Sach Rong.");
            return;
        }

        System.out.println("Danh Sach Hoa Va Chi Tiet Hoa Don");
        for(HoaDon HD: dsHD){
            if(HD !=null){
                System.out.println("\nPhieu Nhap Hang " + HD.getmaHD() + " :");
                HD.xuat();
                System.out.println("\nChi Tiet Phieu Nhap Hang " + HD.getmaHD() + " :");
                dsChiTietHD.inChiTietTheoMaHD(HD.getmaHD());
            }
        }
    }

    public int timViTriMaHD(String maHD){
        for (int i = 0; i < size; i++) {
            if (dsHD[i] !=null) {
                if (dsHD[i].getmaHD().equals(maHD )) // So sánh trực tiếp kiểu int
                    return i;
            }
        }
        return -1;
    }

    public void xoaPhieuTheoMaHD(){
        // Tìm vị trí phiếu nhập hàng cần xóa
        System.out.print("Nhap Ma Hoa Don Can Xoa: ");
        String MaHD = sc.nextLine();
        int vt=timViTriMaHD(MaHD);

        if(vt!= -1){
            // Dịch chuyển các phần tử sau vị trí xóa lên trước
            for (int i = vt; i < size - 1; i++) {
                dsHD[i] = dsHD[i + 1];
            }
            dsHD=Arrays.copyOf(dsHD, size-1);
            size--;
            System.out.print("\n╔══════════════════════════════════════════\n");
            System.out.printf("║      Da Xoa Hoa Don Voi Ma : %s\n" ,MaHD);
            System.out.print("╚══════════════════════════════════════════");
        }else{
            System.out.print("\n╔══════════════════════════════════════════\n");
            System.out.printf("║      Khong Tim Thay Ma Hoa Don: %s\n" ,MaHD);
            System.out.print("╚══════════════════════════════════════════");
        }
    }

    public void timPhieuTheoMaHD(){
        System.out.print("Nhap Ma Hoa Don Can Tim: ");
        String MaHD = sc.nextLine();
        int vt=timViTriMaHD(MaHD);

        if(vt!=-1){
            dsHD[vt].xuat();
        }else{
            System.out.print("\n╔══════════════════════════════════════════\n");
            System.out.printf("║      Khong Tim Thay Ma Hoa Don: %s\n" ,MaHD);
            System.out.print("╚══════════════════════════════════════════");
        }
    }

    public void suaHoaDon(){
        System.out.print("Nhap Ma Hoa Don Can Sua: ");
        String MaHD = sc.nextLine();
        int vt=timViTriMaHD(MaHD);

        if(vt!=-1){
            System.out.println("Dang Sua Hoa Don Voi Ma: " + MaHD);
            System.out.printf("Nhap Lai Ma Khach Hang(Hien Tai: %s): ",dsHD[vt].getmaKH());
            String maKH=sc.nextLine();
            dsHD[vt].setmaKH(maKH);

            boolean condition=false;
            while (!condition) {
                // Nhập ngày tạo hóa đơn mới với định dạng dd/MM/yyyy
                System.out.print("Nhap Lai Ngay Tao Hoa Don (dd/MM/yyyy): ");
                LocalDate dateError=LocalDate.of(0001, 01, 01);
                String ngayNhap = sc.nextLine();
                dsHD[vt].setngayTaoHD(ngayNhap);
                if(dateError.equals(dsHD[vt].getngayTaoHD())){
                    System.err.print("Ngay nhap khong hop le. Dinh dang phai la (dd-MM-yyyy).");
                }else{
                    condition=true;
                }
            }
            System.out.printf("Nhap Lai So Tien Nhan(Hien Tai: %.2f): ",dsHD[vt].gettienNhan());
            Double tienNhan=sc.nextDouble();
            sc.nextLine();
            dsHD[vt].settienNhan(tienNhan);

            System.out.print("\n╔══════════════════════════════════════════\n");
            System.out.printf("║    Da Sua Thanh Cong Ma Hoa Don: %s\n" ,MaHD);
            System.out.print("╚══════════════════════════════════════════");
        }else{
            System.out.print("\n╔══════════════════════════════════════════\n");
            System.out.printf("║      Khong Tim Thay Ma Hoa Don: %s\n" ,MaHD);
            System.out.print("╚══════════════════════════════════════════");
        }
    }

    public void thongKeTheoNgay(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Nhap Ngay (dd-MM-yyyy): ");
        String ngayTK = sc.nextLine();
        try {
            LocalDate day=LocalDate.parse(ngayTK,formatter);
            System.out.println("Danh Sach Hoa Don Nhap Hang Theo Ngay: "+ ngayTK + ":");
            boolean find=false;
            for(HoaDon HD: dsHD){
                if(HD!=null && HD.getngayTaoHD().equals(day)){
                    HD.xuat();
                    find=true;
                }
            }
            if (!find){
                System.out.print("\n╔══════════════════════════════════════════\n");
                System.out.printf("║ Khong Co Hoa Don Theo Ngay: %s\n" ,ngayTK);
                System.out.print("╚══════════════════════════════════════════");
            }
        } catch (Exception e) {
            System.err.println("Ngay Nhap Hoa Don Khong Hop Le. Vui Long Nhap Theo Dinh Dang(dd-MM-yyyy).");
        }
    }

    public void thongKeTheoThang(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        System.out.print("Nhap Thang (MM-yyyy): ");
        String thangTK = sc.nextLine();

        try {
            YearMonth month=YearMonth.parse(thangTK, formatter);
            System.out.println("Danh Sach Hoa Don Thong Ke Theo Thang " + month + ":");

            boolean find=false;
            for(HoaDon HD: dsHD){
                if(HD!=null ){
                    YearMonth monthPNH=YearMonth.from(HD.getngayTaoHD());
                    if(month.equals(monthPNH)){
                        HD.xuat();
                        find=true;
                    }
                }
            }
            if (!find) {
                System.out.print("\n╔══════════════════════════════════════════\n");
                System.out.printf("║ Khong Co Hoa Don Theo Thang: %s\n" ,thangTK);
                System.out.print("╚══════════════════════════════════════════");
            }
        } catch (Exception e) {
            System.err.println("Thang Tao Hoa Don Khong Hop Le. Vui Long Nhap Theo Dinh Dang(MM-yyyy).");
        }
    }

    public void thongKeTheoNam(){
        System.out.print("Nhap Nam Can Thong Ke: ");
        String namTk = sc.nextLine();

        try {
            int year=Integer.parseInt(namTk);
            System.out.println("Danh Sach Hoa Don Thong Ke Theo Thang " + namTk + ":");

            boolean find=false;
            for(HoaDon HD : dsHD){
                if(HD != null){
                    int yearPNH=HD.getngayTaoHD().getYear();
                    if(year==yearPNH){
                        HD.xuat();
                        find=true;
                    }
                }
            }
            if (!find) {
                System.out.print("\n╔══════════════════════════════════════════\n");
                System.out.printf("║ Khong Co Hoa Don Theo Nam: %s\n" ,namTk);
                System.out.print("╚══════════════════════════════════════════");
            }

        } catch (Exception e) {
            System.err.println("Nam Tao Hoa Don Khong Hop Le. Vui Long Nhap Theo Dinh Dang(yyyy).");
        }
    }

    public void thongKeTheoQuyvaNam(){
        System.out.print("Nhap Nam Can Thong Ke: ");
        int namTK = sc.nextInt();

        double tongTienQuy1 = 0;
        double tongTienQuy2 = 0;
        double tongTienQuy3 = 0;
        double tongTienQuy4 = 0;

        for(HoaDon HD: dsHD){
            if(HD!=null ){
                int year=HD.getngayTaoHD().getYear();
                int month=HD.getngayTaoHD().getMonthValue();
                double tongTien=HD.gettongTien();

                //Tính tổng tiền của năm được chỉ định
                if(namTK==year){
                    if(month >= 1 && month <= 3){
                        tongTienQuy1 += tongTien;
                    }else if(month >= 4 && month <= 6){
                        tongTienQuy2 += tongTien;
                    }else if(month >= 7 && month <= 9){
                        tongTienQuy3 += tongTien;
                    }else if(month >= 10 && month <= 12){
                        tongTienQuy4 += tongTien;
                    }
                }
            }

        }
        // Sử dụng DecimalFormat để thay đổi dấu phân cách
        DecimalFormat moneyfFormat = new DecimalFormat("#,###.###");
        // System.out.println("Thong Ke Tong Tien Theo Quy Trong Nam " + namTK + ":");
        // System.err.print("Quy 1: "+ moneyfFormat.format(tongTienQuy1));
        // System.err.print("Quy 2: "+ moneyfFormat.format(tongTienQuy2));
        // System.err.print("Quy 3: "+ moneyfFormat.format(tongTienQuy3));
        // System.err.print("Quy 4: "+ moneyfFormat.format(tongTienQuy4));
        System.out.print("\n╔══════════════════════════════════════════\n");
        System.out.printf("║              Thong Ke Nam %d        \n",namTK);
        System.out.print("╠═══════╦════════════════════════════════════\n");
        System.out.println("║ Quy 1 ║ "+ moneyfFormat.format(tongTienQuy1)+ " VND");
        System.out.println("║ Quy 2 ║ "+ moneyfFormat.format(tongTienQuy2)+ " VND");
        System.out.println("║ Quy 3 ║ "+ moneyfFormat.format(tongTienQuy3)+ " VND");
        System.out.println("║ Quy 4 ║ "+ moneyfFormat.format(tongTienQuy4)+ " VND") ;
        System.out.print("╚═══════╩════════════════════════════════════\n");

    }

    public void thongKe(){
        System.out.print("\n╔══════════════════════════════════════════╗\n");
        System.out.println("║       MENU : Thong Ke Hoa Don            ║ ");
        System.out.println("║   1. Thong Ke Theo Ngay                  ║ ");
        System.out.println("║   2. Thong Ke Theo Thang                 ║ ");
        System.out.println("║   3. Thong Ke Theo Nam                   ║ ");
        System.out.println("║   4. Thong Ke Theo Quy                   ║ ");
        System.out.println("║   0. Thoat                               ║ ");
        System.out.print("╚══════════════════════════════════════════╝\n");
        System.out.print("\nLua Chon Cua Ban: ");
           int choice =sc.nextInt();
           sc.nextLine();
           switch (choice) {
               case 0:
                   return;
               case 1:
                   thongKeTheoNgay();
                   break;
               case 2:
                   thongKeTheoThang();
                   break;
               case 3:
                   thongKeTheoNam();
                   break;
               case 4:
                   thongKeTheoQuyvaNam();
                   break;
               default:
                   System.err.print("Nhap Sai Vui Long Nhap Lai!!");
                   break;
           }
        }


    @Override
    public void docFile(){
        File readf = new File("HoaDon_Input.txt");
        try{
            if(!readf.exists()){
                System.out.print("Tao File Hoa Don Moi Thanh Cong");
                readf.createNewFile();
            }
            try(BufferedReader br=Files.newBufferedReader(readf.toPath(),StandardCharsets.UTF_8)){
                boolean empty=true;
                String line;
                while ((line=br.readLine())!=null){
                    empty=false;
                    String[] info=line.split("\\|");
                    if(info.length==6){
                        String maHD=info[0].trim();
                        String maKH=info[1].trim();
                        String maNV=info[2].trim();
                        String ngayTao=info[3].trim();
                        Double TongTien=Double.parseDouble(info[4].trim());
                        Double tienNhan=Double.parseDouble(info[5].trim());

                        if(!KiemTraMaHDTonTai(maHD)){
                            if(size==dsHD.length){
                                dsHD=Arrays.copyOf(dsHD, size+1);
                            }
                             dsHD[size]=new HoaDon(maHD,maKH,maNV,ngayTao,TongTien,tienNhan);
                            size++;
                            System.out.print("\n╔══════════════════════════════════════════\n");
                            System.out.printf("║ Ma Hoa Don %s Da Them \n", maHD);
                            System.out.print("╚══════════════════════════════════════════");
                        }else {
                            System.out.print("\n╔══════════════════════════════════════════\n");
                            System.out.printf("║ Ma PNH %s Da Co \n", maHD);
                            System.out.print("╚══════════════════════════════════════════");
                        }
                       
                    }else{
                        System.out.println("Du Lieu Khong Hop Le: " + line);
                    }
                }
                if (empty) {
                    System.out.println("\nFILE EMPTY WITH NOTHING");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile(){
        try {
            PrintWriter pw=new PrintWriter("HoaDon_Output.txt");
            for(HoaDon HD: dsHD){
                if(HD !=null){
                    String line= "Ma Hoa Don: "+HD.getmaHD()+ " | Ma Khach Hang: " + HD.getmaKH() + " | Ma Nhan Vien: " + HD.getmaNV() + " | Ngay Tao HD: " +HD.getngayTaoHD()+ " | Tong Tien: "
                            +HD.gettongTien()+" | Tien Nhan: " + HD.gettienNhan() + " | Tien Thoi: " + HD.gettienThoi();
                    pw.println(line);
                    pw.flush();
                }

            }
            System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG: ");

            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}