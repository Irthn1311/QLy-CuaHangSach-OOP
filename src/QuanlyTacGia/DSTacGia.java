import java.util.Arrays;
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
    TacGia[] dsTG;
    private int size = 3;

    public DSTacGia() {
        dsTG = new TacGia[3];
        dsTG[0] = new TacGia("TG001", "Wrxdie", "10-02-2000", "Ha Noi");
        dsTG[1] = new TacGia("TG002", "MCK", "02-03-1999", "Ha Noi");
        dsTG[2] = new TacGia("TG003", "TLing", "07-10-2000", "Ha Noi");
    }

    private int viTriMaTG(String MaTG){
        for(int i=0;i<size;i++){
            if(dsTG[i] !=null && dsTG[i].getMaTacGia().equals(MaTG)){
                return i;
            }
        }
        return -1;
    }

    private boolean kiemtraTonTai(String matg){
        for(TacGia tacgia: dsTG){
            if(tacgia !=null && tacgia.getMaTacGia().equals(matg)){
                return true; // Đã tồn tại
            }
        }
        return false; //Chưa tồn tại
    }

    @Override
    public void xem() {
        if (size == 0) {
            System.out.println("Danh Sach Rong.");
            return;
        }
        System.out.println("Thong Tin Cua Tac Gia:");
        for (TacGia tacGia : dsTG) {
            if (tacGia != null) {
                tacGia.xuatTG();
            }
        }
    }

    @Override
    public void them() {
        TacGia TG_new=new TacGia();
        TG_new.nhapTG(false);
        if(!kiemtraTonTai(TG_new.getMaTacGia())){
            dsTG=Arrays.copyOf(dsTG, size+1);
            dsTG[size]=TG_new;
            size++;
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║    Ma Tac Gia %s Da Ton Tai        \n",TG_new.getMaTacGia());
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    @Override
    public void sua() { 
        System.out.print("\nNhap Ma Tac Gia Can Chinh Sua: ");
        String checked = sc.nextLine();
        int vt=viTriMaTG(checked);
        if(vt!=-1){
            System.out.print("\nNhap Thong Tin Chinh Sua Cua Ma Tac Gia: "+checked);
            dsTG[vt].nhapTG(true);
            dsTG[vt].setMaTacGia(checked);
        }else {
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Tac Gia: %s        \n",checked);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    @Override
    public void xoa() {
        System.out.print("\nNhap Ma Tac Gia Can Xoa: ");
        String checked = sc.nextLine();
        int vt=viTriMaTG(checked);
        if(vt!=-1){
            for(int i=vt;i<size-1;i++){
                dsTG[i]=dsTG[i+1];
            }
            dsTG=Arrays.copyOf(dsTG, size-1);
            size--;
            System.out.println("Da Xoa Tac Gia Voi Ma: " + checked);
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Tac Gia: %s        \n",checked);
            System.err.print("╚══════════════════════════════════════════");
        }
        
    }

    public void TimTGTheoMa(){
        System.out.print("Nhap Ma Tac Gia Can Tim: ");
        String checked1 = sc.nextLine();
        int vt=viTriMaTG(checked1);
        if(vt!=-1){
            dsTG[vt].xuatTG();
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
        for(TacGia tacgia:dsTG){
            if(tacgia !=null && tacgia.getTenTacGia().toLowerCase().contains(checked1)){
                tacgia.xuatTG();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Tac Gia: %s        \n",checked1);
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
        for (TacGia tacGia : dsTG) {
            if (tacGia != null) {
                int age = Period.between(tacGia.getNamSinhTG(), nowDate).getYears();
                if (age > 50) {
                    soluong1++;
                }else{
                    soluong2++;
                }
            }
        }
        System.err.print("So Tac Gia Tren 50 Tuoi: "+soluong1);
        System.err.print("So Tac Gia Duoi 50 Tuoi: "+soluong2);
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
                        
                        if(!kiemtraTonTai(MaTG)){
                            dsTG=Arrays.copyOf(dsTG, size+1);
                            dsTG[size] = new TacGia(MaTG,TenTG,NamSinhTG,QueQuanTG);
                            System.err.print("\n╔══════════════════════════════════════════\n");
                            System.err.printf("║ Ma Tac Gia  %s  Da Them      \n",MaTG);
                            System.err.print("╚══════════════════════════════════════════");
                            size++;
                            
                        }else{
                            System.err.print("\n╔══════════════════════════════════════════\n");
                            System.err.printf("║ Ma Tac Gia  %s  Da Co      \n",MaTG);
                            System.err.print("╚══════════════════════════════════════════");
                        }
                        
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
    @Override
    public void ghiFile(){
        try {
            PrintWriter pw=new PrintWriter("TacGia_Output.txt","UTF-8");
            for(TacGia tacgia:dsTG){
                String line= "Ma Tac Gia: "+ tacgia.getMaTacGia() + " | Ten Tac Gia: " +tacgia.getTenTacGia() + " | Nam Sinh: " +tacgia.getNamSinhTG()+ " | Que Quan: " +tacgia.getQueQuan();
                pw.println(line);
                pw.flush();
            }
            System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG: ");
           
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
