package QuanLyNXB;

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

    public void nhapNXB(){
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        System.out.print("\nNhap Ma nha xuat ban: ");
        maNXB=sc.nextLine();
        System.out.print("\nNhap Ten nha xuat ban: ");
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

    public void suaNXB() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("╔══════════════════════════════════════════╗\n");
            System.out.print("║  1. Sua Ten Nha Xuat Ban                 ║\n");
            System.out.print("║  2. Sua Dia Chi Nha Xuat Ban             ║\n");
            System.out.print("║  3. Sua So Dien Thoai Nha Xuat Ban       ║\n");
            System.out.print("║  4. Sua Email Nha Xuat Ban               ║\n");
            System.out.print("║  0. Thoat                                ║\n");
            System.out.print("╚══════════════════════════════════════════╝\n");
    
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Xoa bo dem
    
            switch (choice) {
                case 1:
                    System.out.println("Ten Nha Xuat Ban hien tai: " + getTenNXB());
                    System.out.print("Nhap Ten Nha Xuat Ban moi: ");
                    setTenNXB(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Dia chi hien tai: " + getDiaChiNXB());
                    System.out.print("Nhap Dia chi moi: ");
                    setDiaChiNXB(sc.nextLine());
                    break;
                case 3:
                    System.out.println("So dien thoai hien tai: " + getSdtNXB());
                    System.out.print("Nhap So dien thoai moi: ");
                    setSdtNXB(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Email hien tai: " + getEmail());
                    System.out.print("Nhap Email moi: ");
                    setEmail(sc.nextLine());
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
