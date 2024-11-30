package QuanLyNXB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import Interface.CRUD;

public class DanhSachNXB implements CRUD {
    NhaXuatBan[] arrNXB = new NhaXuatBan[0];
    Scanner sc=new Scanner(System.in);
    
    private int viTriMaNXB(String maNXB){
        for(int i = 0; i < arrNXB.length; i++){
            if(arrNXB[i] != null && arrNXB[i].getMaNXB().equalsIgnoreCase(maNXB)){
                return i;
            }
        }
        return -1;
    }

    private boolean kiemtraTonTai(String NXB){
        for(NhaXuatBan nxb: arrNXB){
            if(nxb !=null && nxb.getMaNXB().equalsIgnoreCase(NXB)){
                return true; // Đã tồn tại
            }
        }
        return false; //Chưa tồn tại
    }

   @Override
    public void xem() {
        if (arrNXB.length == 0) {
            System.out.print("\nDanh sach trong!");
            return;
        } else {
            for(NhaXuatBan nxb : arrNXB){
                if(nxb != null){
                    nxb.xuatNXB();
                }
            }
        }
    }

    

    @Override
    public void them() {
        NhaXuatBan nxb_new=new NhaXuatBan();
        nxb_new.nhapNXB();
        if(!kiemtraTonTai(nxb_new.getMaNXB())){
            arrNXB = Arrays.copyOf(arrNXB, arrNXB.length + 1);
            arrNXB[arrNXB.length - 1] = nxb_new;
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║    Ma NXB %s Da Ton Tai        \n",nxb_new.getMaNXB());
            System.err.print("╚══════════════════════════════════════════");
        }
    } 

    @Override
    public void sua() {
        System.out.print("Nhap Ma Nha Xuat Ban Can Sua:");
        String maNXB = sc.nextLine();
        int vt = viTriMaNXB(maNXB);
        if(vt != -1){
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.printf("║     MENU : Chinh Sua Nha Xuat Ban %6s ║\n",maNXB.toUpperCase());
            arrNXB[vt].suaNXB();
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nha Xuat Ban: %s        \n",maNXB);
            System.err.print("╚══════════════════════════════════════════");
        }

    }

    @Override
    public void xoa() {
        System.out.print("\nNhap ma Nha Xuat Ban can xoa: ");
        String maNXB = sc.nextLine();
        int vt = viTriMaNXB(maNXB);
        if(vt != -1){
            for(int i = vt; i < arrNXB.length - 1; i++){
                arrNXB[i] = arrNXB[i + 1];
            }
            arrNXB = Arrays.copyOf(arrNXB, arrNXB.length - 1);
            System.err.print("\nDa Xoa Thanh Cong Nha Xuat Ban Voi Ma "+maNXB.toUpperCase());
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nha Xuat Ban: %s        \n",maNXB);
            System.err.print("╚══════════════════════════════════════════");
        }
        
    }

