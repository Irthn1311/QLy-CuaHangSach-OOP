package QuanLyNhanVien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import Interface.CRUD;

public class DSNhanVien implements CRUD {
    NhanVien[] arrNV = new NhanVien[10];
    Scanner sc=new Scanner(System.in);

    @Override
    public void xem(){
        System.out.print("\nThong Tin Cua Nhan Vien");
        for(NhanVien nv: arrNV){
            if( nv !=null){
                nv.xuatNV();
            }
        }
    }

    @Override
    public void them(){
        NhanVien nv = new NhanVien();
        nv.nhapNV();
        arrNV = Arrays.copyOf(arrNV, arrNV.length + 1);
        arrNV[arrNV.length - 1] = nv;

        // for(int i=0;i<arrNV.length;i++){
        //     if(arrNV[i]==null){
        //         arrNV[i]=new NhanVien();
        //         arrNV[i].nhapNV();
        //         size++;
        //         return;
        //     }
        // }
        // if(size==arrNV.length){
        //     NhanVien[] newarrNV= new NhanVien[arrNV.length+1];
        //     for(int i=0;i<arrNV.length;i++){
        //         if(arrNV[i]!= null){
        //             newarrNV[i]=arrNV[i];
        //         }
        //     }
        //     arrNV=newarrNV;
        // }
        // arrNV[size]=new NhanVien();
        // arrNV[size].nhapNV();
        // size++;

    }

    @Override
    public void sua(){
        boolean memberFind=false;
        System.out.print("\nNhap Ma Nhan Vien Can Sua: ");
        String checked = sc.nextLine().toLowerCase().trim();
        for(NhanVien nv: arrNV){
            if(nv !=null && nv.getMaNV().toLowerCase().equals(checked)){
                nv.suaNV();
                memberFind=true;
                System.out.print("\nCHINH SUA THONG TIN NHAN VIENTHANH CONG!!!");
                break;
            }
        }
        if (!memberFind) {
            System.out.print("\nKHONG TIM THAY MA NHAN VIEN: "+checked);
        }
    }

