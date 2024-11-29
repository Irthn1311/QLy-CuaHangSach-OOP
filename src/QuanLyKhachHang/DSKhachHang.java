package QuanLyKhachHang;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import Interface.CRUD;

public class DSKhachHang implements CRUD {
    KhachHang[] dsKH;
    Scanner sc=new Scanner(System.in);
    private int size=3;

    public DSKhachHang() {
        dsKH = new KhachHang[3];
        dsKH[0] = new KhachHang("KH001", "Le","Phan","02-03-2000","Nam","0111111111", "Quan 1");
        dsKH[1] = new KhachHang("KH002","Nghiem","Vu Hoang Long","02-03-1999","Nam","022222222222","Tan Phu");
        dsKH[2] = new KhachHang("KH003","Nguyen", "Thao Linh","07-10-2000","Nu","03333333333", "Quan 2");
    }

    private int viTriMaKh(String MaKH){
        for(int i=0;i<size-1;i++){
            if(dsKH[i]!=null && dsKH[i].getMaKH().equals(MaKH)){
                return i;
            }
        }
        return -1;
    }
    
    private boolean kiemtraTonTai(String MaKh){
        for(KhachHang khachHang:dsKH){
            if(khachHang !=null && khachHang.getMaKH().equals(MaKh)){
                return true; // Đã tồn tại
            }
        }
        return false; //Không tồn tại
    }

    @Override
    public void xem(){
        if(size==0){
            System.out.print("Danh Sach Rong");
        }else{
            for(KhachHang khachHang: dsKH){
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
            dsKH=Arrays.copyOf(dsKH, size+1);
            dsKH[size]=kh_new;
            size++;
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
            dsKH[vt].nhapKH(true);
            dsKH[vt].setMaKH(MaKh);
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
        int vt=viTriMaKh(maKh);
        if(vt!=-1){
            for(int i=vt;i<size-1;i++){
                if(dsKH[i] !=null){
                    dsKH[vt]=dsKH[vt+1];
                }
            }
            dsKH=Arrays.copyOf(dsKH, size-1);
            size--;
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
            for(KhachHang khachHang:dsKH){
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
        for(KhachHang khachHang:dsKH){
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
        for(KhachHang khachHang:dsKH){
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
        for(KhachHang khachHang: dsKH){
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
        for(KhachHang khachHang: dsKH){
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
        for(KhachHang Khach: dsKH){
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
        for(KhachHang Khach: dsKH){
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
    public void docFile(){
        File readf= new File("KhachHang_Input.txt");
        try{
            if(!readf.exists()){
                System.out.print("Tao File Khach Hang Moi Thanh Cong");
                readf.createNewFile();
            }
            try(BufferedReader br=Files.newBufferedReader(readf.toPath(),StandardCharsets.UTF_8)){
                boolean empty=true;
                String line;
                while ((line=br.readLine())!=null){
                    empty=false;
                    String[] info=line.split("\\|");
                    if(info.length==7){
                        String maKH=info[0].trim();
                        String hoKH=info[1].trim();
                        String tenKH=info[2].trim();
                        String ngaySinhKH=info[3].trim();
                        String gioitinh=info[4].trim();
                        String sdt=info[5].trim();
                        String diachi=info[6].trim();
                        
                        if(!kiemtraTonTai(maKH)){
                            dsKH=Arrays.copyOf(dsKH, size+1);
                            dsKH[size]=new KhachHang(maKH,hoKH,tenKH,ngaySinhKH,gioitinh,sdt,diachi);
                            System.err.print("\n╔══════════════════════════════════════════\n");
                            System.err.printf("║ Ma Khach  %s  Da Them      \n",maKH);
                            System.err.print("╚══════════════════════════════════════════");
                            size++;
                            
                        }else{
                            System.err.print("\n╔══════════════════════════════════════════\n");
                            System.err.printf("║ Ma Khach  %s  Da Co      \n",maKH);
                            System.err.print("╚══════════════════════════════════════════");
                        }
                    }else{
                        System.out.println("Du Lieu Khong Hop Le: " + line);
                    }
                }
                if (empty) {
                    System.out.println("\nFILE EMPTY WITH NOTHING");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile(){
        try {
            PrintWriter pw=new PrintWriter("KhachHang_Output.txt","UTF-8");
            
            for(KhachHang khach: dsKH){
                String line= "Ma Khach Hang: "+khach.getMaKH() + " | Ho Khach Hang: " + khach.getHoKH() + " | Ten Khach Hang: " + khach.getTenKH() + " | SDT: " + khach.getSDTKH()+ " | Ngay Sinh: " 
                + khach.getNgaySinh()+ " | Gioi Tinh: " +khach.getGioiTinh()+ " | Dia Chi: " +khach.getDiaChiKH();
                pw.println(line);
                pw.flush();
            }
            System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG ");
            pw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
