import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import Interface.CRUD;
public class DSKhachHang implements CRUD {
    KhachHang[] KH;
    Scanner sc=new Scanner(System.in);
    private int size=3;

    public DSKhachHang() {
        KH = new KhachHang[3];
        KH[0] = new KhachHang("KH001", "Le","Phan","02-03-2000","Nam","0111111111", "Quan 1");
        KH[1] = new KhachHang("KH002","Nghiem","Vu Hoang Long","02-03-1999","Nam","022222222222","Tan Phu");
        KH[2] = new KhachHang("KH003","Nguyen", "Thao Linh","07-10-2000","Nu","03333333333", "Quan 2");
    }

    @Override
    public void xem(){
        System.out.print("\nThong Tin Cua Khach Hang");
        for(KhachHang Khach: KH){
            if( Khach !=null){
                Khach.xuatKH();
            }
        }
    }

    @Override
    public void them(){
        for(int i=0;i<KH.length;i++){
            if(KH[i]==null){
                KH[i]=new KhachHang();
                KH[i].nhapKH();
                size++;
                return;
            }
        }
        if(size== KH.length){
            KhachHang[] newKH= new KhachHang[KH.length+1];
            for(int j=0;j<KH.length;j++){
                if(KH[j]!=null)
                    newKH[j]=KH[j];
            }
            KH=newKH;
        }
        KH[size]=new KhachHang();
        KH[size].nhapKH();
        size++;
    }

    @Override
    public void sua(){
        boolean guestFind=false;
        System.out.print("\nNhap Ma Khach Hang Can Sua: ");
        String checked = sc.nextLine();
        for(KhachHang Khach: KH){
            if(Khach !=null && checked.equals(Khach.getMaKH())){
                Khach.nhapKH();
                guestFind=true;
                break;
            }
        }
        if (!guestFind) {
            System.out.println("\nKHONG TIM THAY MA KHACH HANG.");
        } else {
            System.out.println("\nCHINH SUA THONG TIN KHACH HANG THANH CONG!!!");
        }
    }

    @Override
    public void xoa(){
        boolean guestFind=false;
        System.out.print("\nNhap Ma Khach Hang Can Xoa: ");
        String checked = sc.nextLine();
        for(int i = 0; i < KH.length; i++){
            if(KH[i] !=null && checked.equals(KH[i].getMaKH())){
                KH[i]=null;
                guestFind=true;
                size--;
                break;
            }
        }
        if (!guestFind) {
            System.out.println("\nKHONG TIM THAY MA KHACH HANG.");
        } else {
            System.out.println("\nXOA THONG TIN KHACH HANG THANH CONG!!!");
        }
    }

