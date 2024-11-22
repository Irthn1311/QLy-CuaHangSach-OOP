import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import Interface.CRUD;

public class DSNhanVien implements CRUD {
    NhanVien[] run;
    Scanner sc=new Scanner(System.in);
    private int size=3;

    public DSNhanVien() {
        run = new NhanVien[3];
        run[0] = new NhanVien("NV001", "Le","Phan","Nhan Vien","02-03-2000","Nam","0111111111", "Ha Noi",700.0);
        run[1] = new NhanVien("NV002","Nghiem","Vu Hoang Long","Nhan Vien","02-03-1999","Nam","022222222222","Ha Noi",700.0);
        run[2] = new NhanVien("NV003","Nguyen", "Thao Linh","Quan Ly","07-10-2000","Nu","03333333333", "Ha Noi",2100.0);
    }

    @Override
    public void xem(){
        System.out.print("\nThong Tin Cua Nhan Vien");
        for(NhanVien nv: run){
            if( nv !=null){
                nv.xuatNV();
            }
        }
    }

    @Override
    public void them(){
        for(int i=0;i<run.length;i++){
            if(run[i]==null){
                run[i]=new NhanVien();
                run[i].nhapNV();
                size++;
                return;
            }
        }
        if(size==run.length){
            NhanVien[] newRun= new NhanVien[run.length+1];
            for(int i=0;i<run.length;i++){
                if(run[i]!= null){
                    newRun[i]=run[i];
                }
            }
            run=newRun;
        }
        run[size]=new NhanVien();
        run[size].nhapNV();
        size++;
    }

    @Override
    public void sua(){
        boolean memberFind=false;
        System.out.print("\nNhap Ma Nhan Vien Can Sua: ");
        String checked = sc.nextLine();
        for(NhanVien nv: run){
            if(nv !=null && checked.equals(nv.getMaNV())){
                nv.nhapNV();
                memberFind=true;
                break;
            }
        }
        if (!memberFind) {
            System.out.print("\nKHONG TIM THAY MA NHAN VIEN: "+checked);
        } else {
            System.out.print("\nCHINH SUA THONG TIN NHAN VIENTHANH CONG!!!");
        } 
    }

    @Override
    public void xoa(){
        boolean memberFind=false;
        System.out.print("\nNhap Ma Nhan Vien Can Xoa: ");
        String checked=sc.nextLine();
        for(int i=0;i<run.length;i++){
            if(run[i]!=null && checked.equals(run[i].getMaNV())){
                run[i]=null;
                memberFind=true;
                size--;
                break;
            }
        }
        if (!memberFind) {
            System.out.print("\nKHONG TIM THAY MA NHAN VIEN: "+checked);
        } else {
            System.out.print("\nXOA THONG TIN NHAN VIENTHANH CONG!!!");
        } 
    }