    public void timkiemTheoMaNXB(){
        System.out.print("Nhap Ma Nha Xuat Ban Can Tim: ");
        String checked1 = sc.nextLine();
        int vt = viTriMaNXB(checked1);
        if(vt != -1){
             arrNXB[vt].xuatNXB();
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nha Xuat Ban: %s        \n",checked1);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    public void timkiemTheoTenNXB(){
        System.out.print("Nhap Ten Nha Xuat Ban Can Tim: ");
        String checked1 = sc.nextLine();  
        boolean find= false;   
        for(NhaXuatBan nxb: arrNXB){
            if(nxb !=null && nxb.getTenNXB().toLowerCase().contains(checked1.toLowerCase())){
                nxb.xuatNXB();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nha Xuat Ban: %s        \n",checked1);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    public void timkiemTheoSDT(){
        System.out.print("Nhap SDT Nha Xuat Ban Can Tim: ");
        String checked1 = sc.nextLine();  
        boolean find= false;   
        for(NhaXuatBan nxb: arrNXB){
            if(nxb !=null && nxb.getSdtNXB().contains(checked1)){
                nxb.xuatNXB();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay So Dien Thoai NXB: %s        \n",checked1);
            System.err.print("╚══════════════════════════════════════════");
        }
    }
    @Override 
    public void timkiem() {
        int choice;
        do {
            System.err.print("\n╔══════════════════════════════════════════╗\n");
            System.out.println("║       MENU : Tim Kiem Nha Xuat Ban       ║ ");
            System.out.println("║   1. Tim Kiem Theo Ma Nha Xuat Ban       ║ ");
            System.out.println("║   2. Tim Kiem Theo Ten Nha Xuat Ban      ║ ");
            System.out.println("║   3. Tim Kiem Theo So Dien Thoai NXB     ║ ");
            System.out.println("║   0. Thoat                               ║ ");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("Lua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    timkiemTheoMaNXB();
                    break;
                case 2:
                    timkiemTheoTenNXB();
                    break;
                case 3:
                    timkiemTheoSDT();
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
    public void thongke(){
    //     while(true){
    //     System.out.print("\n===============ThongkeNXB=================");
    //     System.out.print("\n1.Liet ke nhung Nha Xuat Ban o HCM");
    //     System.out.print("\n2.Moi nha xuat dieu co ma duy nhat hay khong");
    //     System.out.print("\n==========================================");
    //     System.out.print("\nNhap sua lua chon cua ban: ");
    //     int choice=sc.nextInt();
    //     switch (choice) {
    //         case 1:
                
    //             break;
        
    //         default:
    //             break;
    //     }
    //  }
    // }
    }
    @Override
    public void docFile() {
<<<<<<< HEAD
        
        File file = new File("nxb.txt");
        System.out.print("\nFile: "+file.exists());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
=======
        try (BufferedReader br = new BufferedReader(new FileReader("data/nhaxuatban.txt"))){
>>>>>>> c0d606522f01a7cf38db0ccd2ad096a3a3e7beac
            String line;
            while ((line = br.readLine()) != null){
                String[] info = line.split("\\|");
                if (info.length == 5) {
                    String maNXB = info[0].trim();
                    String tenNXB = info[1].trim();
                    String diaChiNXB = info[2].trim();
                    String sdtNXB = info[3].trim();
                    String email = info[4].trim();

                    if (!kiemtraTonTai(maNXB)) {
                        if (arrNXB == null) {
                            arrNXB = new NhaXuatBan[1];
                        } else {
                            arrNXB = Arrays.copyOf(arrNXB, arrNXB.length + 1);
                        }
                        arrNXB[arrNXB.length - 1] = new NhaXuatBan(maNXB, tenNXB, diaChiNXB, sdtNXB, email);
                        System.out.print("\n╔══════════════════════════════════════════\n");
                        System.out.printf("║ Ma Nha Xuat Ban  %s  Da Them      \n", maNXB);
                        System.out.print("╚══════════════════════════════════════════");
                    } else {
                        System.out.print("\n╔══════════════════════════════════════════\n");
                        System.out.printf("║ Ma Nha Xuat Ban  %s  Da Co      \n", maNXB);
                        System.out.print("╚══════════════════════════════════════════");
                    }
                } else {
                    System.out.print("\nDu Lieu Khong Hop Le: " + line);
                }
                
            }
        } catch (Exception e) {
            System.out.println("Da Xay Ra Loi Khi Doc File: " + e.getMessage());
        }
    }

    @Override
<<<<<<< HEAD
    public void ghiFile() {
        File file = new File("nxb.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < size; i++) {
                if (NXB[i] != null) {
                    bw.write(NXB[i].getMaNXB() + "," + NXB[i].getTenNXB() + "," +
                             NXB[i].getDiaChiNXB() + "," + NXB[i].getSdtNXB() + "," +
                             NXB[i].getEmail());
                    bw.newLine();
=======
    public void ghiFile(){
        try {
            PrintWriter pw = new PrintWriter(new PrintWriter("data/nhaxuatban.txt"));
            for (NhaXuatBan nxb : arrNXB) {
                if (nxb != null) {
                    String line = nxb.getMaNXB() + " | " 
                                + nxb.getTenNXB() + " | " 
                                + nxb.getDiaChiNXB() + " | " 
                                + nxb.getSdtNXB() + " | " 
                                + nxb.getEmail();
                    pw.println(line);
>>>>>>> c0d606522f01a7cf38db0ccd2ad096a3a3e7beac
                }
            }
            System.err.print("\nNhap Thong Tin Vao Tu File Thanh Cong\n");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
