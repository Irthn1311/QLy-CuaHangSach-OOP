package QuanlyTacGia;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class TacGia {
    Scanner sc= new Scanner(System.in);
    private String MaTacGia;
    private String TenTacGia;
    private LocalDate NamSinhTG;
    private String QueQuan;
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public TacGia(){
        this.MaTacGia="";
        this.TenTacGia="";
        this.NamSinhTG=null;
        this.QueQuan="";
    }
    public TacGia(String MaTacGia, String TenTacGia, String NgaySinhTG, String QueQuan){
        this.MaTacGia=MaTacGia;
        this.TenTacGia=TenTacGia;
        this.NamSinhTG=LocalDate.parse(NgaySinhTG,formatter);
        this.QueQuan=QueQuan;
    }

    public String getMaTacGia(){ return MaTacGia; }
    public String getTenTacGia(){ return TenTacGia; }
    public LocalDate getNamSinhTG(){ return NamSinhTG; }
    public String getQueQuan(){ return QueQuan; }

    public void setMaTacGia(String MaTacGia){ this.MaTacGia=MaTacGia; }
    public void setTenTacGia(String TenTacGia){ this.TenTacGia=TenTacGia; }
    public void setNamSinhTG(String NamSinhTG){ 
        try{
            this.NamSinhTG=LocalDate.parse(NamSinhTG,formatter);
        }catch(DateTimeParseException e) {
            System.out.print("\nNgay sinh khong hop le. Dinh dang phai la dd-MM-yyyy.");
            this.NamSinhTG=LocalDate.of(0001, 01, 01);
        }
    }
    public void setQueQuan(String QueQuan){ this.QueQuan=QueQuan; }

    public void nhapTG(){
        System.out.printf("\nNhap Ma Tac Gia: ");
        this.MaTacGia=sc.nextLine();
        System.out.printf("\nNhap Ten Tac Gia: ");
        this.TenTacGia=sc.nextLine();

        boolean CheckDate=false;
        while (!CheckDate) {
            System.out.printf("Nhap Nam Sinh Tac Gia (dd-mm-yyyy): ");
            String NgaySinhTG=sc.nextLine();
            try{
                this.NamSinhTG=LocalDate.parse(NgaySinhTG,formatter);
                CheckDate=true;
            } catch(DateTimeParseException e){
                System.out.printf("Ngay sinh khong hop le. Vui long nhap lai. ");
            }
        }

        System.out.printf("Nhap Que Quan Tac Gia: ");
        this.QueQuan=sc.nextLine();
    }

    

    public void xuatTG(){
        System.out.println("╔══════════════════════════════════════════");
        System.out.printf("║      MA TAC GIA: %s          \n",MaTacGia);
        System.out.println("╠══════════════════════════════════════════");
        System.out.printf("║ TEN TAC GIA: %s                              \n",TenTacGia);
        System.out.printf("║ NAM SINH   : %s             \n",NamSinhTG.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.err.printf("║ QUE QUAN   : %s                      \n",QueQuan);
        System.out.println("╚══════════════════════════════════════════");
    }

    public void suaTG() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════╗\n");
            System.out.print("║  1. Sua Ten Tac Gia                      ║\n");
            System.out.print("║  2. Sua Ngay Sinh Tac Gia                ║\n");
            System.out.print("║  3. Sua Que Quan Tac Gia                 ║\n");
            System.out.print("║  0. Thoat                                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
    
            System.out.print("Lua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();
    
            switch (choice) {
                case 1:
                    System.out.print("Ten Tac Gia Hien Tai: " + getTenTacGia());
                    System.out.print("\nNhap Ten Tac Gia Moi: ");
                    this.TenTacGia = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Ngay Sinh Hien Tai: " + getNamSinhTG().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    boolean checkDate = false;
                    while (!checkDate) {
                        System.out.print("Nhap Ngay Sinh Moi (dd-MM-yyyy): ");
                        String ngaySinhInput = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        try {
                            this.NamSinhTG = LocalDate.parse(ngaySinhInput, formatter);
                            checkDate = true;
                        } catch (DateTimeParseException e) {
                            System.err.println("Ngay sinh khong hop le. Vui long nhap lai.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Que Quan Hien Tai: " + getQueQuan());
                    System.out.print("\nNhap Que Quan Moi: ");
                    this.QueQuan = sc.nextLine();
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
//Thống kê các tác giả có trên 50 tuổi ghi ra