    @Override
    public void timkiem(){
        int find;
        do {
            System.out.println("\nLua Chon Tim Kiem:");
            System.out.println("1. Tim Kiem Theo Ma Nhan Vien");
            System.out.println("2. Tim Kiem Theo Ho Nhan Vien");
            System.out.println("3. Tim Kiem Theo Ten Lot Va Ten Nhan Vien");
            //System.out.println("");
            System.out.println("0. Thoat");
            System.out.print("Lua Chon Cua Ban: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    boolean memberFind1=false;
                    System.out.print("\nNhap Ma Nhan Vien Can Tim Kiem: ");
                    String checked1 = sc.nextLine();
                    for(NhanVien nv: run){
                        if(nv !=null && checked1.equals(nv.getMaNV())){
                            nv.xuatNV();
                            memberFind1=true;
                            break;
                        }
                    }
                    if(!memberFind1){
                        System.out.println("\nKHONG TIM THAY MA NHAN VIEN: "+checked1);
                    }
                    break;
                case 2:
                    boolean memberFind2=false;
                    System.out.print("\nNhap Ho Nhan Vien Can Tim Kiem: ");
                    String checked2 = sc.nextLine().toLowerCase();
                    for(NhanVien nv: run){
                        if(nv !=null && checked2.equals(nv.getHoNV().toLowerCase())){
                            nv.xuatNV();
                            memberFind2=true;
                            break;
                        }
                    }
                    if(!memberFind2){
                        System.out.println("\nKHONG TIM THAY NHAN VIEN CO HO: "+checked2);
                    }
                    break;
                case 3:
                    boolean memberFind3=false;
                    System.out.print("\nNhap Ten Hoac Ten Lot Nhan Vien Can Tim Kiem: ");
                    String checked3 = sc.nextLine().toLowerCase();
                    int checked3_length=checked3.length();
                    for(int i=0;i<run.length;i++){
                        if(run[i]!=null){
                            String fullString=run[i].getTenNV().toLowerCase();
                            int fullString_length=fullString.length();
                            for(int j=0;j<=fullString_length-checked3_length;j++){
                                int k;
                                for(k=0; k<checked3_length;k++){
                                    if(fullString.charAt(j+k)!=checked3.charAt(k)){
                                        break;
                                    }
                                }
                                if(k==checked3_length){
                                    run[i].xuatNV();
                                    memberFind3=true;
                                    break;
                                }
                            }
                        }
                    }
                    if(!memberFind3){
                        System.out.println("\nKHONG TIM THAY NHAN VIEN CO TEN: "+checked3);
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
            System.out.println("1. Thong Ke Do Tuoi Nhan Vien");
            System.out.println("2. Thong Ke Gioi Tinh Nhan Vien");
            System.err.println("3. Thong Ke Cac Chuc Vu Trong Cua Hang");
            System.err.println("4. Thong Ke Luong Nhan Vien ");
            System.out.println("0. Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    int hocsinh=0, thanhnien=0,truongthanh=0, trungnien=0,caotuoi=0;
                    for(NhanVien nv: run){
                        if(nv !=null){
                            int age=Period.between(nv.getNgaySinh(), nowDate).getYears();
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
                    System.out.print("\nThong Ke Do Tuoi Nhan Vien Tai Cua Hang");
                    System.out.print("\n------------------------------------------------------------");
                    System.out.print("\nHoc Sinh (0-18): "+hocsinh);
                    System.out.print("\nThanh Nien (19-25): "+thanhnien);
                    System.out.print("\nTruong Thanh (26-40): "+truongthanh);
                    System.out.print("\nTrung Nien (41-60): "+trungnien);
                    System.out.print("\nNguoi Cao Tuoi (lớn hơn 61): "+caotuoi);
                    break;
                case 2:
                    int male=0,female=0,gender_unknown=0;
                    for(NhanVien nv: run){
                        if(nv !=null){
                            String gender=nv.getGioiTinh().toLowerCase();
                            if(gender.equals("nam")){
                                male++;
                            }else if(gender.equals("nu")){
                                female++;
                            }else{
                                gender_unknown++;
                            }
                        }
                    }
                    System.out.print("Thong Ke Gioi Tinh Nhan Vien Tai Cua Hang");
                    System.out.print("\n------------------------------------------------------------");
                    System.out.print("\nNam: "+male+" Nu: "+female+" Khong Xac Dinh: "+gender_unknown);
                    break;
                case 3:
                    int member=0, manager=0, ceo=0;
                    for(NhanVien nv:run){
                        if(nv !=null){
                            String job=nv.getChucVu().toLowerCase();
                            if(job.equals("nhan vien")){
                                member++;
                            }else if(job.equals("quan ly")){
                                manager++;
                            }else{
                                ceo++;
                            }  
                        }
                    }
                    System.out.print("Thong Ke Chuc Vu Nhan Vien Tai Cua Hang");
                    System.out.print("\n------------------------------------------------------------");
                    System.out.print("\nNhan Vien: "+member+" Quan Ly: "+manager+" Giam Doc: "+ceo);
                    break;
                case 4:
                    System.out.print("\n1.Thong Ke Luong Nhan Vien Tren x: ");
                    System.out.print("\n2.Thong Ke Luong Nhan Vien Duoi x: ");
                    System.err.print("\n0.Thoat");
                    System.out.print("\nLua Chon Cua Ban: ");
                    int pick=sc.nextInt();
                    sc.nextLine();
                    switch (pick) {
                        case 1:
                            System.err.print("\nTren: ");
                            Double over=sc.nextDouble();
                            sc.nextLine();
                            boolean find1=false;
                            System.out.print("\nThong Tin Nhan Vien Co Luong Tren: "+over);
                            for(NhanVien nv: run){
                                if(nv!=null && nv.getLuongNV()>=over){
                                    nv.xuatNV();
                                    find1=true;
                                }
                            }
                            if(!find1){
                                System.err.print("KHONG CO AI TREN ");
                            }
                            break;
                        case 2:
                            System.err.print("\nDuoi: ");
                            Double under=sc.nextDouble();
                            sc.nextLine();
                            boolean find2=false;
                            System.out.print("\nThong Tin Nhan Vien Co Luong Duoi: "+under);
                            for(NhanVien nv: run){
                                if(nv!=null && nv.getLuongNV()<=under){
                                    nv.xuatNV();
                                    find2=true;
                                }
                            }
                            if(!find2){
                                System.err.print("KHONG CO AI TREN ");
                            }
                            break;
                        default:
                            System.out.print("\nThoat");
                            break;
                    }
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
        File readf=new File("NhanVien_Input.txt");
        try{
            if(!readf.exists()){
                System.out.print("FILE MOI DA DUOC TAO");
                readf.createNewFile();
            }
            try(BufferedReader br=Files.newBufferedReader(readf.toPath(),StandardCharsets.UTF_8)){
                boolean empty=true;
                String line;
                while ((line=br.readLine())!=null) {
                    empty=false;
                    String[] info=line.split("\\|");
                    if(info.length==9){
                        String maNV = info[0].trim();
                        String hoNV = info[1].trim();
                        String tenNV = info[2].trim();
                        String chucVu = info[3].trim();
                        String ngaySinh = info[4].trim();
                        String gioiTinh = info[5].trim();
                        String sdtNV = info[6].trim();
                        String diaChiNV = info[7].trim();
                        Double luongNV = Double.parseDouble(info[8].trim());

                        for(int i=0;i<run.length;i++){
                            if(run[i]==null){
                                run[i]= new NhanVien();
                                run[i].setMaNV(maNV);
                                run[i].setHoNV(hoNV);
                                run[i].setTenNV(tenNV);
                                run[i].setChucVu(chucVu);
                                run[i].setNgaySinh(ngaySinh);
                                run[i].setGioiTinh(gioiTinh);
                                run[i].setSDTNV(sdtNV);
                                run[i].setDiaChiNV(diaChiNV);
                                run[i].setLuongNV(luongNV);
                                size++;
                                return;
                            }
                        }
                        if(size==run.length){
                            NhanVien[] newRun=new NhanVien[run.length+1];
                            for(int j=0;j<run.length;j++){
                                if(run[j]!=null){
                                    newRun[j]=run[j];
                                }
                            }
                            run=newRun;
                        }
                        run[size]= new NhanVien();
                        run[size].setMaNV(maNV);
                        run[size].setHoNV(hoNV);
                        run[size].setTenNV(tenNV);
                        run[size].setChucVu(chucVu);
                        run[size].setNgaySinh(ngaySinh);
                        run[size].setGioiTinh(gioiTinh);
                        run[size].setSDTNV(sdtNV);
                        run[size].setDiaChiNV(diaChiNV);
                        run[size].setLuongNV(luongNV);
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
            PrintWriter pw=new PrintWriter("NhanVien_Input.txt");
            String text=sc.nextLine();
            pw.print(text);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
