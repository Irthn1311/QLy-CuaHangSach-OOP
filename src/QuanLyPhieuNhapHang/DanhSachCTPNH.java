package QuanLyPhieuNhapHang;
import QuanLyNXB.NhaXuatBan;
import QuanLySach.Sach;
import java.io.*;
import java.util.Scanner;
import Interface.CRUD;

public class DanhSachCTPNH implements CRUD {
    private ChiTietPhieuNhapHang[] listPNH;  
    private int size; 
    private Scanner sc;

    public DanhSachCTPNH() {
        this.size = 0;  
        this.listPNH = new ChiTietPhieuNhapHang[100];  
        this.sc = new Scanner(System.in);
    }
        public void menu(){
        int choice;
        do {
            System.out.println("\n===== Menu Phieu Nhap Hang =====");
            System.out.println("1. Xem Danh Sach Phieu Nhap Hang");
            System.out.println("2. Them Phieu Nhap Hang");
            System.out.println("3. Sua Phieu Nhap Hang");
            System.out.println("4. Xoa Phieu Nhap Hang");
            System.out.println("5. Tim Kiem Phieu Nhap Hang");
            System.out.println("6. Thong Ke Phieu Nhap Hang");
            System.out.println("0. Thoat");
            System.out.print("\n===============================");
            System.out.print("\nLua Chon Cua Ban: ");

            while (!sc.hasNextInt()) {
                System.out.println("Nhap sai! Vui long nhap lai.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1: xem(); break;
                case 2: them(); break;
                case 3: sua(); break;
                case 4: xoa(); break;
                case 5: timkiem(); break;
                case 6: thongke(); break;
                case 7: docFile(); break;
                case 8: ghiFile(); break;
                case 0: System.out.println("Thoat!"); break;
                default: System.out.println("Nhap sai! Vui long nhap lai."); break;
            }
        } while (choice != 0); 
        sc.close(); 
    }
@Override
    public void xem() {
        System.out.println("\nDanh Sach Phieu Nhap Hang:");
        if (size == 0) {
            System.out.println("Danh sach trong!");
        } else {
            for (int i = 0; i < size; i++) {
                if (listPNH[i] != null) {
                    listPNH[i].xuat();
                }
            }
        }
    }
@Override
    public void them() {
        ChiTietPhieuNhapHang newItem = new ChiTietPhieuNhapHang();
        newItem.nhap(); 
        listPNH[size] = newItem;  
        size++; 
        System.out.println("Phieu Nhap Hang moi da duoc them!");
    }

    public void sua() {
        System.out.print("\nNhap ma CTPNH can sua: ");
        String maCTPNH = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (listPNH[i] != null && listPNH[i].getMa_CTPNH().equals(maCTPNH)) {
                listPNH[i].nhap(); 
                found = true;
                System.out.println("Phieu Nhap Hang da duoc sua!");
                break;
            }
        }
        System.out.print("\n============SuaPNH================");
        System.out.print("\n1.Sua lai ma phieu nhap hang");
        System.out.print("\n2.Sua so luong nhap");
        System.out.print("\n3.Sua ");
        System.out.print("\n===================================");
        if (!found) {
            System.out.println("Khong tim thay Phieu Nhap Hang voi ma: " + maCTPNH);
        }
    }
   @Override
    public void xoa() {
        System.out.print("\nNhap ma CTPNH can xoa: ");
        String maCTPNH = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (listPNH[i] != null && listPNH[i].getMa_CTPNH().equals(maCTPNH)) {
                for (int j = i; j < size - 1; j++) {
                    listPNH[j] = listPNH[j + 1];
                }
                listPNH[size - 1] = null;  
                size--; 
                found = true;
                System.out.println("Phieu Nhap Hang da duoc xoa!");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay Phieu Nhap Hang voi ma: " + maCTPNH);
        }
    }
    @Override
    public void timkiem() {
        System.out.print("\nNhap ma CTPNH can tim: ");
        String maCTPNH = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (listPNH[i] != null && listPNH[i].getMa_CTPNH().equals(maCTPNH)) {
                listPNH[i].xuat();  
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay Phieu Nhap Hang voi ma: " + maCTPNH);
        }
    }
@Override
    public void thongke() {
        double totalValue = 0;
        for (int i = 0; i < size; i++) {
            if (listPNH[i] != null) {
                totalValue += listPNH[i].getThanhTien();  
            }
        }
        System.out.print("\n=================Bang thong ke==================");
        System.out.print("\n1.");
        System.out.print("\n");
        System.out.println("Tong gia tri cua tat ca phieu nhap hang: " + totalValue);
    }
@Override
    public void docFile() {
       File file=new File("ctpnh.txt");
       System.out.print("\nFile: "+file.exists());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); 
                if (parts.length < 4) {
                    System.out.println("Loi: Du lieu khong du cho mot phieu nhap hang. Line: " + line);
                    continue; 
                }

                ChiTietPhieuNhapHang newItem = new ChiTietPhieuNhapHang();
                newItem.setMa_CTPNH(parts[0].trim());  
                newItem.setMasACH_pnhsach(parts[1].trim());   
                newItem.setSoLuong_Nhap(Integer.parseInt(parts[2].trim())); 
                newItem.setDonGia_Nhap(Double.parseDouble(parts[3].trim())); 
                listPNH[size] = newItem;
                size++; 
            }
            System.out.println("Doc file thanh cong! Da them " + size + " phieu nhap hang.");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi: Du lieu khong hop le! " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi khong xac dinh: " + e.getMessage());
        }
    }
@Override
    public void ghiFile() {
        System.out.print("Nhap ten file de ghi: ");
        String filename = sc.nextLine();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < size; i++) {
                if (listPNH[i] != null) {
                    bw.write(listPNH[i].toString()); 
                    bw.newLine();
                }
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

}