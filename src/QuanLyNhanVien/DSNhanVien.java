package QuanLyNhanVien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Interface.CRUD;

public class DSNhanVien implements CRUD {
    NhanVien[] arrNV = new NhanVien[10];
    Scanner sc=new Scanner(System.in);

    private int viTriMaNv(String maNV) {
        for (int i = 0; i < arrNV.length; i++) {
            if (arrNV[i] != null && arrNV[i].getMaNV().equalsIgnoreCase(maNV)) {
                return i;
            }
        }
        return -1;
    }
    

    private boolean kiemTraTonTai(String MaNv){
        for(NhanVien nv: arrNV){
            if(nv!=null && nv.getMaNV().equalsIgnoreCase(MaNv)){
                return true; // Đã tồn tại
            }
        }
        return false; //Không tồn tại
    }
    
    @Override
    public void xem(){
        if(arrNV.length == 0){
            System.out.print("Danh Sach Rong");
        }else{
            System.out.print("\nThong Tin Cua Nhan Vien");
            for(NhanVien nv: arrNV){
            if(nv != null){
                nv.xuatNV();
                }
            }
        }
    }

    @Override
    public void them(){
        NhanVien nv=new NhanVien();
        nv.nhapNV(false);
        if(!kiemTraTonTai(nv.getMaNV())){
            arrNV = Arrays.copyOf(arrNV, arrNV.length + 1);
            arrNV[arrNV.length - 1] = nv;
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║    Ma Khach %s Da Ton Tai        \n",nv.getMaNV());
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    @Override
    public void sua(){
        System.out.print("\nNhap Ma Nhan Vien Can Sua: ");
        String MaNv = sc.nextLine();
        int vt= viTriMaNv(MaNv);
        if(vt !=-1){
            System.out.print("\n╔══════════════════════════════════════════╗\n");
            System.err.printf("║     MENU : Chinh Sua Nhan Vien %6s    ║\n",MaNv.toUpperCase());
            arrNV[vt].suaNV();
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nhan Vien: %s        \n",MaNv);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    @Override
    public void xoa(){
        System.out.print("\nNhap Ma Nhan Vien Can Xoa: ");
        String MaNv = sc.nextLine();
        int vt= viTriMaNv(MaNv);
        if(vt !=-1){
            for(int i = vt; i < arrNV.length - 1; i++){
                arrNV[i]=arrNV[i+1];
            }
            arrNV = Arrays.copyOf(arrNV, arrNV.length -1);
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nhan Vien: %s        \n",MaNv);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    @Override
    public void timkiem(){
        int find;
        do {
            System.err.print("\n╔══════════════════════════════════════════╗\n");
            System.out.println("║       MENU : Tim Kiem Nhan Vien          ║ ");
            System.out.println("║   1. Tim Kiem Theo Ma Nhan Vien          ║ ");
            System.out.println("║   2. Tim Kiem Theo Ho Nhan Vien          ║ ");
            System.out.println("║   3. Tim Kiem Theo Ten Nhan Vien         ║ ");
            System.out.println("║   4. Tim Kiem Theo Quan A va B <<OR>>    ║ ");
            System.out.println("║   5. Tim Kiem Theo Do Tuoi     <<AND>>   ║ ");
            System.out.println("║   0. Thoat                               ║ ");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("Lua Chon Cua Ban: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    timkiemMaNV();
                    break;
                case 2:
                    timkiemHoNV();
                    break;
                case 3:
                    timkiemTenNV();
                    break;
                case 4:
                    timkiemTheoQuan();
                    break;
                case 5:
                    timkiemTheoTuoi();
                    break;
                case 0:
                    System.out.println("THOAT THANH CONG");
                    break;

                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (find!=0);
    }

    public void timkiemMaNV(){
        System.out.print("\nNhap Ma Nhan Vien Can Tim: ");
        String MaNv = sc.nextLine();
        int vt= viTriMaNv(MaNv);
        if(vt!=-1){
            arrNV[vt].xuatNV();  //Kiem tra lại
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nhan Vien: %s        \n",MaNv);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    public void timkiemHoNV(){
        System.out.print("\nNhap Ho Nhan Vien Can Tim Kiem: ");
        String hoNV = sc.nextLine();
        boolean find=false;
        for(NhanVien nv: arrNV){
            if(nv !=null && nv.getHoNV().toLowerCase().contains(hoNV.toLowerCase())){
                nv.xuatNV();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nhan Vien Ho: %s        \n",hoNV);
            System.err.print("╚══════════════════════════════════════════");
        } 
    }

    public void timkiemTenNV(){
        System.out.print("\nNhap Ten Nhan Vien Can Tim Kiem: ");
        String tenNV = sc.nextLine();
        boolean find=false;
        for(NhanVien nv: arrNV){
            if(nv !=null && nv.getTenNV().toLowerCase().contains(tenNV.toLowerCase())){
                nv.xuatNV();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nhan Vien Ten: %s        \n",tenNV);
            System.err.print("╚══════════════════════════════════════════");
        } 
    }

    public void timkiemTheoQuan(){
        System.out.print("\nNhap Quan Thu Nhat:");
        String quanA=sc.nextLine();
        System.out.print("Nhap Quan Thu Hai:");
        String quanB=sc.nextLine();
        boolean find=false;
        for(NhanVien nVien: arrNV){
            if(nVien!=null && (nVien.getDiaChiNV().equalsIgnoreCase(quanA)|| nVien.getDiaChiNV().equalsIgnoreCase(quanB))){
                nVien.xuatNV();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Nhan Vien O %s va %s      \n",quanA,quanB);
            System.err.print("╚══════════════════════════════════════════"); 
        }
    }

    public void timkiemTheoTuoi(){
        LocalDate now=LocalDate.now();
        System.out.print("\nNhap Do Tuoi Start: ");  
        int ageA=sc.nextInt();
        sc.nextLine();
        System.out.print("\nNhap Do Tuoi End: ");  
        int ageB=sc.nextInt();
        sc.nextLine();
        boolean find=false;
        for(NhanVien nv: arrNV){
            int tuoi=Period.between(nv.getNgaySinh(), now).getYears();
            if(tuoi >=ageA && tuoi<=ageB){
                nv.xuatNV();
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Nhan Vien Tu %d => %d      \n",ageA,ageB);
            System.err.print("╚══════════════════════════════════════════"); 
        }
    }

    @Override
    public void thongke(){
        int choice;
        do {
            System.err.print("\n╔══════════════════════════════════════════╗\n");
            System.out.println("║       MENU : Thong Ke                    ║ ");
            System.out.println("║   1. Thong Ke Do Tuoi Nhan Vien          ║ ");
            System.out.println("║   2. Thong Ke Gioi Tinh Nhan Vien        ║ ");
            System.out.println("║   3. Thong Ke Chuc Vu Nhan Vien          ║ ");
            System.out.println("║   4. Thong Ke Theo Luong Nhan Vien (X=>Y)║ ");
            System.out.println("║   0. Thoat                               ║ ");
            System.out.print("╚══════════════════════════════════════════╝\n");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    thongkeTuoiNV();
                    break;
                case 2:
                    thongkeGioiTinhNV();
                    break;
                case 3:
                    thongkeChucVuNV();
                    break;
                case 4:
                    thongkeLuongNV();
                    break;
                case 0:
                    System.out.print("Thoat");
                    break;
                default:
                    System.out.println("\nNhap Sai! Vui Long Nhap Lai.");
                    break;
            }
        } while (choice !=0);
    }

    public void thongkeTuoiNV() {
        LocalDate nowDate=LocalDate.now();
        int hocsinh=0, thanhnien=0,truongthanh=0, trungnien=0,caotuoi=0;
        for(NhanVien nv: arrNV){
            if(nv !=null){
                int age = Period.between(nv.getNgaySinh(), nowDate).getYears();
                if(age>0 && age<=18){
                    hocsinh++;
                }else if(age > 19 && age <= 25){
                    thanhnien++;
                }else if(age > 26 && age <= 40){
                    truongthanh++;
                }else if(age > 40 && age <= 60){
                    thanhnien++;
                }else if(age > 60){
                    caotuoi++;
                }
            }
        }
        System.err.print("\n╔══════════════════════════════════════════\n");
        System.out.println("║     Thong Ke Do Tuoi Cua Khach Hang      ");
        System.out.println("║  Hoc Sinh       (0->18)      : "+hocsinh);
        System.out.println("║  Thanh Nien     (19->25)     : "+thanhnien);
        System.out.println("║  Truong Thanh   (26->40)     : "+truongthanh);
        System.out.println("║  Trung Nien     (41-60)      : "+trungnien);
        System.out.println("║  Nguoi Cao Tuoi (lớn hơn 61) : "+caotuoi);
        System.out.print("╚══════════════════════════════════════════\n");
    }

    public void thongkeGioiTinhNV() {
        int male=0,female=0,gender_unknown=0;
        for(NhanVien nVien: arrNV){
            if(nVien !=null){
                String gender=nVien.getGioiTinh();
                if(gender.equalsIgnoreCase("nam")){
                    male++;
                }else if(gender.equalsIgnoreCase("nu")){
                    female++;
                }else{
                    gender_unknown++;
                }
            }
        }
        System.err.print("\n╔══════════════════════════════════════════\n");
        System.out.println("║       Thong Ke Gioi Tinh Khach             ");
        System.out.println("║   Nam:           : "+male);
        System.out.println("║   Nu             : "+female);
        System.out.println("║   Gioi Tinh Khac : "+gender_unknown);
        System.out.print("╚══════════════════════════════════════════\n");
    }

    public void thongkeChucVuNV() {
        int member=0, manager=0, ceo=0, khac=0;
        for(NhanVien nv:arrNV){
            if(nv !=null){
                String job=nv.getChucVu();
                if(job.equalsIgnoreCase("nhan vien")){
                    member++;
                }else if(job.equalsIgnoreCase("quan ly")){
                    manager++;
                }else if(job.equalsIgnoreCase("giam doc")){
                    ceo++;
                }else{
                    khac++;
                }
            }
        }
        System.err.print("\n╔══════════════════════════════════════════\n");
        System.out.println("║       Thong Ke Chuc Vu Cua Hang            ");
        System.out.println("║   Giam Doc  : "+ceo);
        System.out.println("║   Quan Ly   : "+manager);
        System.out.println("║   Nhan Vien : "+member);
        System.out.println("║   Khac      : "+khac);

        System.out.print("╚══════════════════════════════════════════\n");
    }

    public void thongkeLuongNV() {
        System.out.print("\nNhap Luong Bat Dau:");
        int l1=sc.nextInt();
        System.out.print("Nhap Luong Ket Thuc:");
        int l2=sc.nextInt();
        boolean find=false;
        int sl=0;

        for(NhanVien nVien: arrNV){
            if(nVien!=null && nVien.getLuongNV() >= l1 && nVien.getLuongNV()<=l2){
                sl++;
                find=true;
            }
        }
        if(!find){
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Nhan Vien Co Luong Tu %d => %d     \n",l1,l2);
            System.err.print("╚══════════════════════════════════════════"); 
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ So Nhan Vien Co Luong Tu %d => %d : %d      \n",l1,l2,sl);
            System.err.print("╚══════════════════════════════════════════"); 
        }
    }
    @Override 
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/nhanvien.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                if (info.length == 9) {
                    String maNV = info[0].trim();
                    String hoNV = info[1].trim();
                    String tenNV = info[2].trim();
                    String chucVu = info[3].trim();
                    String ngaySinh = info[4].trim();
                    String gioiTinh = info[5].trim();
                    String sdtNV = info[6].trim();
                    String diaChiNV = info[7].trim();
                    Double luongNV = Double.parseDouble(info[8].trim());

                    if (!kiemTraTonTai(maNV)) { // Kiểm tra nhân viên đã tồn tại hay chưa
                        if (arrNV == null) {
                            arrNV = new NhanVien[1];
                        } else {
                            arrNV = Arrays.copyOf(arrNV, arrNV.length + 1);
                        }
                        arrNV[arrNV.length - 1] = new NhanVien(maNV, hoNV, tenNV, chucVu, ngaySinh, gioiTinh, sdtNV, diaChiNV, luongNV);

                        System.err.print("\n╔══════════════════════════════════════════\n");
                        System.err.printf("║ Ma Nhan Vien  %s  Da Them      \n", maNV);
                        System.err.print("╚══════════════════════════════════════════");
                    } else {
                        System.err.print("\n╔══════════════════════════════════════════\n");
                        System.err.printf("║ Ma Nhan Vien  %s  Da Co      \n", maNV);
                        System.err.print("╚══════════════════════════════════════════");
                    }
                } else {
                    System.out.println("Du Lieu Khong Hop Le: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Da Xay Ra Loi Khi Doc File: " + e.getMessage());
        }
    }


    @Override
    public void ghiFile() {
        try {
            PrintWriter pw = new PrintWriter("data/nhanvien.txt");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            for (NhanVien nv : arrNV) {
                if (nv != null) {
                    String formattedNgaySinh = nv.getNgaySinh().format(formatter);
                    String line = nv.getMaNV() + "|" + nv.getHoNV() + "|" + nv.getTenNV() + "|" + nv.getChucVu() + "|" 
                                + formattedNgaySinh + "|" + nv.getGioiTinh() + "|" + nv.getSDTNV() + "|" + nv.getDiaChiNV() + "|" + nv.getLuongNV();
                    pw.println(line);
                }
            }
            System.out.print("\nNHAP THONG TIN VAO FILE THANH CONG: ");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
