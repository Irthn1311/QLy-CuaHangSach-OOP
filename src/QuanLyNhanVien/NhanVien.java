package QuanLyNhanVien;

import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class NhanVien {
    Scanner sc = new Scanner(System.in);
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

    public void nhapNV(){

        
        System.out.print("Nhap Ma Nhan Vien: ");
        this.maNV = sc.nextLine();
        
        
        System.out.print("\nNhap Ho Nhan Vien: ");
        this.hoNV = sc.nextLine();

        System.out.print("Nhap Ten Nhan Vien: ");
        this.tenNV = sc.nextLine();

        System.out.print("Nhap Chuc Vu Nhan Vien: ");
        this.chucVu = sc.nextLine();

        boolean CheckDate = false;
        while (!CheckDate) {
            System.out.print("Nhap Ngay Sinh Nhan Vien (dd-mm-yyyy): ");
            String ngaySinhInput = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                this.ngaySinh = LocalDate.parse(ngaySinhInput, formatter);
                CheckDate = true;
            } catch (DateTimeParseException e) {
                System.err.println("\nNgay sinh khong hop le. Vui long nhap lai(dd-mm-yyyy).");
            }
        }

        System.out.print("Nhap Gioi Tinh Nhan Vien: ");
        this.gioiTinh = sc.nextLine();

        System.out.print("Nhap So Dien Thoai Nhan Vien:  ");
        this.sdtNV = sc.nextLine();

        System.out.print("Nhap Dia Chi Nhan Vien: ");
        this.diaChiNV = sc.nextLine();

        System.out.print("Nhap Luong Nhan Vien: ");
        this.luongNV = sc.nextDouble();
        sc.nextLine();
    }

    public void xuatNV(){
        System.out.println("\n╔══════════════════════════════════════════");
        System.out.printf("║      MA NHAN VIEN: %s          \n",maNV);
        System.out.println("╠══════════════════════════════════════════");
        System.out.printf("║ Ho Va Ten Khach: %s %s   \n",hoNV,tenNV);
        System.out.printf("║ SDT            : %s      \n",sdtNV);
        System.err.printf("║ Ngay Sinh      : %s      \n",ngaySinh.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.err.printf("║ Gioi Tinh      : %s      \n",gioiTinh);
        System.err.printf("║ Dia Chi        : %s      \n",diaChiNV);
        System.err.printf("║ Luong          : %s      \n",luongNV);
        System.out.println("╚══════════════════════════════════════════");
    }

    public void suaNV() {
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════╗\n");
            System.out.print("║  1. Ho Nhan Vien                         ║\n");
            System.out.print("║  2. Ten Nhan Vien                        ║\n");
            System.out.print("║  3. Chuc Vu                              ║\n");
            System.out.print("║  4. Ngay Sinh                            ║\n");
            System.out.print("║  5. Gioi Tinh                            ║\n");
            System.out.print("║  6. So Dien Thoai                        ║\n");
            System.out.print("║  7. Dia Chi Nhan Vien                    ║\n");
            System.err.print("║  8. Luong Nhan Vien                      ║\n");
            System.out.print("║  0.Thoat                                 ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Xoa bo dem
    
            switch (choice) {
                case 1:
                    System.out.println("Ho Nhan Vien Hien Tai: " + getHoNV());
                    System.out.print("Nhap Ho Nhan Vien Moi: ");
                    this.hoNV = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Ten Nhan Vien Hien Tai: " + getTenNV());
                    System.out.print("Nhap Ten Nhan Vien Moi: ");
                    this.tenNV = sc.nextLine();
                    break;
                case 3:
                    System.out.println("Chuc Vu Hien Tai: " + getChucVu());
                    System.out.print("Nhap Chuc Vu Moi: ");
                    this.chucVu = sc.nextLine();
                    break;
                case 4:
                    System.out.println("Ngay Sinh Hien Tai: " + getNgaySinh());
                    boolean checkDate = false;
                    while (!checkDate) {
                        System.out.print("Nhap Ngay Sinh Moi (dd-MM-yyyy): ");
                        String ngaySinhInput = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        try {
                            this.ngaySinh = LocalDate.parse(ngaySinhInput, formatter);
                            checkDate = true;
                        } catch (DateTimeParseException e) {
                            System.err.println("Ngay sinh khong hop le. Vui long nhap lai.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Gioi Tinh Hien Tai: " + getGioiTinh());
                    System.out.print("Nhap Gioi Tinh Moi: ");
                    this.gioiTinh = sc.nextLine();
                    break;
                case 6:
                    System.out.println("So Dien Thoai Hien Tai: " + getSDTNV());
                    System.out.print("Nhap So Dien Thoai Moi: ");
                    this.sdtNV = sc.nextLine();
                    break;
                case 7:
                    System.out.println("Dia Chi Hien Tai: " + getDiaChiNV());
                    System.out.print("Nhap Dia Chi Moi: ");
                    this.diaChiNV = sc.nextLine();
                    break;
                case 8:
                    System.out.println("Luong Hien Tai: " + getLuongNV());
                    System.out.print("Nhap Luong Moi: ");
                    this.luongNV = sc.nextDouble();
                    sc.nextLine(); // Xoa bo dem
                    break;
                case 0:
                    System.out.println("Ket thuc chinh sua.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        } while (choice != 0);
    }
}
