import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachChiTietPhieuNhapHang implements CRUD2{
    Scanner sc = new Scanner(System.in);
    private ChiTietPhieuNhapHang[] dsChiTiet = new ChiTietPhieuNhapHang[0];
    private int size = 0;
    private DanhSachPhieuNhapHang danhSachPhieuNhapHang;

    public DanhSachChiTietPhieuNhapHang(DanhSachPhieuNhapHang danhSachPhieuNhapHang) {
        this.danhSachPhieuNhapHang = danhSachPhieuNhapHang;
    }

    // Hàm tìm phiếu nhập hàng theo mã
    public PhieuNhapHang timPNHTheoMa(String maPNH) {
        for (PhieuNhapHang PNH : danhSachPhieuNhapHang.getDsPNH()) {
            if (PNH!= null && PNH.getMaPNH().equals(maPNH)) {
                return PNH;
            }
        }
        return null; // Nếu không tìm thấy
    }

    private boolean KiemTraSachTrung(String MaPNH,String maSach){
        for(ChiTietPhieuNhapHang chiTiet: dsChiTiet){
            if(chiTiet !=null && chiTiet.getMa_CTPNH().equals(MaPNH) && chiTiet.getMaSach().equals(maSach)){
                return true;  // Trùng
            }
        }
        return false;  // Không Trùng

    }

    // Hàm cập nhật tổng tiền cho phiếu nhập hàng
    public void updateTongTien(String MaPNH){
        PhieuNhapHang phieu=timPNHTheoMa(MaPNH);
        if (phieu == null) {
            System.out.println("Khong Tim Thay Phieu Nhap Hang Voi Ma: " + MaPNH);
            return;
        }

        double tongTienMoi = 0; // Biến để lưu tổng tiền mới
        for(ChiTietPhieuNhapHang chiTiet: dsChiTiet){
            if (chiTiet !=null && chiTiet.getMa_CTPNH().equals(MaPNH) ) {
                tongTienMoi += chiTiet.getThanhTien(); // Cộng dồn thành tiền của các chi tiết thuộc phiếu
            }
        }

        // Cập nhật tổng tiền cho phiếu
        phieu.setTongTien(tongTienMoi);
        System.out.println("Tong Tien Cua Ma PNH " + MaPNH + " Da Duoc Cap Nhat: " + tongTienMoi);
    }

    // Hàm thêm chi tiết cho DanhSachPhieuNhapHang
    public void themChiTietVaoPNH(String MaPNH) {
        ChiTietPhieuNhapHang chiTiet = new ChiTietPhieuNhapHang();
        chiTiet.nhap(false);
        chiTiet.setMa_CTPNH(MaPNH);
        // Kiểm tra mã sản phẩm trùng
        if (KiemTraSachTrung(MaPNH, chiTiet.getMaSach())) {
            System.out.println("Ma Sach Da Ton Tai Trong PNH. Vui Long Nhap Lai.");
            return;
        }

        dsChiTiet = Arrays.copyOf(dsChiTiet, size + 1);
        dsChiTiet[size] = chiTiet;
        size++;
        
        updateTongTien(MaPNH);
        
        System.out.println("Da Them Chi Tiet Vao PNH Co Ma:"+MaPNH);
    }

    // Hàm in chi tiết cho DanhSachPhieuNhapHang
    public void inChiTietTheoMaPNH(String MaPNH) {
        boolean kiemTraChiTiet = false;
        for (ChiTietPhieuNhapHang chiTiet : dsChiTiet) {
            if (chiTiet.getMa_CTPNH().equals(MaPNH) && chiTiet !=null) {
                chiTiet.xuat();
                kiemTraChiTiet = true;
            }
        }

        if (!kiemTraChiTiet) {
            System.out.println("Khong Co Chi Tiet Nao Trong Phieu Nay.");
        }
    }

    public void themChiTietVaoPNH(){
        System.out.print("Nhap Ma PNH Can Them Chi Tiet: ");
        String MaPNH=sc.nextLine();

        PhieuNhapHang PNH=timPNHTheoMa(MaPNH);
        if(PNH!=null){
            ChiTietPhieuNhapHang chiTiet = new ChiTietPhieuNhapHang();
            chiTiet.nhap(false);
            chiTiet.setMa_CTPNH(MaPNH);
            // Kiểm tra xem mã sản phẩm đã tồn tại trong chi tiết của phiếu này chưa
            if (KiemTraSachTrung(MaPNH, chiTiet.getMaSach())) {
                System.out.println("Ma Sach Da Ton Tai Trong PNH. Vui Long Nhap Lai\n");
                return; // Dừng thêm chi tiết
            }
            
            dsChiTiet = Arrays.copyOf(dsChiTiet, size + 1);
            dsChiTiet[size] = chiTiet;
            size++;
            updateTongTien(MaPNH);
        
            System.out.println("Da Them Chi Tiet Vao PNH Co Ma:"+MaPNH);
        }else{
            System.out.println("Khong Tim Thay Phieu Nhap Hang Voi Ma: " + MaPNH);
        }
    }

    public void inDanhSachChiTietPNH() {
        if(size==0){
            System.out.println("Chua Co Chi Tiet Nao.");
            return;
        }
        System.err.print("Danh Sach Chi Tiet Cac Phieu Nhap Hang");
        // In các chi tiết phiếu nhập hàng
        for(ChiTietPhieuNhapHang CTPNH: dsChiTiet){
            if(CTPNH!=null){
                CTPNH.xuat();
            }
        }
    }

    public void suaChiTietPNH(){
        System.out.print("Nhap Ma PNH Can Sua Chi Tiet: ");
        String MaPNH = sc.nextLine();

        // Kiểm tra mã phiếu có tồn tại không
        boolean findPNH = false;
        for (ChiTietPhieuNhapHang chiTiet : dsChiTiet) {
            if (chiTiet !=null && chiTiet.getMa_CTPNH().equals(MaPNH)) {
                findPNH = true;
                break;
            }
        }

        if (!findPNH) {
            System.out.println("Khong Tim Thay Phieu Voi Ma: " + MaPNH);
            return;
        }

        System.out.print("Nhap Ma Sach Can Sua: ");
        String maSach = sc.nextLine();

        boolean findSach = false;
        for (ChiTietPhieuNhapHang chiTiet : dsChiTiet) {
            // Tìm chi tiết có mã phiếu và mã sản phẩm trùng khớp
            if(chiTiet !=null && chiTiet.getMaSach().equals(maSach) && chiTiet.getMa_CTPNH().equals(MaPNH)){
                System.err.println("Thong Tin Chi Tiet Hien Tai");
                chiTiet.xuat();

                System.out.println("\nNhap Thong Tin Moi Cho Chi Tiet:");
                chiTiet.nhap(false); // Nhập thông tin mới
                chiTiet.setMa_CTPNH(MaPNH);

                updateTongTien(MaPNH); // Cập nhật lại tổng tiền phiếu
                System.out.println("Da Sua Chi Tiet Phieu Nhap Hang Nay.");
                findSach = true;
                break;
            }
        }
        if (!findSach) {
            System.out.println("Khong Tim Thay Sach Co Ma: " + maSach + " Trong PNH: " + MaPNH);
        }
    }

    public void xoaChiTietPNH(){
        System.out.print("Nhap Ma Phieu Nhap Hang Can Xoa San Pham: ");
        String MaPNH = sc.nextLine();

         // Kiểm tra mã phiếu có tồn tại không
         boolean findPNH = false;
         for (ChiTietPhieuNhapHang chiTiet : dsChiTiet) {
             if (chiTiet !=null && chiTiet.getMa_CTPNH().equals(MaPNH)) {
                 findPNH = true;
                 break;
             }
        }
        if (!findPNH) {
            System.out.println("Khong Tim Thay Phieu Voi Ma: " + MaPNH);
            return;
        }

        System.out.print("Nhap Ma Sach Can Xoa: ");
        String maSach = sc.nextLine();

        boolean findSach = false;
        for (int i = 0; i < size; i++) {
            // Tìm chi tiết có mã phiếu và mã sản phẩm trùng khớp
            if(dsChiTiet[i] !=null && dsChiTiet[i].getMa_CTPNH().equals(MaPNH) && dsChiTiet[i].getMaSach().equals(maSach)){
                // Dịch các phần tử sau để ghi đè phần tử cần xóa
                for (int j = i; j < size - 1; j++) {
                    dsChiTiet[j] = dsChiTiet[j + 1];
                }

                dsChiTiet = Arrays.copyOf(dsChiTiet, size - 1); // Giảm kích thước mảng
                size--;
                updateTongTien(MaPNH); // Cập nhật lại tổng tiền phiếu
                System.out.println("Da Cap Nhap Thong Tin PNH.");
                findSach = true;
                break;
            }

        }
        if (!findSach) {
            System.out.println("Khong Tim Thay Sach Co Ma: " + maSach + " Trong PNH: " + MaPNH);
        }

    }

     @Override
    public void docFile(){
        File readf = new File("ChiTietPhieuNhapHang_Input.txt");
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
                        dsChiTiet[size]=new ChiTietPhieuNhapHang(maCTPNH,maSach,soluong,dongia);
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
            PrintWriter pw=new PrintWriter("ChiTietPhieuNhapHang_Output.txt");
            for(ChiTietPhieuNhapHang PNH: dsChiTiet){
                String line= "Ma CTPNH: "+PNH.getMa_CTPNH()+ " | Ma Sach: " + PNH.getDonGia() + " | So Luong: " + PNH.getSoLuong() + " | Ma Nhan Vien: " +PNH.getDonGia()+ " | Tong Tien: " 
                            +PNH.getThanhTien();
                pw.println(line);
                pw.flush();
            }
            System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG ");
            
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
