import java.util.Scanner;

public class NhaXuatBan {
    private String maNXB;     
    private String tenNXB;    
    private String diaChiNXB;
    private String sdtNXB;     
    private String email;      

    public NhaXuatBan() {
        this.maNXB = "";
        this.tenNXB = "";
        this.diaChiNXB = "";
        this.sdtNXB = "";
        this.email = "";
    }

    public NhaXuatBan(String maNXB, String tenNXB, String diaChiNXB, String sdtNXB, String email) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChiNXB = diaChiNXB;
        this.sdtNXB = sdtNXB;
        this.email = email;
    }


    public String getMaNXB() {
        return maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public String getDiaChiNXB() {
        return diaChiNXB;
    }

    public String getSdtNXB() {
        return sdtNXB;
    }

    public String getEmail() {
        return email;
    }


    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public void setDiaChiNXB(String diaChiNXB) {
        this.diaChiNXB = diaChiNXB;
    }

    public void setSdtNXB(String sdtNXB) {
        this.sdtNXB = sdtNXB;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   public void nhapNXB(boolean skipMaNXB){
    Scanner sc=new Scanner(System.in);
    if(!skipMaNXB){
        System.out.print("Nhap Ma nha xuat ban: ");
        maNXB=sc.nextLine();
    }
    System.out.print("Nhap Ten nha xuat ban: ");
    tenNXB=sc.nextLine();
    System.out.print("Nhap Dia chi nha xuat ban: ");
    diaChiNXB=sc.nextLine();
    System.out.print("Nhap So dien thoai nha xuat ban: ");
    sdtNXB=sc.nextLine();
    System.out.print("Nhap Email NXB: ");
    email=sc.nextLine();
   }
    public void xuatNXB() {
        System.out.println("╔══════════════════════════════════════════");
        System.out.printf("║      MA NHA XUAT BAN: %s          \n",maNXB);
        System.out.println("╠══════════════════════════════════════════");
        System.out.printf("║ Ten Nha Xuat Ban: %s                              \n",tenNXB);
        System.out.printf("║ Email  : %s                   \n",email);
        System.err.printf("║ SDT    : %s                      \n",sdtNXB);
        System.err.printf("║ Dia Chi: %s                      \n",diaChiNXB);
        System.out.println("╚══════════════════════════════════════════");
    }
}
