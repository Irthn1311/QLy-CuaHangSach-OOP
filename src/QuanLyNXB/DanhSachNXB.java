import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachNXB implements CRUD {
    Scanner sc=new Scanner(System.in);
    private NhaXuatBan[] dsNxb;
    private int size=3;


    public DanhSachNXB() {
        dsNxb = new NhaXuatBan[3];
        dsNxb[0]=new NhaXuatBan("NXB001","Nhi Dong","99 AN DUONG VUONG","0352443333","ha@gmail.com");
        dsNxb[1]=new NhaXuatBan("NXB002","Thieu Nhi","273 AN DUONG VUONG","03123213123","haaaaa@gmail.com");
        dsNxb[2]=new NhaXuatBan("NXB003","Nguyen xin","99 Phan Dinh Phung","02342443333","ha22a@gmail.com");
    }

    private int viTriMaNXB(String MaNXB){
        for(int i=0; i<size;i++){
            if(dsNxb[i]!=null && dsNxb[i].getMaNXB().equals(MaNXB)){
                return i;
            }
        }
        return -1;
    }
   @Override
    public void xem() {
        if (size == 0) {
            System.out.print("\nDanh sach trong!");
        } else {
            System.out.println("Thong Tin Cua Nha Xuat Ban:");
            for(NhaXuatBan nxb:dsNxb){
                if(nxb!=null){
                    nxb.xuatNXB();
                }
            }
        }
    }

    private boolean kiemtraTonTai(String NXB){
        for(NhaXuatBan nxb: dsNxb){
            if(nxb !=null && nxb.getMaNXB().equals(NXB)){
                return true; // Đã tồn tại
            }
        }
        return false; //Chưa tồn tại
    }

    @Override
    public void them() {
        NhaXuatBan nxb_new=new NhaXuatBan();
        nxb_new.nhapNXB(false);
        if(!kiemtraTonTai(nxb_new.getMaNXB())){
            dsNxb=Arrays.copyOf(dsNxb, size+1);
            dsNxb[size]=nxb_new;
            size++;
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║    Ma NXB %s Da Ton Tai        \n",nxb_new.getMaNXB());
            System.err.print("╚══════════════════════════════════════════");
        }
    } 

    @Override
    public void sua() {
        boolean bookFind = false;
        System.out.print("Nhap Ma NXB Can Sua: ");
        String MaNxb=sc.nextLine();
        for(NhaXuatBan nxb:dsNxb){
            if(nxb !=null && nxb.getMaNXB().equals(MaNxb)){
                nxb.nhapNXB(true);
                nxb.setMaNXB(MaNxb);
                break;
            }
        }
        if (!bookFind) {
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nha Xuat Ban: %s        \n",MaNxb);
            System.err.print("╚══════════════════════════════════════════");
        } else {
            System.out.println("\nChinh Sua Nha Xuat Ban Thanh Cong!!!");
        }

    }

    @Override
    public void xoa() {
        System.out.print("\nNhap ma Nha Xuat Ban can xoa: ");
        String maNXB = sc.nextLine();
        int vt=viTriMaNXB(maNXB);
        if(vt!=-1){
            for(int i=vt;i<size-1;i++){
                dsNxb[i]=dsNxb[i+1];
            }
            dsNxb=Arrays.copyOf(dsNxb, size-1);
            size--;
            System.err.print("\nDa Xoa Thanh Cong NXB");
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nha Xuat Ban: %s        \n",maNXB);
            System.err.print("╚══════════════════════════════════════════");
        }
        
    }

    public void timkiemTheoMaNXB(){
        System.out.print("Nhap Ma Nha Xuat Ban Can Tim: ");
        String checked1 = sc.nextLine();
        int vt=viTriMaNXB(checked1);
        if(vt!=-1){
             dsNxb[vt].xuatNXB();
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nha Xuat Ban: %s        \n",checked1);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    public void timkiemTheoTenNXB(){
        System.out.print("Nhap Ten Nha Xuat Ban Can Tim: ");
        String checked1 = sc.nextLine().toLowerCase();  
        boolean find= false;   
        for(NhaXuatBan nxb: dsNxb){
            if(nxb !=null && nxb.getTenNXB().toLowerCase().contains(checked1)){
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
        String checked1 = sc.nextLine().toLowerCase();  
        boolean find= false;   
        for(NhaXuatBan nxb: dsNxb){
            if(nxb !=null && nxb.getSdtNXB().toLowerCase().contains(checked1)){
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
        while (true) {
            System.err.print("\n╔══════════════════════════════════════════╗\n");
            System.out.println("║       MENU : Tim Kiem Nha Xuat Ban       ║ ");
            System.out.println("║   1. Tim Kiem Theo Ma Nha Xuat Ban       ║ ");
            System.out.println("║   2. Tim Kiem Theo Ten Nha Xuat Ban      ║ ");
            System.out.println("║   3. Tim Kiem Theo So Dien Thoai NXB     ║ ");
            System.out.println("║   0. Thoat                               ║ ");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("Lua Chon Cua Ban: ");
            int choice = sc.nextInt();
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
                    return; 
                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        }
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
        File readf = new File("NhaXuatBan.txt");
        try {
            if (!readf.exists()) {
                System.out.print("Tao File NXB Moi Thanh Cong");
                readf.createNewFile();
            }
            try (BufferedReader br = Files.newBufferedReader(readf.toPath(), StandardCharsets.UTF_8)) {
                String line;
                boolean isEmpty = true;
                while ((line = br.readLine()) != null) {
                    isEmpty = false;
                    String[] info = line.split("\\|");
                    if (info.length == 5) {
                        String MaNXB = info[0].trim();
                        String TenNXB = info[1].trim();
                        String diaChiNXB = info[2].trim();
                        String sdtNXB = info[3].trim();
                        String emailNXB = info[4].trim();
                        
                        if(!kiemtraTonTai(MaNXB)){
                            dsNxb=Arrays.copyOf(dsNxb, size+1);
                            dsNxb[size] = new NhaXuatBan(MaNXB,TenNXB,diaChiNXB,sdtNXB,emailNXB);
                            size++;
                        }else{
                            System.err.print("\n╔══════════════════════════════════════════\n");
                            System.err.printf("║ Ma NXB  %s  Da Co      \n",MaNXB);
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
            PrintWriter pw=new PrintWriter("NhaXuatBan_Output.txt","UTF-8");
            for(NhaXuatBan nxb:dsNxb){
                String line= "Ma NXB: "+ nxb.getMaNXB() + " | Ten NXB: " +nxb.getTenNXB() + " | Dia Chi NXB: " +nxb.getDiaChiNXB()+ " | SDT: " +nxb.getSdtNXB() + " | Email: "+nxb.getEmail();
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
