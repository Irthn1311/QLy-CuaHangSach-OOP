import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class KhachHang {
    private String maKH;
    private String hoKH;
    private String tenKH;
    private LocalDate ngaySinh;
    private String gioiTinh; // thong ke nam nu
    private String sdtKH;
    private String diaChiKH;
    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public KhachHang(){
        this.maKH="";
        this.hoKH="";
        this.tenKH="";
        this.ngaySinh=null;
        this.gioiTinh="";
        this.sdtKH="";
        this.diaChiKH="";
    }
    public KhachHang(String maKH,String hoKH,String tenKH,String ngaySinhKH,String gioiTinh,String sdtKH, String diaChiKH){
        this.maKH=maKH;
        this.hoKH=hoKH;
        this.tenKH=tenKH;
        this.ngaySinh=LocalDate.parse(ngaySinhKH,formatter);
        this.gioiTinh=gioiTinh;
        this.sdtKH=sdtKH;
        this.diaChiKH=diaChiKH;
    }

    public void nhapKH(){
        Scanner sc= new Scanner(System.in);
        System.err.printf("\nNhap Ma Khach Hang: ");
        this.maKH=sc.nextLine();

        System.err.printf("\nNhap Ho Khach Hang: ");
        this.hoKH=sc.nextLine();

        System.err.printf("\nNhap Ten Khach Hang: ");
        this.tenKH=sc.nextLine();

        boolean checkDate=false;
        while (!checkDate) {
            System.err.print("\nNhap Ngay Sinh Khach Hang: ");
            String ngaySinhKH=sc.nextLine();
            try{
                this.ngaySinh=LocalDate.parse(ngaySinhKH,formatter);
                checkDate=true;
            } catch(DateTimeParseException e){
                System.err.printf("\nNgay sinh khong hop le. Vui long nhap lai. ");
            }
        }
        System.err.printf("\nNhap Gioi Tinh Khach Hang: ");
        this.gioiTinh=sc.nextLine();

        System.err.printf("\nNhap So Dien Thoai Khach Hang:  ");
        this.sdtKH=sc.nextLine();

        System.err.printf("\nNhap Dia Chi Khach Hang: ");
        this.diaChiKH=sc.nextLine();
    }

    public String getMaKH(){ return maKH; }
    public String getHoKH(){ return hoKH; }
    public String getTenKH(){ return tenKH; }
    public LocalDate getNgaySinh(){ return ngaySinh;}
    public String getSDTKH(){ return sdtKH; }
    public String getGioiTinh(){ return gioiTinh; }
    public String getDiaChiKH(){ return diaChiKH; }

    public void setMaKH(String MaKH){ this.maKH=MaKH; }
    public void setHoKH(String HoKH){ this.hoKH=HoKH; }
    public void setTenKH(String TenKH){ this.tenKH=TenKH; }
    public void setNgaySinh(String ngaySinhKH){
        try{
            this.ngaySinh=LocalDate.parse(ngaySinhKH,formatter);
        }catch(DateTimeParseException e) {
            System.err.print("\nNgay sinh khong hop le. Dinh dang phai la dd-MM-yyyy.");
            this.ngaySinh=LocalDate.of(0001,01,01);
        }
    }
    public void setGioiTinh(String gioiTinh){this.gioiTinh=gioiTinh;}
    public void setSDTKH(String SDTKH){ this.sdtKH=SDTKH; }
    public void setDiaChiKH(String DiaChiKH){ this.diaChiKH=DiaChiKH; }

    public void xuatKH(){
        System.err.print("\n-----------------------------------------------------------------------------------------------------------------------\n");
        System.err.printf("| Ma Khach Hang: %-10s | Ho Khach Hang: %-10s | Ten Khach Hang: %-16s | SDT: %-10s\n", maKH, hoKH, tenKH, sdtKH);
        System.err.printf("| Ngay Sinh : %-10s    | Gioi Tinh: %-10s     | Dia Chi: %-16s ", ngaySinh.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), gioiTinh, diaChiKH);
    }
}
