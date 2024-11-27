package QuanLySach;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import Interface.CRUD;

public class dsSach implements CRUD {
    Sach[] arrSach = new Sach[10];
    @SuppressWarnings("resource")
    Scanner sc=new Scanner(System.in);

    public dsSach(){
        arrSach[0] = new Sach("S001", "Luoc Su Loai Nguoi","TG001","NXB001","Lich Su va Triet Hoc",13000.0,100);
        arrSach[1] = new SachThamKhao("S002", "Dac Nhan Tam","TG002","NXB001","Ky Nang Song",15000.0,87,"Ky Nang Xa Hoi,Tam Ly Hoc, Lanh Dao Va Quan Ly",16);
        arrSach[2] = new SachChuyenNganh("S003", "Giai Tich","TG003","NXB002","Toan Hoc Va Giai Tich",20000.0,99,"Toan Hoc");
    }

    @Override
    public void xem() {
        boolean checks=false;
        System.out.print("\nThong Tin Sach");
        for(Sach s: arrSach){
            if( s !=null){
                s.xuat();
                checks=true;
            }
        }
        if(!checks){
            System.out.print("\nKhong co quyen sach nào trong danh sach!!!");
        }
    }

//     @Override
//     public void them(){
//         Sach sach;
//         String theLoai;
//         int option;
//         System.out.println("Hay chon the loai sach ma ban muon nhap: ");
//         System.out.println("1. Sach Chuyen Nganh");
//         System.out.println("2. Sach Tham Khao");
//         System.out.println("3. Cac the loai sach khac");
//         System.out.print("Chon lua cua ban: ");
//         option = sc.nextInt();
//     do {
//         if (option == 1) {
//             sach = new SachChuyenNganh();
//             theLoai = "Chuyen Nganh";
//             break;
//         } else if (option == 2) {
//             sach = new SachThamKhao();
//             theLoai = "Tham Khao";
//             break;
//         } else if (option == 3) {
//             sach = new Sach();
//             System.out.print("Hay nhap the loai sach: ");
//             theLoai = sc.nextLine();
//             break;
//         }
//         System.out.print("Nhap sai! Vui long nhap lai.");
//     } while (option != 1 && option != 2 && option != 3);



// }




    public void them() {
        Sach sach = null;
        String theLoai = "";
        int option;
        do {
            System.out.println("Hay chon the loai sach ma ban muon nhap: ");
            System.out.println("1. Sach Chuyen Nganh");
            System.out.println("2. Sach Tham Khao");
            System.out.println("3. Cac the loai sach khac");
            System.out.println("0. Thoat");
            System.out.print("Chon lua cua ban: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1: 
                    sach = new SachChuyenNganh();
                    theLoai = "Chuyen Nganh";
                    break;
                case 2:
                    sach = new SachThamKhao();
                    theLoai = "Tham Khao";
                    break;
                case 3:
                    sach = new Sach();
                    System.out.print("Hay nhap the loai sach: ");
                    theLoai = sc.nextLine();
                    break;
                case 0:
                    System.out.print("Thoat thanh cong.");
                    break;
                default:
                    System.out.print("Nhap sai! Vui long nhap lai.");
                    break;
            }
        } while (option != 1 && option != 2 && option != 3 && option != 0);
        sach.setTheLoai(theLoai);
        sach.nhap();
        arrSach = Arrays.copyOf(arrSach, arrSach.length + 1);
        arrSach[arrSach.length] = sach;
    }

    @Override
    public void sua() {
        boolean bookFound=false;
        System.out.print("\nNhap Ma Sach Can Sua: ");
        String checked = sc.nextLine();
        for(Sach s: arrSach){
            if(s !=null && checked.equals(s.getMaSach())){
                s.nhap();
                bookFound=true;
                break;
            }
        }
        if (!bookFound) {
            System.out.print("\nKHONG TIM THAY MA SACH: "+checked);
        } else {
            System.out.print("\nCHINH SUA THONG TIN SACH THANH CONG!!!");
        } 
    }

    @Override
    public void xoa(){
        boolean bookFound=false;
        System.out.print("\nNhap Ma Sach Can Xoa: ");
        String checked=sc.nextLine();
        for(int i=0;i<arrSach.length;i++){
            if(arrSach[i]!=null && checked.equals(arrSach[i].getMaSach())){
                arrSach = Array.removeOf(arrSach, i);
                arrSach[i]=null;
                bookFound=true;
                size--;
                break;
            }
        }
        if (!bookFound) {
            System.out.print("\nKHONG TIM THAY MA SACH: "+checked);
        } else {
            System.out.print("\nXOA THONG TIN SACH THANH CONG!!!");
        } 
    }   

