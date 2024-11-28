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

    public void nhapTG(boolean skipMaTG){
        if(!skipMaTG){
            System.out.printf("\nNhap Ma Tac Gia: ");
            this.MaTacGia=sc.nextLine();
        }
        System.out.printf("Nhap Ten Tac Gia: ");
        this.TenTacGia=sc.nextLine();

        boolean CheckDate=false;
        while (!CheckDate) {
            System.out.printf("Nhap Nam Sinh Tac Gia(dd-mm-yyyy):  ");
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

    public void xuatTG(){
        System.out.println("╔══════════════════════════════════════════");
        System.out.printf("║      MA TAC GIA: %s          \n",MaTacGia);
        System.out.println("╠══════════════════════════════════════════");
        System.out.printf("║ TEN TAC GIA: %s                              \n",TenTacGia);
        System.out.printf("║ NAM SINH   : %s             \n",NamSinhTG);
        System.err.printf("║ QUE QUAN   : %s                      \n",QueQuan);
        System.out.println("╚══════════════════════════════════════════");
    }
}
//Thống kê các tác giả có trên 50 tuổi ghi ra