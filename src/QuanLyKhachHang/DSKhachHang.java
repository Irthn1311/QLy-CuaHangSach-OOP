package QuanLyKhachHang;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import Interface.CRUD;

public class DSKhachHang implements CRUD {
    KhachHang[] arrKH;
    Scanner sc=new Scanner(System.in);

    private int viTriMaKh(String MaKH){
        for(int i = 0; i < arrKH.length; i++){
            if(arrKH[i] != null && arrKH[i].getMaKH().toLowerCase().equals(MaKH.toLowerCase())){
                return i;
            }
        }
        return -1;
    }
    
    private boolean kiemtraTonTai(String MaKh){
        for(KhachHang khachHang:arrKH){
            if(khachHang !=null && khachHang.getMaKH().equals(MaKh)){
                return true; // Đã tồn tại
            }
        }
        return false; //Không tồn tại
    }

    @Override
    public void xem(){
        if(arrKH.length == 0){
            System.out.print("Danh Sach Rong");
        }else{
            for(KhachHang khachHang: arrKH){
            if(khachHang !=null){
                khachHang.xuatKH();
                }
            }
        }
    }

    @Override
    public void them(){
        KhachHang kh_new=new KhachHang();
        kh_new.nhapKH(false);
        if(!kiemtraTonTai(kh_new.getMaKH())){
            arrKH = Arrays.copyOf(arrKH, arrKH.length + 1);
            arrKH[arrKH.length - 1] = kh_new;
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║    Ma Khach %s Da Ton Tai        \n",kh_new.getMaKH());
            System.err.print("╚══════════════════════════════════════════");
        }
        
    }