    @Override
    public void timkiem(){
        int find;
        do {
            System.out.println("\nLua Chon Tim Kiem:");
            System.out.println("1. Tim Kiem Theo Ma Khach Hang");
            System.out.println("2. Tim Kiem Theo Ho Khach Hang");
            System.out.println("3. Tim Kiem Theo Ten Lot Va Ten Khach Hang");
            System.out.println("4. Tim Kiem Nang Cao Khach O Quan A Hoac Quan B << OR >>");
            System.err.println("5. Tim Kiem Nang CAo Khach Tu Tuoi x => Tuoi X << AND >>");
            System.out.println("0. Thoat");
            System.out.print("Lua Chon Cua Ban: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    boolean guestFind1=false;
                    System.out.print("\nNhap Ma Khach Hang Can Tim Kiem: ");
                    String checked1 = sc.nextLine();
                    for(KhachHang Khach: KH){
                        if(Khach !=null && checked1.equals(Khach.getMaKH())){
                            Khach.xuatKH();
                            guestFind1=true;
                            break;
                        }
                    }
                    if(!guestFind1){
                        System.out.println("\nKHONG TIM THAY MA KHACH HANG: "+checked1);
                    }
                    break;
                case 2:
                    boolean guestFind2=false;
                    System.out.print("\nNhap Ho Khach Hang Can Tim Kiem: ");
                    String checked2 = sc.nextLine().toLowerCase();
                    for(KhachHang Khach: KH){
                        if(Khach !=null && checked2.equals(Khach.getHoKH().toLowerCase())){
                            Khach.xuatKH();
                            guestFind2=true;
                            break;
                        }
                    }
                    if(!guestFind2){
                        System.out.println("\nKHONG TIM THAY KHACH HANG HO: "+checked2);
                    }
                    break;
                case 3:
                    boolean guestFind3=false;
                    System.out.print("\nNhap Ten Lot hoac Ten Khach Hang Can Tim Kiem: ");
                    String checked3=sc.nextLine().toLowerCase();
                    int checked3_length=checked3.length();
                    for(int i=0;i<KH.length;i++){
                        if(KH[i]!=null){
                            String fullString=KH[i].getTenKH().toLowerCase();
                            int fullString_length=fullString.length();
                            for (int j=0; j<= fullString_length-checked3_length;j++){
                                int k;
                                for(k=0;k<checked3_length;k++){
                                    if(fullString.charAt(j+k)!=checked3.charAt(k)){
                                        break;
                                    }
                                }
                                if(k== checked3_length){
                                    KH[i].xuatKH();
                                    guestFind3=true;
                                    break;
                                }
                            }
                        }
                    }
                    if(!guestFind3){
                        System.out.println("\nKHONG TIM THAY KHACH HANG TEN: "+checked3);
                    }
                    break;
                case 4:
                    System.out.print("\nNhap Quan Thu Nhat:");
                    String quanA=sc.nextLine().toLowerCase();
                    System.out.print("Nhap Quan Thu Hai:");
                    String quanB=sc.nextLine().toLowerCase();
                    boolean checked4=false;
                    for(KhachHang Khach: KH)
                        if(Khach !=null && ( (Khach.getDiaChiKH().toLowerCase().equals(quanA)) || (Khach.getDiaChiKH().toLowerCase().equals(quanB)))){
                            Khach.xuatKH();
                            checked4=true;
                        }
                    if(!checked4){
                        System.out.println("\nKHONG TIM THAY KHACH HANG O "+quanA.toUpperCase()+" VA "+quanB.toUpperCase());
                    }
                    break;
                case 5:
                    System.out.print("\nNhap Do Tuoi Start: ");  
                    int ageA=sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nNhap Do Tuoi End: ");  
                    int ageB=sc.nextInt();
                    sc.nextLine();
                    boolean checked5=false;
                    LocalDate nowDate=LocalDate.now();
                    for(KhachHang Khach: KH){
                        if(Khach !=null){
                            int age=Period.between(Khach.getNgaySinh(), nowDate).getYears();
                            if(ageA<=age && ageB>=age){
                                Khach.xuatKH();
                                checked5=true;
                            }
                        }
                    }
                    if(!checked5){
                        System.out.println("\nKHONG TIM THAY KHACH HANG TU "+ageA+" => "+ageB+"TUOI");
                    }
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

    @Override
    public void thongke(){
        LocalDate nowDate=LocalDate.now();
        int choice;
        do {
            System.out.println("\nLua Chon Thong Ke:");
            System.out.println("1. Thong Ke Do Tuoi Khach Hang");
            System.out.println("2. Thong Ke Gioi Tinh Khach Hang");
            System.out.println("0. Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    int hocsinh=0, thanhnien=0,truongthanh=0, trungnien=0,caotuoi=0;
                    for(KhachHang Khach: KH){
                        if(Khach!=null){
                            int age=Period.between(Khach.getNgaySinh(), nowDate).getYears();
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
                    System.out.print("\nThong Ke Do Tuoi Cua Khach Hang Tai Cua Hang");
                    System.out.print("\n------------------------------------------------------------");
                    System.out.print("\nHoc Sinh (0-18): "+hocsinh);
                    System.out.print("\nThanh Nien (19-25): "+thanhnien);
                    System.out.print("\nTruong Thanh (26-40): "+truongthanh);
                    System.out.print("\nTrung Nien (41-60): "+trungnien);
                    System.out.print("\nNguoi Cao Tuoi (lớn hơn 61): "+caotuoi);
                    break;
                case 2:
                    int male=0,female=0,gender_unknown=0;
                    for(KhachHang Khach: KH){
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
                    System.out.print("Thong Ke Gioi Tinh Khach Hang Tai Cua Hang");
                    System.out.print("\n------------------------------------------------------------");
                    System.out.print("\nNam: "+male+" Nu: "+female+" Khong Xac Dinh: "+gender_unknown);
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
                        for(int i=0;i<KH.length;i++){
                            if(KH[i]==null){
                                KH[i]=new KhachHang();
                                KH[i].setMaKH(maKH);
                                KH[i].setHoKH(hoKH);
                                KH[i].setTenKH(tenKH);
                                KH[i].setNgaySinh(ngaySinhKH);
                                KH[i].setGioiTinh(gioitinh);
                                KH[i].setSDTKH(sdt);
                                KH[i].setDiaChiKH(diachi);
                                size++;
                                return;
                            }
                        }
                        if(size==KH.length){
                            KhachHang[] newKH=new KhachHang[KH.length+1];
                            for(int j=0;j<KH.length;j++){
                                if(KH[j]!=null)
                                    newKH[j]=KH[j];
                            }
                            KH=newKH;
                        }
                        KH[size]=new KhachHang();
                        KH[size].setMaKH(maKH);
                        KH[size].setHoKH(hoKH);
                        KH[size].setTenKH(tenKH);
                        KH[size].setNgaySinh(ngaySinhKH);
                        KH[size].setGioiTinh(gioitinh);
                        KH[size].setSDTKH(sdt);
                        KH[size].setDiaChiKH(diachi);
                        size++;
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
            PrintWriter pw=new PrintWriter("KhachHang_Input.txt","UTF-8");
            System.out.print("\nNhap Thong Tin Vao File: ");
            String text=sc.nextLine();
            pw.print(text);
            pw.flush();
            pw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
