package QuanLyKhachHang;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class KhachHang {
    private String maKH;
    private String hoKH;
    private String tenKH;
    private LocalDate ngaySinh;
    private String gioiTinh; 
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

    @SuppressWarnings("resource")
    public void nhapKH(boolean skipMaKH){
        Scanner sc= new Scanner(System.in);
        if(!skipMaKH){
            System.out.print("\nNhap Ma Khach Hang: ");
            this.maKH=sc.nextLine();
        }
        
        System.out.print("\nNhap Ho Khach Hang: ");
        this.hoKH=sc.nextLine();

        System.out.print("Nhap Ten Khach Hang: ");
        this.tenKH=sc.nextLine();

        boolean checkDate=false;
        while (!checkDate) {
            System.err.print("Nhap Ngay Sinh Khach Hang (dd-mm-yyyy): ");
            String ngaySinhKH=sc.nextLine();
            try{
                this.ngaySinh=LocalDate.parse(ngaySinhKH,formatter);
                checkDate=true;
            } catch(DateTimeParseException e){
                System.out.print("\nNgay sinh khong hop le. Vui long nhap lai. ");
            }
        }
        System.out.print("Nhap Gioi Tinh Khach Hang: ");
        this.gioiTinh=sc.nextLine();

        System.out.print("Nhap So Dien Thoai Khach Hang: ");
        this.sdtKH=sc.nextLine();

        System.out.print("Nhap Dia Chi Khach Hang: ");
        this.diaChiKH=sc.nextLine();
    }
    
    public void xuatKH(){
        System.out.println("╔══════════════════════════════════════════");
        System.out.printf("║      MA KHACH HANG: %s          \n",maKH);
        System.out.println("╠══════════════════════════════════════════");
        System.out.printf("║ Ho Va Ten Khach: %s %s   \n",hoKH,tenKH);
        System.out.printf("║ SDT            : %s      \n",sdtKH);
        System.err.printf("║ Ngay Sinh      : %s      \n",ngaySinh.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.err.printf("║ Dia Chi        : %s      \n",diaChiKH);
        System.out.println("╚══════════════════════════════════════════");
    }
    public void suaKH() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("\n1.Sua Ho Khach Hang");
            System.out.print("\n2.Sua Ten Khach Hang");
            System.out.print("\n3.Sua Ngay Sinh Khach Hang");
            System.out.print("\n4.Sua Gioi Tinh Khach Hang");
            System.out.print("\n5.Sua So Dien Thoai Khach Hang");
            System.out.print("\n6.Sua Dia Chi Khach Hang");
            System.out.print("\n0.Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ho Khach Hang Hien Tai: " + getHoKH());
                    System.out.print("\nNhap Ho Khach Hang Moi: ");
                    this.hoKH = sc.nextLine();
                    break;
                case 2:
                    System.out.print("Ten Khach Hang Hien Tai: " + getTenKH());
                    System.out.print("\nNhap Ten Khach Hang Moi: ");
                    this.tenKH = sc.nextLine();
                    break;
                case 3:
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
                case 4:
                    System.out.println("Gioi Tinh Hien Tai: " + getGioiTinh());
                    System.out.print("Nhap Gioi Tinh Moi: ");
                    this.gioiTinh = sc.nextLine();
                    break;
                case 5:
                    System.out.println("So Dien Thoai Hien Tai: " + getSDTKH());
                    System.out.print("Nhap So Dien Thoai Moi: ");
                    this.sdtKH = sc.nextLine();
                    break;
                case 6:
                    System.out.print("Dia Chi Hien Tai: " + getDiaChiKH());
                    System.out.print("Nhap Dia Chi Moi: ");
                    this.diaChiKH = sc.nextLine();
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
