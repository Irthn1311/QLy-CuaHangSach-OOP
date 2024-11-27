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
    @SuppressWarnings("resource")
   public void nhapNXB(){
    Scanner sc=new Scanner(System.in);
    System.out.print("\nNhap Ma nha xuat ban: ");
    maNXB=sc.nextLine();
    System.out.print("\nNhap Ten nha xuat ban: ");
    tenNXB=sc.nextLine();
    System.out.print("\nNhap Dia chi nha xuat ban: ");
    diaChiNXB=sc.nextLine();
    System.out.print("\nNhap So dien thoai nha xuat ban: ");
    sdtNXB=sc.nextLine();
    System.out.print("\nNhap Email NXB: ");
    email=sc.nextLine();
   }
    public void xuatNXB() {
        System.out.print("\n-------------------------------------------------------------------------------------------------------------------------\n");
        System.out.print("\nMa NXB: "+maNXB+
        "\nTen NXB: "+tenNXB+
        "\nDia chi NXB: "+diaChiNXB+
        "\nSDT NXB: "+sdtNXB+
        "\nEmail NXB: "+email);
    }
}
