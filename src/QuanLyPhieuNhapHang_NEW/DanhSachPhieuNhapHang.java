package QuanLyPhieuNhapHang_NEW;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class DanhSachPhieuNhapHang {
    Scanner sc=new Scanner(System.in);
    private PhieuNhapHang[] dsPNH;
    private int size;

    public DanhSachPhieuNhapHang() {
        // Khởi tạo mảng phiếu nhập hàng với kích thước mặc định
        dsPNH = new PhieuNhapHang[100]; // Hoặc kích thước cần thiết
        size = 0; // Số lượng phiếu bắt đầu là 0
    }

    // Kiểm tra mã phiếu trùng lặp
    private boolean KiemTraMaPNHTonTai(String maPNH_New){
        for(PhieuNhapHang PNH: dsPNH){
                if(PNH!=null && PNH.getMaPNH().equals(maPNH_New) ){
                return true;  // Mã phiếu đã tồn tại
                }
        } 
        return false; // Mã phiếu chưa tồn tại  
    }

    public PhieuNhapHang[] getDsPNH() {
        return dsPNH;
    }

    public void xuatPhieuNhapHang(){
        if (size == 0) {
            System.out.println("Danh Sach Rong.");
            return;
        }

        // In danh sách các phiếu nhập (phần thông tin cơ bản của từng phiếu)
        System.out.println("Danh Sach Phieu Nhap");
        for(PhieuNhapHang PNH: dsPNH){
            if (PNH!=null) {
                PNH.xuatPNH();
            }
            
        }
    }

    public void nhapPNHvaChiTietPNH(DanhSachChiTietPhieuNhapHang dsChiTietPNH){
        while(true){
            // Tạo phiếu mới
            PhieuNhapHang PNH_new= new PhieuNhapHang();
            PNH_new.nhapPNH();

             // Kiểm tra mã phiếu trùng lặp
             if(KiemTraMaPNHTonTai(PNH_new.getMaPNH())){
                System.out.println("\nMa PNH Da Ton Tai. Vui Long Nhap Lai!");
             }else{
                // Mã phiếu hợp lệ, thêm vào danh sách phiếu
                dsPNH=Arrays.copyOf(dsPNH, size+1);
                dsPNH[size] = PNH_new;
                size++;
             
                // Nhập danh sách chi tiết cho phiếu này
                System.out.print("Nhap So Luong Chi Tiet Cho Phieu: ");
                int soChiTiet = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < soChiTiet; i++) {
                    System.out.println("Nhap Chi Tiet Thu " + (i + 1) + ":");
                    dsChiTietPNH.themChiTietVaoPNH(PNH_new.getMaPNH());
                }
                break;
             }
        }
    }

    public void xuatPNHvaChiTietPNH(DanhSachChiTietPhieuNhapHang dsChiTietPNH){
        if (size == 0) {
            System.out.println("Danh Sach Rong.");
            return;
        }

        System.out.println("Danh Sach Phieu Nhap Hang Va Chi Tiet Phieu Nhap Hang");
        for(PhieuNhapHang PNH: dsPNH){
            if(PNH !=null){
                System.out.println("\nPhieu Nhap Hang " + PNH.getMaPNH() + " :");
                PNH.xuatPNH();
                System.out.println("\nChi Tiet Phieu Nhap Hang " + PNH.getMaPNH() + " :");
                dsChiTietPNH.inChiTietTheoMaPNH(PNH.getMaPNH());
            }
            
        }
    }

    public int timViTriMaPNH(String maPNH){
        for (int i = 0; i < size; i++) {
            if (dsPNH[i] !=null) {
                 if (dsPNH[i].getMaPNH().equals(maPNH )) // So sánh trực tiếp kiểu int
                return i;
            }
        }
        return -1;
    }

    public void xoaPhieuTheoMaPNH(){
        // Tìm vị trí phiếu nhập hàng cần xóa
        System.out.print("Nhap Ma Phieu Can Xoa: ");
        String MaPNH = sc.nextLine();
        int vt=timViTriMaPNH(MaPNH);

        if(vt!= -1){
            // Dịch chuyển các phần tử sau vị trí xóa lên trước
            for (int i = vt; i < size - 1; i++) {
                dsPNH[i] = dsPNH[i + 1];
            }
            dsPNH=Arrays.copyOf(dsPNH, size-1);
            size--;
            System.out.println("Da Xoa Phieu Voi Ma PNH: " + MaPNH);
        }else{
            System.out.println("Khong Tim Thay Ma PNH: " + MaPNH);
        }
    }

    public void timPhieuTheoMaPNH(){
        System.out.print("Nhap Ma Phieu Can Tim: ");
        String MaPNH = sc.nextLine();
        int vt=timViTriMaPNH(MaPNH);

        if(vt!=-1){
            dsPNH[vt].xuatPNH();
        }else{
            System.out.println("Khong Tim Thay PNH voi Ma: " + MaPNH);
        }
    }

    public void suaPhieuNhapHang(){
        System.out.print("Nhap Ma Phieu Can Sua: ");
        String MaPNH = sc.nextLine();
        int vt=timViTriMaPNH(MaPNH);

        if(vt!=-1){
            System.out.println("Dang Sua Phieu Nhap Hang Voi Ma: " + MaPNH);
            System.out.printf("Nhap Lai Ma Nha San Xuat(Hien Tai: %s): ",dsPNH[vt].getMaNXB());
            String MaNXB=sc.nextLine();
            dsPNH[vt].setMaNXB(MaNXB);

            boolean condition=false;
            while (!condition) {
                // Nhập ngày nhập hàng mới với định dạng dd/MM/yyyy
                System.out.print("Nhap Lai Ngay Nhap Hang (dd/MM/yyyy): ");
                LocalDate dateError=LocalDate.of(0001, 01, 01);
                String ngayNhap = sc.nextLine();
                dsPNH[vt].setNgayNhap(ngayNhap);
                if(dateError.equals(dsPNH[vt].getNgayNhap())){
                    System.err.print("Ngay nhap khong hop le. Dinh dang phai la (dd-MM-yyyy).");
                }else{
                    condition=true;
                }
            }
            System.out.println("Da Sua Thanh Cong Ma PNH: " + MaPNH);
        }else{
            System.out.println("Khong Tim Thay Ma PNH: " + MaPNH);
        }
    }

    public void thongKeTheoNgay(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Nhap Ngay (dd-MM-yyyy): ");
        String ngayTK = sc.nextLine();
        try {
            LocalDate day=LocalDate.parse(ngayTK,formatter);
            System.out.println("Danh Sach Phieu Nhap Hang Theo Ngay: "+ ngayTK + ":");
            boolean find=false;
            for(PhieuNhapHang PNH: dsPNH){
                if(PNH!=null && PNH.getNgayNhap().equals(day)){
                    PNH.xuatPNH();
                    find=true;
                }
            }
            if (!find) 
                System.out.println("Khong Co Phieu Nhap Hang Theo Ngay: " + ngayTK);
        } catch (Exception e) {
            System.err.println("Ngay Nhap Hang Khong Hop Le. Vui Long Nhap Theo Dinh Dang(dd-MM-yyyy).");
        }
    }

    public void thongKeTheoThang(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        System.out.print("Nhap Thang (MM-yyyy): ");
        String thangTK = sc.nextLine();

        try {
            YearMonth month=YearMonth.parse(thangTK, formatter);
            System.out.println("Danh Sach Phieu Thong Ke Theo Thang " + month + ":");

            boolean find=false;
            for(PhieuNhapHang PNH: dsPNH){
                if(PNH!=null ){
                    YearMonth monthPNH=YearMonth.from(PNH.getNgayNhap());
                    if(month.equals(monthPNH)){
                        PNH.xuatPNH();
                        find=true;
                    }
                }
                
            }
            if (!find) {
                System.out.println("Khong Co Phieu Nhap Hang Theo Thang: " + thangTK);
            }
        } catch (Exception e) {
            System.err.println("Thang Nhan Hang Khong Hop Le. Vui Long Nhap Theo Dinh Dang(MM-yyyy).");
        } 
    }

    public void thongKeTheoNam(){
        System.out.print("Nhap Nam Can Thong Ke: ");
        String namTk = sc.nextLine();

        try {
            int year=Integer.parseInt(namTk);
            System.out.println("Danh Sach Phieu Thong Ke Theo Thang " + namTk + ":");
            
            boolean find=false;
            for(PhieuNhapHang PNH : dsPNH){
                if(PNH != null){
                    int yearPNH=PNH.getNgayNhap().getYear();
                    if(year==yearPNH){
                        PNH.xuatPNH();
                        find=true;
                    }
                } 
            }
            if (!find) {
                System.out.println("Khong Co Phieu Nhap Hang Theo Nam: " + namTk);
            }

        } catch (Exception e) {
            System.err.println("Nam Nhan Hang Khong Hop Le. Vui Long Nhap Theo Dinh Dang(yyyy).");
        }
    }

    public void thongKeTheoQuyvaNam(){
        System.out.print("Nhap Nam Can Thong Ke: ");
        int namTK = sc.nextInt();

        double tongTienQuy1 = 0;
        double tongTienQuy2 = 0;
        double tongTienQuy3 = 0;
        double tongTienQuy4 = 0;

        for(PhieuNhapHang PNH: dsPNH){
            if(PNH!=null ){
                int year=PNH.getNgayNhap().getYear();
                int month=PNH.getNgayNhap().getMonthValue();
                double tongTien=PNH.getTongTien();

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
        System.out.println("Thong Ke Tong Tien Theo Quy Trong Nam " + namTK + ":");
        System.err.print("Quy 1: "+ moneyfFormat.format(tongTienQuy1));
        System.err.print("Quy 2: "+ moneyfFormat.format(tongTienQuy2));
        System.err.print("Quy 3: "+ moneyfFormat.format(tongTienQuy3));
        System.err.print("Quy 4: "+ moneyfFormat.format(tongTienQuy4));
    }

    public void thongKe(){
        System.err.print("\n1. Thong Ke Theo Ngay");
        System.err.print("\n2. Thong Ke Theo Thang");
        System.err.print("\n3. Thong Ke Theo Nam");
        System.err.print("\n4. Thong Ke Theo Quy");
        System.out.print("\nNhap Lua Chon Thong Ke:");
        int choice =sc.nextInt();
        sc.nextLine();
        switch (choice) {
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

    public void docFile(){
        File readf = new File("PhieuNhapHang_Input.txt");
        try{
            if(!readf.exists()){
                System.out.print("Tao File Khach Hang Moi Thanh Cong");
                readf.createNewFile();
            }
            try(BufferedReader br=Files.newBufferedReader(readf.toPath(),StandardCharsets.UTF_8)){
                boolean empty=true;
                String line;
                while ((line=br.readLine())!=null){
                    empty=false;
                    String[] info=line.split("\\|");
                    if(info.length==5){
                        String maPNH=info[0].trim();
                        String ngayNhap=info[1].trim();
                        String maNXB=info[2].trim();
                        String maNV=info[3].trim();
                        Double TongTien=Double.parseDouble(info[4].trim());
        
                        if(size==dsPNH.length){
                            dsPNH=Arrays.copyOf(dsPNH, size+1);
                        }
                        dsPNH[size]=new PhieuNhapHang(maPNH,ngayNhap,maNXB,maNV,TongTien);
                        size++;
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

    public void ghiFile(){
        try {
            PrintWriter pw=new PrintWriter("PhieuNhapHang_Output.txt");
            for(PhieuNhapHang PNH: dsPNH){
                String line= "Ma PNH: "+PNH.getMaPNH()+ " | Ngay Nhap: " + PNH.getNgayNhap() + " | Ma NXB: " + PNH.getMaPNH() + " | Ma Nhan Vien: " +PNH.getMaNV()+ " | Tong Tien: " 
                            +PNH.getTongTien();
                pw.println(line);
                pw.flush();
            }
            System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG: ");
            
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}