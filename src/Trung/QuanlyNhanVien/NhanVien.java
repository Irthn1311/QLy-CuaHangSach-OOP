import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class NhanVien {
    private String maNV;
    private String hoNV;
    private String tenNV;
    private String chucVu;
    private LocalDate ngaySinh; 
    private String gioiTinh;
    private String sdtNV;
    private String diaChiNV;
    private Double luongNV;
    DateTimeFormatter  formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public NhanVien(){
        this.maNV = "";
        this.hoNV = "";
        this.tenNV = "";
        this.chucVu = "";
        this.ngaySinh = null;
        this.gioiTinh = "";
        this.sdtNV = "";
        this.diaChiNV = "";
        this.luongNV = 0.0;
    }

    public NhanVien(String MaNV, String HoNV, String TenNV, String ChucVu, String NgaySinhNV, String GioiTinh, String SDTNV, String DiaChiNV, Double LuongNV){
        this.maNV = MaNV;
        this.hoNV = HoNV;
        this.tenNV = TenNV;
        this.chucVu = ChucVu;
        this.ngaySinh = LocalDate.parse(NgaySinhNV,formatter);
        this.gioiTinh = GioiTinh;
        this.sdtNV = SDTNV;
        this.diaChiNV = DiaChiNV;
        this.luongNV = LuongNV;
    }

    public void nhapNV(){
        Scanner sc = new Scanner(System.in);
        System.err.printf("\nNhap Ma Nhan Vien: ");
        this.maNV = sc.nextLine();

        System.err.printf("\nNhap Ho Nhan Vien: ");
        this.hoNV = sc.nextLine();

        System.err.printf("\nNhap Ten Nhan Vien: ");
        this.tenNV = sc.nextLine();

        System.err.printf("\nNhap Chuc Vu Nhan Vien: ");
        this.chucVu = sc.nextLine();

        boolean CheckDate = false;
        while (!CheckDate) {
            System.err.printf("\nNhap Ngay Sinh Nhan Vien (dd-mm-yyyy): ");
            String ngaySinhInput = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                this.ngaySinh = LocalDate.parse(ngaySinhInput, formatter);
                CheckDate = true;
            } catch (DateTimeParseException e) {
                System.err.println("Ngay sinh khong hop le. Vui long nhap lai(dd-mm-yyyy).");
            }
        }

        System.err.printf("\nNhap Gioi Tinh Nhan Vien: ");
        this.gioiTinh = sc.nextLine();

        System.err.printf("\nNhap So Dien Thoai Nhan Vien:  ");
        this.sdtNV = sc.nextLine();

        System.err.printf("\nNhap Dia Chi Nhan Vien: ");
        this.diaChiNV = sc.nextLine();

        System.err.printf("\nNhap Luong Nhan Vien: ");
        this.luongNV = sc.nextDouble();
        sc.nextLine();
    }

    public String getMaNV() { return maNV; }
    public String getHoNV() { return hoNV; }
    public String getTenNV() { return tenNV; }
    public String getChucVu() { return chucVu; }
    public LocalDate getNgaySinh() { return ngaySinh; }
    public String getGioiTinh() { return gioiTinh; }
    public String getSDTNV() { return sdtNV; }
    public String getDiaChiNV() { return diaChiNV; }
    public Double getLuongNV() { return luongNV; }

    public void setMaNV(String MaNV) { this.maNV = MaNV; }
    public void setHoNV(String HoNV) { this.hoNV = HoNV; }
    public void setTenNV(String TenNV) { this.tenNV = TenNV; }
    public void setChucVu(String ChucVu) { this.chucVu = ChucVu; }
    public void setNgaySinh(String NgaySinhKH) {
        try{
            this.ngaySinh=LocalDate.parse(NgaySinhKH,formatter);
        }catch (DateTimeException e){
            System.err.print("\nNgay sinh khong hop le. Dinh dang phai la dd-MM-yyyy.");
            this.ngaySinh=LocalDate.of(0001,01,01);
        }
    }
    public void setGioiTinh(String GioiTinh) { this.gioiTinh = GioiTinh; }
    public void setSDTNV(String SDTNV) { this.sdtNV = SDTNV; }
    public void setDiaChiNV(String DiaChiNV) { this.diaChiNV = DiaChiNV; }
    public void setLuongNV(Double LuongNV) { this.luongNV = LuongNV; }

    public void xuatNV(){
        System.err.print("\n----------------------------------------------------------------------------------------------------------------\n");
        System.err.printf("| Ma Nhan Vien: %-10s| Ho Nhan Vien: %-10s | Ten Nhan Vien: %-16s | Chuc Vu: %-10s\n", maNV, hoNV, tenNV, chucVu);
        System.err.printf("| SDT: %-12s       | Ngay Sinh : %-12s   | Gioi Tinh: %-18s     | Dia chi: %-10s | Luong: %-15.2f\n", sdtNV, ngaySinh.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), gioiTinh, diaChiNV, luongNV);
    }
}
