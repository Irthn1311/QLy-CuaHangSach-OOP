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
        String maSach = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < arrSach.length; i++) {
            if (arrSach[i] != null && arrSach[i].getMaSach().equals(maSach)) {
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

    public void timkiemMaSach(){
        System.out.print("Nhập mã sách cần tìm: ");
        String maSach = sc.nextLine();
        boolean found = false;

        for (Sach sach : arrSach) {
            if (sach != null && sach.getMaSach().equals(maSach)) {
                found = true;
                System.out.println("Thông tin sách tìm thấy:");
                System.out.println("Mã sách: " + sach.getMaSach());
                System.out.println("Tên sách: " + sach.getTenSach());
                System.out.println("Mã tác giả: " + sach.getMaTacGia());
                System.out.println("Mã NXB: " + sach.getMaNXB());
                System.out.println("Thể loại: " + sach.getTheLoai());
                System.out.println("Đơn giá bán: " + sach.getDonGiaBan());
                System.out.println("Số lượng sách hiện có: " + sach.getSoLuongSachHienCo());
                if (sach instanceof SachChuyenNganh) {
                    System.out.println("Môn chuyên ngành: " + ((SachChuyenNganh) sach).getMonChuyenNganh());
                } else if (sach instanceof SachThamKhao) {
                    System.out.println("Lĩnh vực: " + ((SachThamKhao) sach).getLinhVuc());
                    System.out.println("Độ tuổi: " + ((SachThamKhao) sach).getDoTuoi());
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách với mã đã nhập.");
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
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
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
            System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
        }
    }
}