    @Override
    public void sua(){
        System.out.print("Nhap Ma Khach Hang Can Sua:");
        String MaKh=sc.nextLine();
        int vt=viTriMaKh(MaKh);
        if(vt!=-1){
            System.out.print("\nNhap Thong Tin Chinh Sua Cua Ma Khach Hang: "+MaKh);
            arrKH[vt].nhapKH(true);
            arrKH[vt].setMaKH(MaKh);
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Khach Hang: %s        \n",MaKh);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    @Override
    public void xoa(){
        System.out.print("\nNhap Ma Khach Hang Can Xoa: ");
        String maKh = sc.nextLine();
        int vt = viTriMaKh(maKh);
        if(vt != -1){
            for(int i = vt; i < arrKH.length - 1; i++){
                arrKH[i]=arrKH[i + 1];
            }
            arrKH = Arrays.copyOf(arrKH, arrKH.length - 1);
            System.out.println("Da Xoa Khach Hang Voi Ma: " + maKh);
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Khach Hang: %s        \n",maKh);
            System.err.print("╚══════════════════════════════════════════");
        }
        
    }

    public void timKiemTheoMaKh(){
        System.out.print("\nNhap Ma Khach Hang Can Tim: ");
        String maKh = sc.nextLine();
        if(kiemtraTonTai(maKh)){
            for(KhachHang khachHang:arrKH){
                if(khachHang !=null && khachHang.getMaKH().equals(maKh)){
                    khachHang.xuatKH();
                    break;
                }
            }
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Khach Hang: %s        \n",maKh);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    public void timKiemTheoHo(){
        System.out.print("\nNhap Ho Khach Hang Can Tim: ");
        String hoKh = sc.nextLine().toLowerCase();
        boolean find=false;
        for(KhachHang khachHang:arrKH){
            if(khachHang !=null && khachHang.getHoKH().toLowerCase().contains(hoKh)){
                khachHang.xuatKH();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ho Khach Hang: %s        \n",hoKh);
            System.err.print("╚══════════════════════════════════════════"); 
        }
    }
    public void timKiemTheoTen(){
        System.out.print("\nNhap Ten Khach Hang Can Tim: ");
        String hoKh = sc.nextLine().toLowerCase();
        boolean find=false;
        for(KhachHang khachHang:arrKH){
            if(khachHang !=null && khachHang.getTenKH().toLowerCase().contains(hoKh)){
                khachHang.xuatKH();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ten Khach Hang: %s        \n",hoKh);
            System.err.print("╚══════════════════════════════════════════"); 
        }
    }

    public void timKiemTheoQuan(){
        System.out.print("\nNhap Quan Thu Nhat:");
        String quanA=sc.nextLine().toLowerCase();
        System.out.print("Nhap Quan Thu Hai:");
        String quanB=sc.nextLine().toLowerCase();
        boolean find=false;
        for(KhachHang khachHang: arrKH){
            if(khachHang!=null && (khachHang.getDiaChiKH().toLowerCase().equals(quanA)|| khachHang.getDiaChiKH().toLowerCase().equals(quanB))){
                khachHang.xuatKH();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Khach Hang O %s va %s      \n",quanA,quanB);
            System.err.print("╚══════════════════════════════════════════"); 
        }
    }
    public void timKiemTheoTuoi(){
        LocalDate now=LocalDate.now();
        System.out.print("\nNhap Do Tuoi Start: ");  
        int ageA=sc.nextInt();
        sc.nextLine();
        System.out.print("\nNhap Do Tuoi End: ");  
        int ageB=sc.nextInt();
        sc.nextLine();
        boolean find=false;
        for(KhachHang khachHang: arrKH){
            int tuoi=Period.between(khachHang.getNgaySinh(), now).getYears();
            if(tuoi >=ageA && tuoi<ageB){
                khachHang.xuatKH();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Khach Hang Tu %d => %d      \n",ageA,ageB);
            System.err.print("╚══════════════════════════════════════════"); 
        }
    }

    @Override
    public void timkiem(){
        int find;
        do {
            System.err.print("\n╔══════════════════════════════════════════╗\n");
            System.out.println("║       MENU : Tim Kiem Khach Hang         ║ ");
            System.out.println("║   1. Tim Kiem Theo Ma Khach Hang         ║ ");
            System.out.println("║   2. Tim Kiem Theo Ho Khach Hang         ║ ");
            System.out.println("║   3. Tim Kiem Theo Ten Khach Hang        ║ ");
            System.out.println("║   4. Tim Kiem Theo Quan A va B <<OR>>    ║ ");
            System.out.println("║   5. Tim Kiem Theo Do Tuoi     <<AND>>   ║ ");
            System.out.println("║   0. Thoat                               ║ ");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("Lua Chon Cua Ban: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    timKiemTheoMaKh();
                    break;
                case 2:
                    timKiemTheoHo();
                    break;
                case 3:
                    timKiemTheoTen();
                    break;
                case 4:
                   timKiemTheoQuan();
                    break;
                case 5:
                    timKiemTheoTuoi();
                    break;
                case 0:
                    System.out.println("THOAT THANH CONG");
                    break;

                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (find!=0);
    }

    public void thongkeTheotuoi(){
        LocalDate now=LocalDate.now();
        int hocsinh=0, thanhnien=0,truongthanh=0, trungnien=0,caotuoi=0;
        for(KhachHang Khach: arrKH){
            if(Khach!=null){
                int age=Period.between(Khach.getNgaySinh(), now).getYears();
                if(age>0 && age<=18){
                    hocsinh++;
                }else if( age>19 && age<=25){
                    thanhnien++;
                }else if(age>26 && age<=40){
                    truongthanh++;
                }else if(age>40 && age<=60){
                    trungnien++;
                }else if(age>60){
                    caotuoi++;
                }
            }
        }
        System.err.print("\n╔══════════════════════════════════════════\n");
        System.out.println("║     Thong Ke Do Tuoi Cua Khach Hang      ");
        System.out.println("║  Hoc Sinh (0->18)            : "+hocsinh);
        System.out.println("║  Thanh Nien (19->25)         : "+thanhnien);
        System.out.println("║  Truong Thanh (26->40)       : "+truongthanh);
        System.out.println("║  Trung Nien (41-60)          : "+trungnien);
        System.out.println("║  Nguoi Cao Tuoi (lớn hơn 61) : "+caotuoi);
        System.out.print("╚══════════════════════════════════════════\n");
    }

    public void thongkeTheoGT(){
        int male=0,female=0,gender_unknown=0;
        for(KhachHang Khach: arrKH){
            if(Khach !=null){
                String gender=Khach.getGioiTinh().toLowerCase();
                if(gender.equals("nam")){
                    male++;
                }else if(gender.equals("nu")){
                    female++;
                }else{
                    gender_unknown++;
                }
            }
        }
        System.err.print("\n╔══════════════════════════════════════════\n");
        System.out.println("║       Thong Ke Gioi Tinh Khach             ");
        System.out.println("║   Nam:           : "+male);
        System.out.println("║   Nu             : "+female);
        System.out.println("║   Gioi Tinh Khac : "+gender_unknown);
        System.out.print("╚══════════════════════════════════════════\n");
    }
    @Override
    public void thongke(){
        int choice;
        do {
            System.err.print("\n╔══════════════════════════════════════════╗\n");
            System.out.println("║       MENU : Thong Ke                    ║ ");
            System.out.println("║   1. Thong Ke Do Tuoi Khach Hang         ║ ");
            System.out.println("║   2. Thong Ke Gioi Tinh Khach Hang       ║ ");
            System.out.println("║   0. Thoat                               ║ ");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("Lua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    thongkeTheotuoi();
                    break;
                case 2:
                    thongkeTheoGT();
                    break;
                case 0:
                    System.out.print("Thoat");
                    break;
                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (choice !=0);
    }

    @Override
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/khachhang.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                if (info.length == 7) {
                    String maKH = info[0].trim();
                    String hoKH = info[1].trim();
                    String tenKH = info[2].trim();
                    String ngaySinhKH = info[3].trim();
                    String gioiTinh = info[4].trim();
                    String sdtKH = info[5].trim();
                    String diaChiKH = info[6].trim();

                    if (!kiemtraTonTai(maKH)) {
                        if (arrKH == null) {
                            arrKH = new KhachHang[1];
                        } else {
                            arrKH = Arrays.copyOf(arrKH, arrKH.length + 1);
                        }
                        arrKH[arrKH.length - 1] = new KhachHang(maKH, hoKH, tenKH, ngaySinhKH, gioiTinh, sdtKH, diaChiKH);
                        System.err.print("\n╔══════════════════════════════════════════\n");
                        System.err.printf("║ Ma Khach  %s  Da Them      \n", maKH);
                        System.err.print("╚══════════════════════════════════════════");

                    } else {
                        System.err.print("\n╔══════════════════════════════════════════\n");
                        System.err.printf("║ Ma Khach  %s  Da Co      \n", maKH);
                        System.err.print("╚══════════════════════════════════════════");
                    }
                } else {
                    System.out.println("Du Lieu Khong Hop Le: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Da Xay Ra Loi Khi Doc File: " + e.getMessage());
        }
    }


    @Override
    public void ghiFile() {
    try {
        PrintWriter pw = new PrintWriter("data/khachhang.txt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (KhachHang kh : arrKH) {
            if (kh != null) {
                String formattedNgaySinh = kh.getNgaySinh().format(formatter);
                String line = kh.getMaKH() + "|" 
                            + kh.getHoKH() + "|" 
                            + kh.getTenKH() + "|" 
                            + formattedNgaySinh + "|" 
                            + kh.getGioiTinh() + "|" 
                            + kh.getSDTKH() + "|" 
                            + kh.getDiaChiKH();
                pw.println(line);
            }
        }

        System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG.");
        pw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
