package QuanLySach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



import Interface.CRUD;

public class dsSach implements CRUD {
    Sach[] arrSach = new Sach[10];
    @SuppressWarnings("resource")
    Scanner sc=new Scanner(System.in);

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

    public void them() {
        Sach sach = null;
        String theLoai = "";
        int option;
        do {
            System.out.println("Hay chon the loai sach ma ban muon them: ");
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
                    return;
                default:
                    System.out.print("Nhap sai! Vui long nhap lai.");
                    break;
            }
        } while (option != 1 && option != 2 && option != 3 && option != 0);
        sach.setTheLoai(theLoai);
        sach.nhap();
        arrSach = Arrays.copyOf(arrSach, arrSach.length + 1);
        arrSach[arrSach.length - 1] = sach;
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma sach can sua: ");
        String maSach = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < arrSach.length; i++) {
            if (arrSach[i] != null && arrSach[i].getMaSach().equals(maSach)) {
                found = true;
                arrSach[i].sua();
                System.out.println("Sua sach thanh cong.");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sach voi ma da nhap.");
        }
    }

    @Override
    public void xoa() {
        System.out.print("Nhap ma sach can xoa: ");
        String maSach = sc.nextLine().toLowerCase().trim();
        boolean found = false;

        for (int i = 0; i < arrSach.length; i++) {
            if (arrSach[i] != null && arrSach[i].getMaSach().toLowerCase().contains(maSach)) {
                found = true;
                for (int j = i; j < arrSach.length - 1; j++) {
                    arrSach[j] = arrSach[j + 1];
                }
                arrSach = Arrays.copyOf(arrSach, arrSach.length - 1);
                System.out.println("Xoa sach thanh cong.");
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sach voi ma da nhap.");
        }
    }

    public void timkiem() {
        int find;
        do {
            System.out.println("\nLua Chon Tim Kiem:");
            System.out.println("1. Tim Kiem Theo Ma Sach");
            System.out.println("2. Tim Kiem Theo Ten Sach");
            System.out.println("3. Tim Kiem Theo Tac Gia");
            System.out.println("4. Tim Kiem Nang Cao Sach Tham Khao Trong Khoang Gia Ban");
            System.out.println("0. Thoat");
            System.out.print("Lua Chon Cua Ban: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    timkiemMaSach();
                    break;
                case 2:
                    timkiemTenSach();
                    break;
                case 3:
                    timkiemMaTacGia();
                    break;
                case 4:
                    timkiemNCGiaBan();
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

    public void timkiemMaSach(){
        System.out.print("Nhap ma sach can tim: ");
        String maSach = sc.nextLine().toLowerCase().trim();
        boolean found = false;

        for (Sach sach : arrSach) {
            if (sach != null && sach.getMaSach().toLowerCase().contains(maSach)) {
                found = true;
                sach.xuat();
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sach voi ma da nhap.");
        }
    }
    public void timkiemTenSach(){
        System.out.print("Nhap ten sach can tim: ");
        String tenSach = sc.nextLine().toLowerCase().trim();
        boolean found = false;

        for (Sach sach : arrSach) {
            if (sach != null && sach.getTenSach().toLowerCase().contains(tenSach)) {
                found = true;
                sach.xuat();
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sach voi ten da nhap.");
        }
    }
    public void timkiemMaTacGia(){
        System.out.print("Nhap ma tac gia can tim: ");
        String maTacGia = sc.nextLine().toLowerCase().trim();
        boolean found = false;

        for (Sach sach : arrSach){
            if (sach != null && sach.getMaTacGia().toLowerCase().contains(maTacGia)){
                found = true;
                sach.xuat();
            }
        }

        if (!found){
            System.out.println("Khong tim thay sach voi ma tac gia da nhap.");
        }
    }
    public void timkiemNCGiaBan(){
        System.out.print("\nNhap Don Gia Ban Toi Thieu: ");
        double giaMin = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap Don Gia Ban Toi Da: ");
        double giaMax = sc.nextDouble();
        sc.nextLine();

        if (giaMin > giaMax) {
            System.out.println("Gia toi thieu khong duoc lon hon gia toi da. Vui long nhap lai.");
            return;
        }

        boolean found = false;

        for (Sach sach : arrSach) {
            if (sach != null) {
                double giaBan = sach.getDonGiaBan();
                if (giaMin <= giaBan && giaBan <= giaMax) {
                    sach.xuat();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("\nKhong Tim Thay Sach Voi Don Gia Ban Trong Khoang " + giaMin + " => " + giaMax);
        }
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
        System.out.print("\nNhap Moc Gia Tien Can Thong Ke: ");
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
        try (BufferedReader br = new BufferedReader(new FileReader("data/sach.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Sach sach;
                String maSach = data[0];
                String tenSach = data[1];
                String maTacGia = data[2];
                String maNXB = data[3];
                String theLoai = data[4];
                double donGiaBan = Double.parseDouble(data[5]);
                int soLuongSachHienCo = Integer.parseInt(data[6]);

                switch (theLoai) {
                    case "Chuyen Nganh":
                        sach = new SachChuyenNganh();
                        ((SachChuyenNganh) sach).setMonChuyenNganh(data[7]);
                        break;
                    case "Tham Khao":
                        sach = new SachThamKhao();
                        ((SachThamKhao) sach).setLinhVuc(data[8]);
                        ((SachThamKhao) sach).setDoTuoi(Integer.parseInt(data[9]));
                        break;
                    default:
                        sach = new Sach();
                        break;
                }

                sach.setMaSach(maSach);
                sach.setTenSach(tenSach);
                sach.setMaTacGia(maTacGia);
                sach.setMaNXB(maNXB);
                sach.setTheLoai(theLoai);
                sach.setDonGiaBan(donGiaBan);
                sach.setSoLuongSachHienCo(soLuongSachHienCo);

                arrSach = Arrays.copyOf(arrSach, arrSach.length + 1);
                arrSach[arrSach.length - 1] = sach;
            }
        } catch (IOException e) {
            System.out.println("Da Xay Ra Loi Khi Doc File: " + e.getMessage());
        }
    }
    
    @Override
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/sach.txt"))) {
            for (Sach sach : arrSach) {
                if (sach != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sach.getMaSach()).append(",");
                    sb.append(sach.getTenSach()).append(",");
                    sb.append(sach.getMaTacGia()).append(",");
                    sb.append(sach.getMaNXB()).append(",");
                    sb.append(sach.getTheLoai()).append(",");
                    sb.append(sach.getDonGiaBan()).append(",");
                    sb.append(sach.getSoLuongSachHienCo()).append(",");

                    if (sach instanceof SachChuyenNganh) {
                        sb.append(((SachChuyenNganh) sach).getMonChuyenNganh()).append(",");
                    } else if (sach instanceof SachThamKhao) {
                        sb.append(",").append(((SachThamKhao) sach).getLinhVuc()).append(",");
                        sb.append(((SachThamKhao) sach).getDoTuoi()).append(",");
                    } else {
                        sb.append(",,");
                    }

                    bw.write(sb.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Da Xay Ra Loi Khi Ghi File: " + e.getMessage());
        }
    }
}