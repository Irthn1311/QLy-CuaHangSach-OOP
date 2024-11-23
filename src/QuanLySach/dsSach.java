package QuanLySach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Interface.CRUD;

public class DSSach implements CRUD {
    private Sach[] dsSach = new Sach[100];
    private int soLuong = 0;

    @Override
    public void them() {
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        if (soLuong >= dsSach.length) {
            System.out.println("Danh sách sách đã đầy!");
            return;
        }
        System.out.println("Thể loại sách: ");
        String theLoai = sc.nextLine();

        Sach sach;
        if (theLoai.equalsIgnoreCase("Chuyen Nganh")) {
            sach = new SachChuyenNganh();
        } else if (theLoai.equalsIgnoreCase("Tham Khao")) {
            sach = new SachThamKhao();
        } else {
            sach = new Sach();
        }
		sach.setTheLoai(theLoai);
        sach.nhap();
        dsSach[soLuong++] = sach;
        System.out.println("Thêm sách thành công!");
    }

    @Override
    public void xem() {
        if (soLuong > 0) {
            for (int i = 0; i < soLuong; i++) {
                dsSach[i].xuat();
                System.out.println("\n");
            }
        } else {
            System.out.println("\nKhông có quyền sách nào trong danh sách!!!");
        }
    }

    @Override
    public void thongke() {
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLựa Chọn Thống Kê:");
            System.out.println("1. Thống Kê Số Lượng Sách Theo Thể Loại");
            System.out.println("2. Thống Kê Số Lượng Sách Theo Tác Giả");
            System.out.println("3. Thống Kê Số Lượng Sách Theo Nhà Xuất Bản");
            System.out.println("4. Thống Kê Số Lượng Sách Theo Giá Bán");
            System.out.println("0. Thoát");
            System.out.print("\nLua Chọn Của Bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    String[] theLoaiCount = new String[100];
                    int[] countTheLoai = new int[100];
                    int countTL = 0;
                    for (int i = 0; i < soLuong; i++) {
                        boolean found = false;
                        for (int j = 0; j < countTL; j++) {
                            if (dsSach[i].getTheLoai().equalsIgnoreCase(theLoaiCount[j])) {
                                countTheLoai[j]++;
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            theLoaiCount[countTL] = dsSach[i].getTheLoai();
                            countTheLoai[countTL] = 1;
                            countTL++;
                        }
                    }
                    System.out.println("\nThống Kê Số Lượng Sách Theo Thể Loại:");
                    for (int i = 0; i < countTL; i++) {
                        System.out.println(theLoaiCount[i] + ": " + countTheLoai[i]);
                    }
                    break;
                case 2:
                    String[] tacGiaCount = new String[100];
                    int[] countTacGia = new int[100];
                    int countTG = 0;
                    for (int i = 0; i < soLuong; i++) {
                        boolean found = false;
                        for (int j = 0; j < countTG; j++) {
                            if (dsSach[i].getMaTacGia().equalsIgnoreCase(tacGiaCount[j])) {
                                countTacGia[j]++;
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            tacGiaCount[countTG] = dsSach[i].getMaTacGia();
                            countTacGia[countTG] = 1;
                            countTG++;
                        }
                    }
                    System.out.println("\nThống Kê Số Lượng Sách Theo Tác Giả:");
                    for (int i = 0; i < countTG; i++) {
                        System.out.println(tacGiaCount[i] + ": " + countTacGia[i]);
                    }
                    break;
                case 3:
                    String[] nxbCount = new String[100];
                    int[] countNXB = new int[100];
                    int countNxb = 0;
                    for (int i = 0; i < soLuong; i++) {
                        boolean found = false;
                        for (int j = 0; j < countNxb; j++) {
                            if (dsSach[i].getMaNXB().equalsIgnoreCase(nxbCount[j])) {
                                countNXB[j]++;
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            nxbCount[countNxb] = dsSach[i].getMaNXB();
                            countNXB[countNxb] = 1;
                            countNxb++;
                        }
                    }
                    System.out.println("\nThống Kê Số Lượng Sách Theo Nhà Xuất Bản:");
                    for (int i = 0; i < countNxb; i++) {
                        System.out.println(nxbCount[i] + ": " + countNXB[i]);
                    }
                    break;
                case 4:
                    System.out.print("\nNhập Giá Tiền Cần Thống Kê: ");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    int countOver = 0;
                    int countUnder = 0;
                    for (int i = 0; i < soLuong; i++) {
                        if (dsSach[i].getDonGiaBan() > x) {
                            countOver++;
                        }
                        if (dsSach[i].getDonGiaBan() < x) {
                            countUnder++;
                        }
                    }
                    System.out.println("\nSố Lượng Sách Có Giá Trên " + x + ": " + countOver);
                    System.out.println("Số Lượng Sách Có Giá Dưới " + x + ": " + countUnder);
                    break;
                case 0:
                    System.out.println("Thoát thành công.");
                    break;
                default:
                    System.out.println("\nNhập Sai! Vui Lòng Nhập Lại.");
                    break;
            }
        } while (choice != 0);
    }

    @Override
    public void timkiem() {
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int find;
        do {
            System.out.println("\nLua Chọn Tìm Kiếm:");
            System.out.println("1. Tìm Kiếm Theo Mã Sách");
            System.out.println("2. Tìm Kiếm Theo Tên Sách");
            System.out.println("3. Tìm Kiếm Theo Tác Giả");
            System.out.println("0. Thoát");
            System.out.print("Lua Chọn Của Bạn: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    boolean bookFound1 = false;
                    System.out.print("\nNhập Mã Sách Cần Tìm Kiếm: ");
                    String checked1 = sc.nextLine();
                    for (int i = 0; i < soLuong; i++) {
                        if (dsSach[i] != null && checked1.equals(dsSach[i].getMaSach())) {
                            dsSach[i].xuat();
                            bookFound1 = true;
                            break;
                        }
                    }
                    if (!bookFound1) {
                        System.out.println("\nKhông Tìm Thấy Mã Sách: " + checked1);
                    }
                    break;
                case 2:
                    boolean bookFound2 = false;
                    System.out.print("\nNhập Tên Sách Cần Tìm Kiếm: ");
                    String checked2 = sc.nextLine().toLowerCase();
                    for (int i = 0; i < soLuong; i++) {
                        if (dsSach[i] != null && dsSach[i].getTenSach().toLowerCase().contains(checked2)) {
                            dsSach[i].xuat();
                            bookFound2 = true;
                        }
                    }
                    if (!bookFound2) {
                        System.out.println("\nKhông Tìm Thấy Tên Sách: " + checked2);
                    }
                    break;
                case 3:
                    boolean bookFound3 = false;
                    System.out.print("\nNhập Tác Giả Cần Tìm Kiếm: ");
                    String checked3 = sc.nextLine().toLowerCase();
                    for (int i = 0; i < soLuong; i++) {
                        if (dsSach[i] != null && dsSach[i].getMaTacGia().toLowerCase().contains(checked3)) {
                            dsSach[i].xuat();
                            bookFound3 = true;
                        }
                    }
                    if (!bookFound3) {
                        System.out.println("\nKhông Tìm Thấy Tác Giả: " + checked3);
                    }
                    break;
                case 0:
                    System.out.println("Thoát thành công.");
                    break;
                default:
                    System.out.println("\nNhập Sai! Vui Lòng Nhập Lại.");
                    break;
            }
        } while (find != 0);
    }

    @Override
    public void sua() {
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean bookFound = false;
        System.out.print("\nNhập Mã Sách Cần Sửa: ");
        String checked = sc.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (dsSach[i] != null && checked.equals(dsSach[i].getMaSach())) {
                dsSach[i].nhap();
                bookFound = true;
                System.out.println("\nChỉnh Sửa Thông Tin Sách Thành Công!!!");
                break;
            }
        }
        if (!bookFound) {
            System.out.print("\nKhông Tìm Thấy Mã Sách: " + checked);
        }
    }

    @Override
    public void docFile() {
		String fileName = "sach.txt";
        try (BufferedReader br = new BufferedReader(new FileReader("data/" + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                String maSach = info[0].trim();
                String tenSach = info[1].trim();
                String maTacGia = info[2].trim();
                String maNXB = info[3].trim();
                String theLoai = info[4].trim();
                double donGiaBan = Double.parseDouble(info[5].trim());
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
                dsSach[soLuong++] = sach;
            }
            System.out.println("Đọc file thành công!");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void ghiFile() {
		String fileName = "sach.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/" + fileName))) {
            for (int i = 0; i < soLuong; i++) {
                if (dsSach[i] != null) {
                    bw.write(dsSach[i].getMaSach() + "|" + dsSach[i].getTenSach() + "|" + dsSach[i].getMaTacGia() + "|" +
                             dsSach[i].getMaNXB() + "|" + dsSach[i].getTheLoai() + "|" + dsSach[i].getDonGiaBan() + "|" +
                             dsSach[i].getSoLuongSachHienCo());
                    if (dsSach[i] instanceof SachChuyenNganh) {
                        bw.write("|" + ((SachChuyenNganh) dsSach[i]).getMonChuyenNganh());
                    } else if (dsSach[i] instanceof SachThamKhao) {
                        bw.write("|" + ((SachThamKhao) dsSach[i]).getLinhVuc() + "|" + ((SachThamKhao) dsSach[i]).getDoTuoi());
                    } else {
                        bw.write("| |0");
                    }
                    bw.write("\n");
                }
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void xoa() {
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean bookFound = false;
        System.out.print("\nNhập Mã Sách Cần Xóa: ");
        String checked = sc.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (dsSach[i] != null && checked.equals(dsSach[i].getMaSach())) {
                dsSach[i] = dsSach[soLuong - 1];
                dsSach[soLuong - 1] = null;
                soLuong--;
                bookFound = true;
                System.out.println("\nXóa Thông Tin Sách Thành Công!!!");
                break;
            }
        }
        if (!bookFound) {
            System.out.print("\nKhông Tìm Thấy Mã Sách: " + checked);
        }
    }
}