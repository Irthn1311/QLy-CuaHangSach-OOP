package QuanLyHoaDon;

import Interface.CRUD2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachChiTietHoaDon implements CRUD2 {
    Scanner sc = new Scanner(System.in);
    private ChiTietHoaDon[] dsChiTiet = new ChiTietHoaDon[0];
    private int size = 0;
    private DanhSachHoaDon danhSachHoaDon;

    public DanhSachChiTietHoaDon(DanhSachHoaDon danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }

    // Hàm tìm hóa đơn theo mã
    public HoaDon timHDTheoMa(String maHD) {
        for (HoaDon HD : danhSachHoaDon.getdsHD()) {
            if (HD!= null && HD.getmaHD().equals(maHD)) {
                return HD;
            }
        }
        return null; // Nếu không tìm thấy
    }

    private boolean KiemTraSachTrung(String MaHD,String maSach){
        for(ChiTietHoaDon chiTiet: dsChiTiet){
            if(chiTiet !=null && chiTiet.getMaCTHD().equals(MaHD) && chiTiet.getMaSach().equals(maSach)){
                return true;  // Trùng
            }
        }
        return false;  // Không Trùng
    }

    // Hàm cập nhật tổng tiền cho hóa đơn
    public void updateTongTien(String MaHD){
        HoaDon phieu=timHDTheoMa(MaHD);
        if (phieu == null) {
            System.out.print("\n╔══════════════════════════════════════════\n");
            System.out.printf("║    Khong Tim Thay Hoa Don Voi Ma: %s\n" ,MaHD);
            System.out.print("╚══════════════════════════════════════════");
            return;
        }

        double tongTienMoi = 0; // Biến để lưu tổng tiền mới
        for(ChiTietHoaDon chiTiet: dsChiTiet){
            if (chiTiet !=null && chiTiet.getMaCTHD().equals(MaHD) ) {
                tongTienMoi += chiTiet.getThanhTien(); // Cộng dồn thành tiền của các chi tiết thuộc hóa đơn
            }
        }

        // Cập nhật tổng tiền cho hóa đơn
        phieu.settongTien(tongTienMoi);
        System.out.print("\n╔═════════════════════════════════════════════════════════════════════════\n");
        System.out.printf("║     Tong Tien Cua Ma Hoa Don: %s Da Duoc Cap Nhat: %.2f\n" ,MaHD,tongTienMoi);
        System.out.print("╚═════════════════════════════════════════════════════════════════════════");
    }

    // Hàm thêm chi tiết cho DanhSachHoaDon
    public void themChiTietVaoHD(String MaPNH) {
        ChiTietHoaDon chiTiet = new ChiTietHoaDon();
        chiTiet.nhap(false);
        chiTiet.setMaCTHD(MaPNH);
        // Kiểm tra mã sản phẩm trùng
        if (KiemTraSachTrung(MaPNH, chiTiet.getMaSach())) {
            System.out.print("\n╔══════════════════════════════════════════════════\n");
            System.out.printf("║  Ma Sach Da Ton Tai Trong Hoa Don. Hay Nhap Lai\n");
            System.out.print("╚══════════════════════════════════════════════════");
            return;
        }

        dsChiTiet = Arrays.copyOf(dsChiTiet, size + 1);
        dsChiTiet[size] = chiTiet;
        size++;

        updateTongTien(MaPNH);
        System.out.print("\n╔══════════════════════════════════════════════════\n");
        System.out.printf("║  Da Them Chi Tiet Vao Hoa Don Co Ma: %s\n",MaPNH);
        System.out.print("╚══════════════════════════════════════════════════");
    }

    // Hàm in chi tiết cho DanhSachHoaDon
    public void inChiTietTheoMaHD(String MaPNH) {
        boolean kiemTraChiTiet = false;
        for (ChiTietHoaDon chiTiet : dsChiTiet) {
            if (chiTiet.getMaCTHD().equals(MaPNH) && chiTiet !=null) {
                chiTiet.xuat();
                kiemTraChiTiet = true;
            }
        }

        if (!kiemTraChiTiet) {
            System.out.print("\n╔══════════════════════════════════════════════════\n");
            System.out.printf("║  Khong Co Chi Tiet Nao Trong Hoa Don Nay\n");
            System.out.print("╚══════════════════════════════════════════════════");
        }
    }

    public void themChiTietVaoHD(){
        System.out.print("Nhap Ma Hoa Don Can Them Chi Tiet: ");
        String MaPNH=sc.nextLine();

        HoaDon PNH=timHDTheoMa(MaPNH);
        if(PNH!=null){
            ChiTietHoaDon chiTiet = new ChiTietHoaDon();
            chiTiet.nhap(false);
            chiTiet.setMaCTHD(MaPNH);
            // Kiểm tra xem mã sản phẩm đã tồn tại trong chi tiết của hóa đơn này chưa
            if (KiemTraSachTrung(MaPNH, chiTiet.getMaSach())) {
                System.out.print("\n╔══════════════════════════════════════════════════\n");
                System.out.printf("║  Ma Sach Da Ton Tai Trong Hoa Don. Vui Long Nhap Lai\n");
                System.out.print("╚══════════════════════════════════════════════════");
                return; // Dừng thêm chi tiết
            }

            dsChiTiet = Arrays.copyOf(dsChiTiet, size + 1);
            dsChiTiet[size] = chiTiet;
            size++;
            updateTongTien(MaPNH);


            System.out.print("\n╔══════════════════════════════════════════════════\n");
            System.out.printf("║  Da Them Chi Tiet Vao Hoa Don Co Ma: %s\n",MaPNH);
            System.out.print("╚══════════════════════════════════════════════════");
        }else{
            System.out.print("\n╔══════════════════════════════════════════════════\n");
            System.out.printf("║  Khong Tim Thay Hoa Don Voi Ma: %s\n",MaPNH);
            System.out.print("╚══════════════════════════════════════════════════");
        }
    }

    public void inDanhSachChiTietHD() {
        if(size==0){
            System.out.println("Chua Co Chi Tiet Nao.");
            return;
        }
        System.out.println("Danh Sach Chi Tiet Cac Hoa Don");
        // In các chi tiết hóa đơn
        for(ChiTietHoaDon CTHD: dsChiTiet){
            if(CTHD!=null){
                CTHD.xuat();
            }
        }
    }

    public void suaChiTietHD(){
        System.out.print("Nhap Ma Hoa Don Can Sua Chi Tiet: ");
        String MaHD = sc.nextLine();

        // Kiểm tra hóa đơn có tồn tại không
        boolean findHD = false;
        for (ChiTietHoaDon chiTiet : dsChiTiet) {
            if (chiTiet !=null && chiTiet.getMaCTHD().equals(MaHD)) {
                findHD = true;
                break;
            }
        }

        if (!findHD) {
            System.out.print("\n╔══════════════════════════════════════════\n");
            System.out.printf("║    Khong Tim Thay Hoa Don Voi Ma: %s\n" ,MaHD);
            System.out.print("╚══════════════════════════════════════════");
            return;
        }

        System.out.print("Nhap Ma Sach Can Sua: ");
        String maSach = sc.nextLine();

        boolean findSach = false;
        for (ChiTietHoaDon chiTiet : dsChiTiet) {
            // Tìm chi tiết có mã hóa đơn và mã sách trùng khớp
            if(chiTiet !=null && chiTiet.getMaSach().equals(maSach) && chiTiet.getMaCTHD().equals(MaHD)){
                System.err.println("Thong Tin Chi Tiet Hien Tai");
                chiTiet.xuat();

                System.out.println("\nNhap Thong Tin Moi Cho Chi Tiet:");
                chiTiet.nhap(false); // Nhập thông tin mới
                chiTiet.setMaCTHD(MaHD);

                updateTongTien(MaHD); // Cập nhật lại tổng tiền phiếu
                System.out.print("\n╔══════════════════════════════════════════\n");
                System.out.printf("║    Da Sua Chi Tiet Hoa Don Nay\n");
                System.out.print("╚══════════════════════════════════════════");
                findSach = true;
                break;
            }
        }
        if (!findSach) {
            System.out.println("Khong Tim Thay Sach Co Ma: " + maSach + " Trong Hoa Don: " + MaHD);
        }
    }

    public void xoaChiTietHD(){
        System.out.print("Nhap Ma Hoa Don Can Xoa San Pham: ");
        String MaHD = sc.nextLine();

        // Kiểm tra mã hóa đơn có tồn tại không
        boolean findHD = false;
        for (ChiTietHoaDon chiTiet : dsChiTiet) {
            if (chiTiet !=null && chiTiet.getMaCTHD().equals(MaHD)) {
                findHD = true;
                break;
            }
        }
        if (!findHD) {
            System.out.print("\n╔══════════════════════════════════════════\n");
            System.out.printf("║    Khong Tim Thay Hoa Don Voi Ma: %s\n" ,MaHD);
            System.out.print("╚══════════════════════════════════════════");
            return;
        }

        System.out.print("Nhap Ma Sach Can Xoa: ");
        String maSach = sc.nextLine();

        boolean findSach = false;
        for (int i = 0; i < size; i++) {
            // Tìm chi tiết có mã hóa đơn và mã sản phẩm trùng khớp
            if(dsChiTiet[i] !=null && dsChiTiet[i].getMaCTHD().equals(MaHD) && dsChiTiet[i].getMaSach().equals(maSach)){
                // Dịch các phần tử sau để ghi đè phần tử cần xóa
                for (int j = i; j < size - 1; j++) {
                    dsChiTiet[j] = dsChiTiet[j + 1];
                }

                dsChiTiet = Arrays.copyOf(dsChiTiet, size - 1); // Giảm kích thước mảng
                size--;
                updateTongTien(MaHD); // Cập nhật lại tổng tiền phiếu
                System.out.print("\n╔══════════════════════════════════════════\n");
                System.out.printf("║    Da Cap Nhap Thong Tin Hoa Don\n" );
                System.out.print("╚══════════════════════════════════════════");
                findSach = true;
                break;
            }

        }
        if (!findSach) {
            System.out.println("Khong Tim Thay Sach Co Ma: " + maSach + " Trong Hoa Don: " + MaHD);
            System.out.print("\n╔═════════════════════════════════════════════════════════════════\n");
            System.out.printf("║  Khong Tim Thay Sach Co Ma: %s  Trong Hoa Don: %s\n" ,maSach,MaHD);
            System.out.print("╚═════════════════════════════════════════════════════════════════");
        }

    }

    @Override
    public void docFile(){
        File readf = new File("ChiTietHoaDon_Input.txt");
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
                    if(info.length==4){
                        String maCTPNH=info[0].trim();
                        String maSach=info[1].trim();
                        int soluong=Integer.parseInt(info[2].trim());
                        Double dongia=Double.parseDouble(info[3].trim());

                        if(size==dsChiTiet.length){
                            dsChiTiet=Arrays.copyOf(dsChiTiet, size+1);
                        }
                        dsChiTiet[size]=new ChiTietHoaDon(maCTPNH,maSach,soluong,dongia);
                        updateTongTien(maCTPNH);
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

    @Override
    public void ghiFile(){
        try {
            PrintWriter pw=new PrintWriter("ChiTietHoaDon_Output.txt");
            for(ChiTietHoaDon CTHD: dsChiTiet){
                if(CTHD != null){
                    String line= "Ma CTPNH: "+CTHD.getMaCTHD()+ " | Ma Sach: " + CTHD.getDonGia() + " | So Luong: " + CTHD.getSoLuong() + " | Ma Nhan Vien: " +CTHD.getDonGia()+ " | Tong Tien: "
                            +CTHD.getThanhTien();
                    pw.println(line);
                    pw.flush();
                }

            }
            System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG ");

            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
