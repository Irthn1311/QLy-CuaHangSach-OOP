import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.Period;

public class DSTacGia implements CRUD {
    Scanner sc = new Scanner(System.in);
    TacGia[] TG;
    private int size = 3;

    public DSTacGia() {
        TG = new TacGia[3];
        TG[0] = new TacGia("TG001", "Wrxdie", "10-02-2000", "Ha Noi");
        TG[1] = new TacGia("TG002", "MCK", "02-03-1999", "Ha Noi");
        TG[2] = new TacGia("TG003", "TLing", "07-10-2000", "Ha Noi");
    }

    @Override
    public void xem() {
        System.out.println("Thong tin vi tri cua khach hang:");
        for (TacGia tacGia : TG) {
            if (tacGia != null) {
                tacGia.xuatTG();
            }
        }
    }

    @Override
    public void them() {
        for (int i = 0; i < TG.length; i++) {
            if (TG[i]==null){
                TG[i] = new TacGia(); 
                TG[i].nhapTG();
                size++;
                return;
            }
        }
        if (size == TG.length) { 
            TacGia[] newTG = new TacGia[TG.length + 1];
            for (int j = 0; j< TG.length; j++) {
                if(TG[j]!=null){
                    newTG[j] = TG[j];
                } 
            }
            TG = newTG; 
        }
    
        TG[size] = new TacGia();
        TG[size].nhapTG();
        size++;
    }

    @Override
    public void sua() {
        boolean bookFind = false;
        System.out.print("\nNhap Ma Sach Can Sua: ");
        String checked = sc.nextLine();
        for (int i = 0; i < TG.length; i++) {
            if (TG[i] != null && checked.equals(TG[i].getMaTacGia())) {
                TG[i].nhapTG();
                bookFind = true;
                break;
            }
        }
        if (!bookFind) {
            System.out.println("\nKHONG TIM THAY MA SACH.");
        } else {
            System.out.println("\nCHINH SUA SACH THANH CONG!!!");
        }
    }

    @Override
    public void xoa() {
        boolean bookFind = false;
        System.out.print("\nNhap Ma Tac Gia Can Xoa: ");
        String checked = sc.nextLine();
        for (int i = 0; i < TG.length; i++) {
            if (TG[i] != null && checked.equals(TG[i].getMaTacGia())) {
                TG[i] = null;
                bookFind = true;
                size--;
                break;
            }
        }
        if (!bookFind) {
            System.out.println("\nKHONG TIM THAY MA TAC GIA.");
        } else {
            System.out.println("\nXOA TAC GIA THANH CONG!!!");
        }
    }

