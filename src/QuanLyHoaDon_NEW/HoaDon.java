import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class HoaDon {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter  formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String maHD;
    private String maKH;
    private String maNV;
    private LocalDate ngayTaoHD;
    private double tongTien;
    private double tienNhan;
    private double tienThoi;

    public HoaDon(){
        maHD = "";
        maKH = "";
        maNV = "";
        ngayTaoHD = null;
        tongTien = 0;
        tienNhan = 0;
        tienThoi = 0;
    }

    public HoaDon(String maHD, String maKH, String maNV, String ngayTaoHD, double tongTien,double tienNhan){
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayTaoHD = LocalDate.parse(ngayTaoHD,formatter);
        this.tongTien = tongTien;
        this.tienNhan = tienNhan;
        this.tienThoi = tienNhan-tongTien;
    }

    public void setmaHD(String maHD) {this.maHD = maHD;}
    public void setmaKH(String maKH) {this.maKH = maKH;}
    public void setmaNV(String maNV) {this.maNV = maNV;}
    public void setngayTaoHD(String ngayTaoHD) {
        try{
            this.ngayTaoHD=LocalDate.parse(ngayTaoHD,formatter);
        }catch (DateTimeException e){
            this.ngayTaoHD=LocalDate.of(0001,01,01);
        }
    }
    public void settongTien(double tongTien) {this.tongTien = tongTien;}
    public void settienNhan(double tienNhan) {this.tienNhan = tienNhan;}
    public void settienThoi(double tienThoi) {this.tienThoi = tienNhan-tongTien;}

    public double gettienThoi() {return this.tienThoi;}
    public String getmaHD() {return this.maHD;}
    public double gettienNhan() {return this.tienNhan;}
    public String getmaNV() {return this.maNV;}
    public LocalDate getngayTaoHD() {return ngayTaoHD;}
    public String getmaKH() {return this.maKH;}
    public double gettongTien() {return this.tongTien;}

    public void nhap()
    {
        System.out.print("Nhap ma hoa don: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        maKH = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        boolean CheckDate = false;
        while (!CheckDate) {
            System.out.printf("Nhap Ngay Tao Hoa Don (dd-MM-yyyy): ");
            String ngaySinhInput = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                this.ngayTaoHD = LocalDate.parse(ngaySinhInput, formatter);
                CheckDate = true;
            } catch (DateTimeParseException e) {
                System.err.println("Ngay nhan hang khong hop le. Vui long nhap lai(dd-MM-yyyy).");
            }
        }
        System.out.print("Nhap tien nhan: ");
        tienNhan = sc.nextDouble();
        sc.nextLine();
        
    }

    public void xuat(){
        System.out.print("\n\n╔══════════════════════════════╦═══════════════════════╗\n");
        System.out.printf("║ HOA DON NGAY: %-7s     ║   MA HOA DON: %-7s ║\n",ngayTaoHD.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),maHD );
        System.out.print("╠══════════════════════════════╩═══════════════════════╣\n");
        System.err.printf("║ MA KHACH HANG: %-7s                               ║\n",maKH);
        System.err.printf("║ TIEN NHAN TU KHACH: %-10.2f       VND             ║\n",tienNhan);
        System.err.printf("║ TONG TIEN DON HANG: %-10.2f       VND             ║\n",tongTien);
        System.err.printf("║ TIEN PHAI THOI CHO KHACH: %-10.2f VND             ║\n",tienNhan-tongTien);
        System.err.printf("╠══════════════════════════════════════════════════════╣\n");
        System.err.printf("║ MA NHAN VIEN: %-7s                                ║\n",maNV);
        System.out.print("╚══════════════════════════════════════════════════════╝");
        
        
    }

} 