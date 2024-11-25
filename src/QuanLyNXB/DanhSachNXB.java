package QuanLyNXB;

import java.io.*;
import java.util.Scanner;

public class DanhSachNXB {
    private NhaXuatBan[] NXB;
    private int size;

    public DanhSachNXB(int n) {
        NXB = new NhaXuatBan[n];
        size = 0;
    }

    public void Xem() {
        if (size == 0) {
            System.out.print("\nDanh sach trong!");
        } else {
            for (NhaXuatBan nxb : NXB) {
                if (nxb != null) {
                    System.out.print("\nThong tin nha xuat ban: ");
                    nxb.xuatNXB();
                }
            }
        }
    }

    public void Them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap so luong NXB can them: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            NXB[size++] = new NhaXuatBan();
            NXB[size - 1].nhapNXB();
        }
    }

    public void Sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ma NXB can sua: ");
        String maNXB = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (NXB[i].getMaNXB().equals(maNXB)) {
                NXB[i].nhapNXB();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.print("\nKhong tim thay ma NXB!");
        }
    }

    public void Xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ma Nha Xuat Ban can xoa: ");
        String maNXB = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (NXB[i] != null && maNXB.equals(NXB[i].getMaNXB())) {
                NXB[i] = null;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.print("\nMa khong tim thay!");
        }
    }

    public void TimKiem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ma NXB can tim: ");
        String maNXB = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (NXB[i] != null && NXB[i].getMaNXB().equals(maNXB)) {
                System.out.print("\nThong tin NXB: ");
                NXB[i].xuatNXB();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.print("\nKhong tim thay ma NXB!");
        }
    }

    public static void DocFile() {
        File file = new File("NXB.txt");
        System.out.print("\nFile name: " + file.getName());
        System.out.print("\nFile co ton tai: " + file.exists());
        DanhSachNXB dsNXB = new DanhSachNXB(100);

        if (!file.exists()) {
            try {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("\nFile NXB.txt was created!");
                }
            } catch (IOException e) {
                System.out.println("\nError creating file: " + e.getMessage());
            }
        }

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
                    dsNXB.NXB[dsNXB.size++] = nxb;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print("\nFile khong tim thay!" + e);
        } catch (IOException e) {
            System.out.println("\nError reading file: " + e);
        }
    }

    public void GhiFile() {
        File file = new File("NXB.txt");
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

    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        DanhSachNXB dsNXB = new DanhSachNXB(100);
        dsNXB.NXB[0] = new NhaXuatBan("NXB1", "Tan Vinh Tien", "122 -144 Duong Tu Giang P12 Q.5 TP.HCM", "3855 8043", "ctytanvinhtien@gmail.com");

        while (true) {
            System.out.print("\n-------------MenuOfNXB-------------------");
            System.out.print("\n1.Xem danh sach nha xuat ban");
            System.out.print("\n2.Them vao danh sach nha xuat ban");
            System.out.print("\n3.Sua trong danh sach nha xuat ban");
            System.out.print("\n4.Xoa trong danh sach nha xuat ban");
            System.out.print("\n5.Tim kiem trong danh sach nha xuat ban");
            System.out.print("\n6.Thoat menu!");
            System.out.print("\n-----------------------------------------");
            System.out.print("\nNhap su lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    dsNXB.Xem();
                    break;
                case 2:
                    dsNXB.Them();
                    break;
                case 3:
                    dsNXB.Sua();
                    break;
                case 4:
                    dsNXB.Xoa();
                    break;
                case 5:
                    dsNXB.TimKiem();
                    break;
                case 6:
                    System.out.print("\nThoat menu NXB!");
                    sc.close();
                    return;
                default:
                    System.out.print("\nLoi lua chon!");
            }
        }
    }

    public static void main(String[] args) {
        DocFile();
        Menu();
    }
}
