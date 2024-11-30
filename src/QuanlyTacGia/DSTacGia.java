package QuanlyTacGia;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import Interface.CRUD;

public class DSTacGia implements CRUD {
    TacGia[] arrTG = new TacGia[10];
    Scanner sc = new Scanner(System.in);

    private int viTriMaTG(String MaTG){
        for(int i = 0; i < arrTG.length; i++){
            if(arrTG[i] != null && arrTG[i].getMaTacGia().equalsIgnoreCase(MaTG)){
                return i;
            }
        }
        return -1;
    }

    private boolean kiemtraTonTai(String matg){
        for(TacGia tacgia: arrTG){
            if(tacgia !=null && tacgia.getMaTacGia().equalsIgnoreCase(matg)){
                return true; // Đã tồn tại
            }
        }
        return false; //Chưa tồn tại
    }

    @Override
    public void xem() {
        if (arrTG.length == 0) {
            System.out.println("Danh Sach Rong.");
            return;
        } else {
            for (TacGia tacGia : arrTG) {
                if (tacGia != null) {
                    tacGia.xuatTG();
                }
            }
        }
    }

    @Override
    public void them() {
        TacGia TG_new = new TacGia();
        TG_new.nhapTG();
        if(!kiemtraTonTai(TG_new.getMaTacGia())){
            arrTG = Arrays.copyOf(arrTG, arrTG.length + 1);
            arrTG[arrTG.length - 1] = TG_new;
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║    Ma Tac Gia %s Da Ton Tai        \n",TG_new.getMaTacGia());
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    @Override
    public void sua() { 
        System.out.print("\nNhap Ma Tac Gia Can Chinh Sua: ");
        String matg = sc.nextLine();
        int vt = viTriMaTG(matg);
        if(vt != -1){
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.printf("║     MENU : Chinh Sua Tac Gia %6s      ║\n",matg.toUpperCase());
            arrTG[vt].suaTG();
        }else {
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Tac Gia: %s        \n", matg);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    @Override
    public void xoa() {
        System.out.print("\nNhap Ma Tac Gia Can Xoa: ");
        String matg = sc.nextLine();
        int vt=viTriMaTG(matg);
        if(vt!=-1){
            for(int i = vt; i < arrTG.length - 1; i++){
                arrTG[i] = arrTG[i + 1];
            }
            arrTG=Arrays.copyOf(arrTG, arrTG.length - 1);
            System.out.println("Da Xoa Tac Gia Voi Ma " + matg.toUpperCase());
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Tac Gia: %s        \n",matg);
            System.err.print("╚══════════════════════════════════════════");
        }
        
    }

    public void TimTGTheoMa(){
        System.out.print("Nhap Ma Tac Gia Can Tim: ");
        String checked1 = sc.nextLine();
        int vt = viTriMaTG(checked1);
        if(vt != -1){
            arrTG[vt].xuatTG();
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Tac Gia: %s        \n",checked1);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    public void TimTGTheoTen(){
        System.out.print("Nhap Ten Tac Gia Can Tim: ");
        String checked1 = sc.nextLine().toLowerCase();  
        boolean find= false;   
        for(TacGia tacgia:arrTG){
            if(tacgia !=null && tacgia.getTenTacGia().toLowerCase().contains(checked1)){
                tacgia.xuatTG();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ten Tac Gia: %s        \n",checked1);
            System.err.print("╚══════════════════════════════════════════");
        }
    }
    @Override
    public void timkiem() {
        int choice;
        do {
            System.err.print("\n╔══════════════════════════════════════════╗\n");
            System.out.println("║       MENU : Tim Kiem Tac Gia            ║ ");
            System.out.println("║   1. Tim Kiem Theo Ma Tac Gia            ║ ");
            System.out.println("║   2. Tim Kiem Theo Ten Tac Gia           ║ ");
            System.out.println("║   0. Thoat                               ║ ");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("Lua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    TimTGTheoMa();
                    break;
                case 2:
                    TimTGTheoTen();
                    break;
                case 0:
                    System.out.println("Thoat Thanh Cong");
                    break;
                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (choice != 0);
    }


    @Override
    public void thongke() {
        LocalDate nowDate = LocalDate.now();
        int soluong1=0;
        int soluong2=0;
        for (TacGia tacGia : arrTG) {
            if (tacGia != null) {
                int age = Period.between(tacGia.getNamSinhTG(), nowDate).getYears();
                if (age > 50) {
                    soluong1++;
                }else{
                    soluong2++;
                }
            }
        }
        System.out.println("╔══════════════════════════════════════════");
        System.out.printf("║   Tac Gia Tren 50 Tuoi: %d         \n",soluong1);
        System.out.printf("║   Tac Gia Duoi 50 Tuoi: %d         \n",soluong2);
        System.out.println("╠══════════════════════════════════════════");
    }
    @Override
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/tacgia.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                if (info.length == 4) {
                    String maTG = info[0].trim();
                    String tenTG = info[1].trim();
                    String namSinhTG = info[2].trim();
                    String queQuanTG = info[3].trim();

                    if (!kiemtraTonTai(maTG)){
                        if (arrTG == null) {
                            arrTG = new TacGia[1];
                        } else {
                            arrTG = Arrays.copyOf(arrTG, arrTG.length + 1);
                        }
                        arrTG[arrTG.length - 1] = new TacGia(maTG, tenTG, namSinhTG, queQuanTG);
                        System.out.print("\n╔══════════════════════════════════════════\n");
                        System.out.printf("║ Ma Tac Gia  %s  Da Them      \n", maTG);
                        System.out.print("╚══════════════════════════════════════════");
                    } else {
                        System.out.print("\n╔══════════════════════════════════════════\n");
                        System.out.printf("║ Ma Tac Gia  %s  Da Co      \n", maTG);
                        System.out.print("╚══════════════════════════════════════════");
                    }
                } else {
                    System.out.println("Du Lieu Khong Hop Le: " + line);
                }          
            }            
        } catch (Exception e) {
            System.out.println("Da Xay Ra Loi Khi Doc File: " + e.getMessage());
        }
    }


        
    @Override
    public void ghiFile(){
        try {
            PrintWriter pw = new PrintWriter("data/tacgia.txt");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            for (TacGia tg : arrTG) {
                if (tg != null) {
                    String formattedNgaySinh = tg.getNamSinhTG().format(formatter);
                    String line = tg.getMaTacGia() + " | " 
                                + tg.getTenTacGia() + " | " 
                                + formattedNgaySinh + " | " 
                                + tg.getQueQuan();
                    pw.println(line);
                }
            }
            System.err.print("\nNhap Thong Tin Vao Tu File Thanh Cong\n");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