    @Override
    public void timkiem() {
        int find;
        do {
            System.out.println("\nLua Chon Tim Kiem:");
            System.out.println("1. Tim Kiem Theo Ma Tac Gia");
            System.out.println("2. Tim Kiem Theo Ten Tac Gia");
            System.out.println("0. Thoat");
            System.out.print("Lua Chon Cua Ban: ");
            find = sc.nextInt();
            sc.nextLine(); 
            switch (find) {
                case 1:
                    boolean bookFind1 = false;
                    System.out.println("Nhap Ma Tac Gia Can Tim: ");
                    String checked1 = sc.nextLine();
                    for (TacGia tacGia : TG) {
                        if (tacGia != null && checked1.equals(tacGia.getMaTacGia())) {
                            tacGia.xuatTG();
                            bookFind1 = true;
                            break;
                        }
                    }
                    if (!bookFind1) {
                        System.out.println("\nKHONG TIM THAY MA TAC GIA: "+checked1);
                    }
                    break;
                case 2:
                    boolean bookFind2 = false;
                    System.out.println("Nhap Ten Tac Gia Can Tim: ");
                    String checked2 = sc.nextLine().toLowerCase();
                    for (TacGia tacGia : TG) {
                        if (tacGia != null && tacGia.getTenTacGia().toLowerCase().contains(checked2)) {
                            tacGia.xuatTG();
                            bookFind2 = true;
                        }
                    }
                    if (!bookFind2) {
                        System.out.println("\nKHONG TIM THAY TAC GIA.");
                    }
                    break;
                case 0:
                    System.out.println("THOAT THANH CONG");
                    break;
                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (find != 0);
    }

    @Override
    public void thongke() {
        LocalDate nowDate = LocalDate.now();
        int choice;
        do {
            System.out.println("\nLua Chon Thong Ke:");
            System.out.println("1. Thong Ke Tac Gia Tren 50 Tuoi");
            System.out.println("2. Thong Ke Tac Gia Duoi 50 Tuoi");
            System.out.println("0. Thoat");
            System.out.print("Lua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    int soluong1=0;
                    System.out.println("\nThong tin cua cac tac gia tren 50 Tuoi:");
                    for (TacGia tacGia : TG) {
                        if (tacGia != null) {
                            int age = Period.between(tacGia.getNamSinhTG(), nowDate).getYears();
                            if (age > 50) {
                                tacGia.xuatTG();
                                soluong1++;
                            }
                        }
                    }
                    if(soluong1==0){
                        System.err.print("\nKhong Co Tac Gia Tren 50 Tuoi");
                    }
                    break;
                case 2:
                    int soluong2=0;
                    System.out.print("\nThong Tin Cua Cac Tac Gia Duoi 50 Tuoi:");
                    for (TacGia tacGia : TG) {
                        if (tacGia != null) {
                            int age = Period.between(tacGia.getNamSinhTG(), nowDate).getYears();
                            if (age <= 50) {
                                tacGia.xuatTG();
                            }
                        }
                    }
                    if(soluong2==0){
                        System.err.print("\nKhong Co Tac Gia Duoi 50 Tuoi");
                    }
                    break;
                case 0:
                    System.out.println("THOAT THANH CONG");
                    break;
                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (choice != 0);
    }
    @Override
    public void docFile() {
        File readf = new File("TacGia_Input.txt");
        try {
            if (!readf.exists()) {
                System.out.print("Tao File Tac Gia Moi Thanh Cong");
                readf.createNewFile();
            }
            try (BufferedReader br = Files.newBufferedReader(readf.toPath(), StandardCharsets.UTF_8)) {
                String line;
                boolean isEmpty = true;
                while ((line = br.readLine()) != null) {
                    isEmpty = false;
                    String[] info = line.split("\\|");
                    if (info.length == 4) {
                        String MaTG = info[0].trim();
                        String TenTG = info[1].trim();
                        String NamSinhTG = info[2].trim();
                        String QueQuanTG = info[3].trim();
                        for (int i = 0; i < TG.length; i++) {
                            if (TG[i]==null){
                                TG[i] = new TacGia(); 
                                TG[i].setMaTacGia(MaTG);
                                TG[i].setTenTacGia(TenTG);
                                TG[i].setNamSinhTG(NamSinhTG);
                                TG[i].setQueQuan(QueQuanTG);
                                size++;
                                return;
                            }
                        }
                        if (size == TG.length) {
                            TacGia[] newTG = new TacGia[TG.length + 1];
                            for (int j = 0; j < TG.length; j++) {
                                if (TG[j] != null) {
                                    newTG[j] = TG[j];
                                }
                            }
                            TG = newTG;
                        }
                        TG[size] = new TacGia();
                        TG[size].setMaTacGia(MaTG);
                        TG[size].setTenTacGia(TenTG);
                        TG[size].setNamSinhTG(NamSinhTG);
                        TG[size].setQueQuan(QueQuanTG);
                        size++;
                    } else {
                        System.out.println("Du Lieu Khong Hop Le: " + line);
                    }
                }
                if (isEmpty) {
                    System.out.println("\nFILE EMPTY WITH NOTHING");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ghiFile(){
        try {
            PrintWriter pw=new PrintWriter("TacGia_Input.txt","UTF-8");
            System.out.println("\nNhap Du Lieu Ban Muon Them Vao File");
            String text=sc.nextLine();
            pw.print(text);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