    @Override
    public void xoa(){
        boolean memberFind = false;
        System.out.print("\nNhap Ma Nhan Vien Can Xoa: ");
        String checked=sc.nextLine().toLowerCase().trim();

        for(int i = 0; i < arrNV.length; i++) {
            if (arrNV[i] != null && arrNV[i].getMaNV().toLowerCase().equals(checked))
            memberFind = true;
            for (int j = i; j < arrNV.length - 1; j++){
                arrNV[j] = arrNV[j + 1];
            }
            arrNV = Arrays.copyOf(arrNV, arrNV.length -1);
            System.out.print("\nXoa Thong Tin Nhan Vien Thanh Cong!!!");
        }

        
        // for(int i=0;i<arrNV.length;i++){
        //     if(arrNV[i]!=null && checked.equals(arrNV[i].getMaNV())){
        //         arrNV[i]=null;
        //         memberFind=true;
        //         size--;
        //         break;
        //     }
        // }

        if (!memberFind) {
            System.out.print("\nKHONG TIM THAY MA NHAN VIEN: "+checked);
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
            System.out.println("0. Thoat");
            System.out.print("Lua Chon Cua Ban: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    timkiemMaNV();
                    break;
                case 2:
                    timkiemHoNV();
                    break;
                case 3:
                    timkiemTenNV();
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

    public void timkiemMaNV(){
        boolean memberFind1=false;
        System.out.print("\nNhap Ma Nhan Vien Can Tim Kiem: ");
        String checked1 = sc.nextLine();
        for(NhanVien nv: arrNV){
            if(nv !=null && checked1.equals(nv.getMaNV())){
                nv.xuatNV();
                memberFind1=true;
                break;
            }
        }
        if(!memberFind1){
            System.out.println("\nKHONG TIM THAY MA NHAN VIEN: "+checked1);
        }
    }

    public void timkiemHoNV(){
        boolean memberFind2=false;
        System.out.print("\nNhap Ho Nhan Vien Can Tim Kiem: ");
        String checked2 = sc.nextLine().toLowerCase();
        for(NhanVien nv: arrNV){
            if(nv !=null && checked2.equals(nv.getHoNV().toLowerCase())){
                nv.xuatNV();
                    memberFind2=true;
                        break;
            }
        }
        if(!memberFind2){
            System.out.println("\nKHONG TIM THAY NHAN VIEN CO HO: "+checked2);
        }
    }

    public void timkiemTenNV(){
        boolean memberFind3=false;
        System.out.print("\nNhap Ten Hoac Ten Lot Nhan Vien Can Tim Kiem: ");
        String checked3 = sc.nextLine().toLowerCase();
        int checked3_length=checked3.length();
        for(int i=0;i<arrNV.length;i++){
            if(arrNV[i]!=null){
                String fullString=arrNV[i].getTenNV().toLowerCase();
                int fullString_length=fullString.length();
                for(int j=0;j<=fullString_length-checked3_length;j++){
                    int k;
                    for(k=0; k<checked3_length;k++){
                        if(fullString.charAt(j+k)!=checked3.charAt(k)){
                            break;
                        }
                    }
                    if(k==checked3_length){
                        arrNV[i].xuatNV();
                        memberFind3=true;
                        break;
                    }
                }
            }
        }
        if(!memberFind3){
            System.out.println("\nKHONG TIM THAY NHAN VIEN CO TEN: "+checked3);
        }
    }

    @Override
    public void thongke(){
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
                    thongkeTuoiNV();
                    break;
                case 2:
                    thongkeGioiTinhNV();
                    break;
                case 3:
                    thongkeChucVuNV();
                    break;
                case 4:
                    thongkeLuongNV();
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

    public void thongkeTuoiNV() {
        LocalDate nowDate=LocalDate.now();
        int hocsinh=0, thanhnien=0,truongthanh=0, tarrNVgnien=0,caotuoi=0;
        for(NhanVien nv: arrNV){
            if(nv !=null){
                int age = Period.between(nv.getNgaySinh(), nowDate).getYears();
                if(age>0 && age<=18){
                    hocsinh++;
                }else if(age > 19 && age <= 25){
                    thanhnien++;
                }else if(age > 26 && age <= 40){
                    truongthanh++;
                }else if(age > 40 && age <= 60){
                    tarrNVgnien++;
                }else if(age > 60){
                    caotuoi++;
                }
            }
        }
        System.out.print("\nThong Ke Do Tuoi Nhan Vien Tai Cua Hang");
        System.out.print("\n------------------------------------------------------------");
        System.out.print("\nHoc Sinh (0-18): "+hocsinh);
        System.out.print("\nThanh Nien (19-25): "+thanhnien);
        System.out.print("\nTruong Thanh (26-40): "+truongthanh);
        System.out.print("\nTarrNVg Nien (41-60): "+tarrNVgnien);
        System.out.print("\nNguoi Cao Tuoi (lớn hơn 61): "+caotuoi);
    }

    public void thongkeGioiTinhNV() {
        int male=0,female=0,gender_unknown=0;
        for(NhanVien nv: arrNV){
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
    }

    public void thongkeChucVuNV() {
        int member=0, manager=0, ceo=0;
        for(NhanVien nv:arrNV){
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
    }

    public void thongkeLuongNV() {
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
                for(NhanVien nv: arrNV){
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
                for(NhanVien nv: arrNV){
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
    }
    @Override 
    public void docFile() {
    try (BufferedReader br = new BufferedReader(new FileReader("data/nhanvien.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] info = line.split("\\|");
            if (info.length == 9) {
                String maNV = info[0].trim();
                String hoNV = info[1].trim();
                String tenNV = info[2].trim();
                String chucVu = info[3].trim();
                String ngaySinh = info[4].trim();
                String gioiTinh = info[5].trim();
                String sdtNV = info[6].trim();
                String diaChiNV = info[7].trim();
                Double luongNV = Double.parseDouble(info[8].trim());

                NhanVien nhanVien = new NhanVien(maNV, hoNV, tenNV, chucVu, ngaySinh, gioiTinh, sdtNV, diaChiNV, luongNV);

                if (arrNV == null) {
                    arrNV = new NhanVien[1];
                } else {
                    arrNV = Arrays.copyOf(arrNV, arrNV.length + 1);
                }
                arrNV[arrNV.length - 1] = nhanVien;
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
            PrintWriter pw = new PrintWriter("data/nhanvien.txt");
            for (NhanVien nv : arrNV) {
                if (nv != null) {
                    String line = nv.getMaNV() + "|" + nv.getHoNV() + "|" + nv.getTenNV() + "|" + nv.getChucVu() + "|" 
                                + nv.getNgaySinh() + "|" + nv.getGioiTinh() + "|" + nv.getSDTNV() + "|" + nv.getDiaChiNV() + "|" + nv.getLuongNV();
                    pw.println(line);
                }
            }
            System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG: ");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
