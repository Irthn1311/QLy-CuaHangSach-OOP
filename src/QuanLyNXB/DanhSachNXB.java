package QuanLyNXB;

import java.io.*;
import java.util.Scanner;
import Interface.CRUD;

public class DanhSachNXB implements CRUD {
    private NhaXuatBan[] NXB;
    private int size;
    private Scanner sc; 

    public DanhSachNXB(int n) {
        NXB = new NhaXuatBan[n];
        size = 0;
        sc = new Scanner(System.in); 
    }

   @Override
    public void xem() {
        if (size == 0) {
            System.out.print("\nDanh sach trong!");
        } else {
            for (int i = 0; i < size; i++) {
                if (NXB[i] != null) {
                    System.out.print("\nThong tin nha xuat ban: ");
                    NXB[i].xuatNXB();
                }
            }
        }
    }

    @Override
    public void them() {
        System.out.print("\nNhap so luong NXB can them: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            if (size < NXB.length) {
                NXB[size++] = new NhaXuatBan();
                NXB[size - 1].nhapNXB();
            } else {
                System.out.print("\nKhong the them NXB, mang da day!");
                break;
            }
        }
    } 

    @Override
    public void sua() {
        System.out.print("\nNhap ma NXB can sua: ");
        String maNXB = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (NXB[i] != null && NXB[i].getMaNXB().equals(maNXB)) {
                NXB[i].nhapNXB();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.print("\nKhong tim thay ma NXB!");
        }
    }

    @Override
    public void xoa() {
        System.out.print("\nNhap ma Nha Xuat Ban can xoa: ");
        String maNXB = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (NXB[i] != null && maNXB.equals(NXB[i].getMaNXB())) {
                NXB[i] = NXB[size - 1];
                NXB[size - 1] = null; 
                size--; 
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.print("\nMa khong tim thay!");
        }
    }

    @Override 
    public void timkiem() {
        while (true) {
            System.out.println("\n----------- Tim Kiem NXB -----------");
            System.out.println("1. Tim kiem theo Ma NXB");
            System.out.println("2. Tim kiem theo Ten NXB");
            System.out.println("3. Tim kiem theo Dia Chi NXB");
            System.out.println("4. Tim kiem theo SDT NXB");
            System.out.println("5. Tim kiem theo Email NXB");
            System.out.println("6. Quay lai menu chinh");
            System.out.println("\n----------------------------------------");
            System.out.print("Nhap su lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    timKiem("maNXB");
                    break;
                case 2:
                    timKiem("tenNXB");
                    break;
                case 3:
                    timKiem("diaChiNXB");
                    break;
                case 4:
                    timKiem("sdtNXB");
                    break;
                case 5:
                    timKiem("emailNXB");
                    break;
                case 6:
                    return; 
                default:
                    System.out.println("Loi lua chon! Vui long chon lai.");
            }
        }
    }

    public void timKiem(String type) {
        String searchValue;
        switch (type) {
            case "maNXB":
                System.out.print("\nNhap ma NXB can tim: ");
                searchValue = sc.nextLine();
                break;
            case "tenNXB":
                System.out.print("\nNhap ten NXB can tim: ");
                searchValue = sc.nextLine();
                break;
            case "diaChiNXB":
                System.out.print("\nNhap dia chi NXB can tim: ");
                searchValue = sc.nextLine();
                break;
            case "sdtNXB":
                System.out.print("\nNhap SDT NXB can tim: ");
                searchValue = sc.nextLine();
                break;
            case "emailNXB":
                System.out.print("\nNhap email NXB can tim: ");
                searchValue = sc.nextLine();
                break;
            default:
                return;
        }

        boolean found = false;
        for (NhaXuatBan nxb : NXB) {
            if (nxb != null) { 
                switch (type) {
                    case "maNXB":
                        if (nxb.getMaNXB().equals(searchValue)) {
                            found = true;
                            break; 
                        }
                        break;
                    case "tenNXB":
                        if (nxb.getTenNXB().equalsIgnoreCase(searchValue)) {
                            found = true;
                            break;
                        }
                        break;
                    case "diaChiNXB":
                        if (nxb.getDiaChiNXB().equalsIgnoreCase(searchValue)) {
                            found = true;
                            break; 
                        }
                        break;
                    case "sdtNXB":
                        if (nxb.getSdtNXB().equals(searchValue)) {
                            found = true;
                            break; 
                        }
                        break;
                    case "emailNXB":
                        if (nxb.getEmail().equalsIgnoreCase(searchValue)) {
                            found = true;
                            break;
                        }
                        if (found) {
                            System.out.println("\nThong tin NXB: ");
                            nxb.xuatNXB();
                            break; 
                }
            }
        }
        if (!found) {
            System.out.println("Khong tim thay NXB voi gia tri: " + searchValue);
        }
    }
}
    @Override
    public void thongke(){
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.print("\n===============ThongkeNXB=================");
        System.out.print("\n1.Liet ke nhung Nha Xuat Ban o HCM");
        System.out.print("\n2.Moi nha xuat dieu co ma duy nhat hay khong");
        System.out.print("\n==========================================");
        System.out.print("\nNhap sua lua chon cua ban: ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                
                break;
        
            default:
                break;
        }
     }
        
    }
    @Override
    public void docFile() {
        
        File file = new File("C:\\Users\\ACER\\OneDrive\\文档\\POOP\\QLy-CuaHangSach-OOP\\data\\n" + //
                        "xb.txt");
        System.out.print("\nFile: "+file.exists());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                if (info.length == 5) {
                    String maNXB = info[0].trim();
                    String tenNXB = info[1].trim();
                    String diaChiNXB = info[2].trim();
                    String SDTNXB = info[3].trim();
                    String email = info[4].trim();
                    NhaXuatBan nxb = new NhaXuatBan(maNXB, tenNXB, diaChiNXB, SDTNXB, email);
                    NXB[size++] = nxb; 
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print("\nFile khong tim thay!" + e);
        } catch (IOException e) {
            System.out.println("\nError reading file: " + e);
        }
    }

    @Override
    public void ghiFile() {
        File file = new File("C:\\Users\\ACER\\OneDrive\\文档\\POOP\\QLy-CuaHangSach-OOP\\data\\n" + //
                        "xb.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < size; i++) {
                if (NXB[i] != null) {
                    bw.write(NXB[i].getMaNXB() + "," + NXB[i].getTenNXB() + "," +
                             NXB[i].getDiaChiNXB() + "," + NXB[i].getSdtNXB() + "," +
                             NXB[i].getEmail());
                    bw.newLine();
                }
            }
            System.out.println("\nData saved to file successfully!");
        } catch (IOException e) {
            System.out.println("\nError writing to file: " + e);
        }
    }

    public void Menu() {
        docFile();
        while (true) {
            System.out.print("\n-------------MenuOfNXB-------------------");
            System.out.print("\n1. Xem danh sach nha xuat ban");
            System.out.print("\n2. Them vao danh sach nha xuat ban");
            System.out.print("\n3. Sua trong danh sach nha xuat ban");
            System.out.print("\n4. Xoa trong danh sach nha xuat ban");
            System.out.print("\n5. Tim kiem trong danh sach nha xuat ban");
            System.out.print("\n6.Thong ke Nha Xuat Ban");
            System.out.print("\n7.Ghi vao file nhung thong tin vua nhap");
            System.out.print("\n8. Thoat menu!");
            System.out.print("\n-----------------------------------------");
            System.out.print("\nNhap su lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    xem();
                    break;
                case 2:
                    them();
                    break;
                case 3:
                    sua();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    timkiem();
                    break;
                case 6:thongke();
                       break;
                case 7:ghiFile();
                break;
                case 8:
                    System.out.print("\nThoat menu NXB!");
                    ghiFile(); 
                    sc.close(); 
                default:
                    System.out.print("\nLoi lua chon!");
            }
        }
    }
}