    public void timkiem() {
        int find;
        do {
            System.out.println("\nLua Chọn Tìm Kiếm:");
            System.out.println("1. Tim Kiem Theo Ma Sach");
            System.out.println("2. Tim Kiem Theo Ten Sach");
            System.out.println("3. Tim Kiem Theo Tac Gia");
            System.out.println("0. Thoat");
            System.out.print("Lua Chon Cua Ban: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    boolean bookFound1 = false;
                    System.out.print("\nNhap Ma Sach Can Tim Kiem: ");
                    String checked1 = sc.nextLine();
                    for (int i = 0; i < arrSach.length; i++) {
                        if (arrSach[i] != null && checked1.equals(arrSach[i].getMaSach())) {
                            arrSach[i].xuat();
                            bookFound1 = true;
                            break;
                        }
                    }
                    if (!bookFound1) {
                        System.out.println("\nKhong Tim Thấy Ma Sach: " + checked1);
                    }
                    break;
                case 2:
                    boolean bookFound2 = false;
                    System.out.print("\nNhap Ten Sach Can Tim Kiem: ");
                    String checked2 = sc.nextLine().toLowerCase();
                    for (int i = 0; i < arrSach.length; i++) {
                        if (arrSach[i] != null && arrSach[i].getTenSach().toLowerCase().contains(checked2)) {
                            arrSach[i].xuat();
                            bookFound2 = true;
                        }
                    }
                    if (!bookFound2) {
                        System.out.println("\nKhong Tim Thay Ten Sach: " + checked2);
                    }
                    break;
                case 3:
                    boolean bookFound3 = false;
                    System.out.print("\nNhap Ma Tac Gia Can Tim Kiem: ");
                    String checked3 = sc.nextLine().toLowerCase();
                    for (int i = 0; i < arrSach.length; i++) {
                        if (arrSach[i] != null && arrSach[i].getMaTacGia().toLowerCase().contains(checked3)) {
                            arrSach[i].xuat();
                            bookFound3 = true;
                        }
                    }
                    if (!bookFound3) {
                        System.out.println("\nKhong Tim Thay Tac Gia: " + checked3);
                    }
                    break;
                case 0:
                    System.out.println("Thoat thanh cong.");
                    break;
                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (find != 0);
    }


    public void thongke() {
        int choice;
        do {
            System.out.println("\nLua Chon Thong Ke:");
            System.out.println("1. Thong Ke So Luong Sach Theo The Loai");
            System.out.println("2. Thong Ke So Luong Sach Theo Tac Gia");
            System.out.println("3. Thong Ke So Luong Sach Theo Nha Xuat Ban");
            System.out.println("4. Thong Ke So Luong Sach Theo Gia Ban");
            System.out.println("0. Thoat");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    thongkeTheLoai();
                    break;
                case 2:
                    thongkeTacGia();
                    break;
                case 3:
                    thongkeNXB();
                    break;
                case 4:
                    thongkeGiaTien();
                    break;
                case 0:
                    System.out.println("Thoat thanh cong.");
                    break;
                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (choice != 0);
    }

    public void thongkeTheLoai() {
        String[] theloai= new String[100];
                    int[] soluongTL=new int[100];
                    int visitTL=0;
                    for(int i=0;i<arrSach.length;i++){
                        if (arrSach[i]!=null){
                            boolean find=false;
                            for (int j=0;j<visitTL;j++){
                                if(arrSach[i].getTheLoai().equalsIgnoreCase(theloai[j])){
                                    soluongTL[j]++;
                                    find=true;
                                    break;
                                }
                            }
                            if(!find){
                                theloai[visitTL]=arrSach[i].getTheLoai();
                                soluongTL[visitTL]=1;
                                visitTL++;
                            }
                        }
                    }
                    System.out.println("\nThong Ke So Luong Sach Theo The Loai:");
                    for (int i = 0; i < visitTL; i++) {
                        System.out.println(theloai[i] + ": " + soluongTL[i]);
                    }
    }

    public void thongkeTacGia() {
        String[] tacgia = new String[100];
                    int[] soluongTG = new int[100];
                    int visitTG = 0;
                    for (int i = 0; i < arrSach.length; i++) {
                        if(arrSach[i] !=null){
                            boolean find = false;
                            for (int j = 0; j < visitTG; j++) {
                                if (arrSach[i]!=null && arrSach[i].getMaTacGia().equalsIgnoreCase(tacgia[j])) {
                                    soluongTG[j]++;
                                    find = true;
                                    break;
                                }
                            }
                            if (!find) {
                                tacgia[visitTG] = arrSach[i].getMaTacGia();
                                soluongTG[visitTG] = 1;
                                visitTG++;
                            }
                        }
                    }
                    System.out.println("\nThong Ke So Luong Sach Theo Tac Gia:");
                    for (int i = 0; i < visitTG; i++) {
                        System.out.println(tacgia[i] + ": " + soluongTG[i]);
                    }
    }

    public void thongkeNXB() {
        String[] nxb = new String[100];
                    int[] soLuongNXB = new int[100];
                    int visitNXB = 0;
                    for (int i = 0; i < arrSach.length; i++) {
                        if(arrSach[i]!=null){
                            boolean find = false;
                            for (int j = 0; j < visitNXB; j++) {
                                if (arrSach[i]!=null && arrSach[i].getMaNXB().equalsIgnoreCase(nxb[j])) {
                                    soLuongNXB[j]++;
                                    find = true;
                                    break;
                                }
                            }
                            if (!find) {
                                nxb[visitNXB] = arrSach[i].getMaNXB();
                                soLuongNXB[visitNXB] = 1;
                                visitNXB++;
                            }
                        }
                    }
                    System.out.println("\nThong Ke So Luong Sach Theo Nha Xuat Ban:");
                    for (int i = 0; i < visitNXB; i++) {
                        System.out.println(nxb[i] + ": " + soLuongNXB[i]);
                    }
    }

    public void thongkeGiaTien(){
        System.out.print("\nNhap Gia Tien Can Thong Ke: ");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    int countOver = 0;
                    int countUnder = 0;
                    for (int i = 0; i < arrSach.length; i++) {
                        if(arrSach[i] !=null){
                            if (arrSach[i].getDonGiaBan() > x) {
                                countOver++;
                            }
                            if (arrSach[i].getDonGiaBan() < x) {
                                countUnder++;
                            }
                        }    
                    }
                    System.out.println("\nSo Luong Sach Co Gia Tren " + x + ": " + countOver);
                    System.out.println("So Luong Sach Co Gia Duoi " + x + ": " + countUnder);
    }
    

    @Override
    public void docFile() {
        File readf = new File("data/sach.txt");
        try {
            if (!readf.exists()) {
                System.out.print("FILE MOI DA DUOC TAO");
                readf.createNewFile();
            }
            try (BufferedReader br = Files.newBufferedReader(readf.toPath(), StandardCharsets.UTF_8)) {
                boolean empty = true;
                String line;
                while ((line = br.readLine()) != null) {
                    empty = false;
                    String[] info = line.split("\\|");
                    if (info.length >= 7) {
                        String maSach = info[0].trim();
                        String tenSach = info[1].trim();
                        String maTacGia = info[2].trim();
                        String maNXB = info[3].trim();
                        String theLoai = info[4].trim();
                        Double donGiaBan = Double.parseDouble(info[5].trim());
                        int soLuongSachHienCo = Integer.parseInt(info[6].trim());
    
                        Sach sach;
                        if (theLoai.equalsIgnoreCase("Chuyen Nganh")) {
                            String monChuyenNganh = info[7].trim();
                            sach = new SachChuyenNganh(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo, monChuyenNganh);
                        } else if (theLoai.equalsIgnoreCase("Tham Khao")) {
                            String linhVuc = info[7].trim();
                            int doTuoi = Integer.parseInt(info[8].trim());
                            sach = new SachThamKhao(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo, linhVuc, doTuoi);
                        } else {
                            sach = new Sach(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo);
                        }
    
                        if (size == arrSach.length) {
                            Sach[] newRun = new Sach[arrSach.length + 1];
                            for (int j = 0; j < arrSach.length; j++) {
                                if (arrSach[j] != null) {
                                    newRun[j] = arrSach[j];
                                }
                            }
                            arrSach = newRun;
                        }
    
                        arrSach[size] = sach;
                        size++;
                    } else {
                        System.out.println("Dữ liệu không hợp lệ: " + line);
                    }
                }
    
                if (empty) {
                    System.out.println("\nFILE RONG");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void ghiFile() {
        try {
            PrintWriter pw=new PrintWriter("data/sach.txt");
            for(Sach s:arrSach){
                String line=s.getMaSach() + " | " + s.getTenSach() + " | " + s.getMaTacGia() + " | " + s.getMaNXB() + " | "
                + s.getTheLoai() + " | " + s.getDonGiaBan() + " | " + s.getSoLuongSachHienCo();
                pw.println(line);
            }            
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}