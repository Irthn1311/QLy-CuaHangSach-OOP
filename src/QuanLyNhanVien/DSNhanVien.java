import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class DSNhanVien implements CRUD {
    NhanVien[] dsNV;
    Scanner sc=new Scanner(System.in);
    int size=3;


    public DSNhanVien(){
        dsNV = new NhanVien[3];
        dsNV[0] = new NhanVien("NV001", "Le","Phan","Quan Ly","02-03-2000","Nam","0111111111", "Quan 1",1000.0);
        dsNV[1] = new NhanVien("NV002","Nghiem","Vu Hoang Long","Nhan Vien","02-03-1999","Nam","022222222222","Tan Phu",300.0);
        dsNV[2] = new NhanVien("NV003","Nguyen", "Thao Linh","Nhan Vien","07-10-2000","Nu","03333333333", "Quan 2",240.0);
    }

    private int viTriMaNv(String MaNv){
        for(int i=0;i<size-1;i++){
            if(dsNV[i]!=null && dsNV[i].getMaNV().equals(MaNv)){
                return i;
            }
        }
        return -1;
    }

    private boolean kiemTraTonTai(String MaNv){
        for(NhanVien nv: dsNV){
            if(nv!=null && nv.getMaNV().equals(MaNv)){
                return true; // Đã tồn tại
            }
        }
        return false; //Không tồn tại
    }
    
    @Override
    public void xem(){
        if(size==0){
            System.out.print("Danh Sach Rong");
        }else{
            System.out.print("\nThong Tin Cua Nhan Vien");
            for(NhanVien nv: dsNV){
            if(nv !=null){
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
            dsNV=Arrays.copyOf(dsNV, size+1);
            dsNV[size]=nv;
            size++;
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
            System.err.printf("║     MENU : Chinh Sua Nhan Vien %s ║\n",MaNv);
            dsNV[vt].suaNV();
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
            for(int i=vt;i<size-1;i++){
                dsNV[i]=dsNV[i+1];
            }
            dsNV=Arrays.copyOf(dsNV, size+1);
            size--;
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
            dsNV[vt].xuatNV();  //Kiem tra lại
        }else{
            System.err.print("\n╔══════════════════════════════════════════\n");
            System.err.printf("║ Khong Tim Thay Ma Nhan Vien: %s        \n",MaNv);
            System.err.print("╚══════════════════════════════════════════");
        }
    }

    public void timkiemHoNV(){
        System.out.print("\nNhap Ho Nhan Vien Can Tim Kiem: ");
        String hoNV = sc.nextLine().toLowerCase();
        boolean find=false;
        for(NhanVien nv: dsNV){
            if(nv !=null && nv.getHoNV().toLowerCase().equals(hoNV)){
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
        String tenNV = sc.nextLine().toLowerCase();
        boolean find=false;
        for(NhanVien nv: dsNV){
            if(nv !=null && nv.getTenNV().toLowerCase().contains(tenNV)){
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
        String quanA=sc.nextLine().toLowerCase();
        System.out.print("Nhap Quan Thu Hai:");
        String quanB=sc.nextLine().toLowerCase();
        boolean find=false;
        for(NhanVien nVien: dsNV){
            if(nVien!=null && (nVien.getDiaChiNV().toLowerCase().equals(quanA)|| nVien.getDiaChiNV().toLowerCase().equals(quanB))){
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
        for(NhanVien nv: dsNV){
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
        for(NhanVien nv: dsNV){
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
        for(NhanVien nVien: dsNV){
            if(nVien !=null){
                String gender=nVien.getGioiTinh().toLowerCase();
                if(gender.equals("nam")){
                    male++;
                }else if(gender.equals("nu")){
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
        int member=0, manager=0, ceo=0;
        for(NhanVien nv:dsNV){
            if(nv !=null){
                String job=nv.getChucVu().toLowerCase();
                if(job.equals("nhan vien")){
                    member++;
                }else if(job.equals("quan ly")){
                    manager++;
                }else{
                    ceo++;
                }  
            }
        }
        System.err.print("\n╔══════════════════════════════════════════\n");
        System.out.println("║       Thong Ke Chuc Vu Cua Hang            ");
        System.out.println("║   Giam Doc  : "+ceo);
        System.out.println("║   Quan Ly   : "+manager);
        System.out.println("║   Nhan Vien : "+member);
        System.out.print("╚══════════════════════════════════════════\n");
    }

    public void thongkeLuongNV() {
        System.out.print("\nNhap Luong Bat Dau:");
        int l1=sc.nextInt();
        System.out.print("Nhap Luong Ket Thuc:");
        int l2=sc.nextInt();
        boolean find=false;
        int sl=0;

        for(NhanVien nVien: dsNV){
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
    File readf= new File("KhachHang_Input.txt");
        try{
            if(!readf.exists()){
                System.out.print("Tao File Khach Hang Moi Thanh Cong");
                readf.createNewFile();
            }
            try(BufferedReader br=Files.newBufferedReader(readf.toPath(),StandardCharsets.UTF_8)){
                boolean empty=true;
                String line;
                while ((line=br.readLine())!=null){
                    empty=false;
                    String[] info=line.split("\\|");
                    if(info.length==9){
                        String maNV=info[0].trim();
                        String hoNV=info[1].trim();
                        String tenNV=info[2].trim();
                        String chucvuNv=info[3].trim();
                        String ngaySinhNV=info[4].trim();
                        String gioitinh=info[5].trim();
                        String sdt=info[6].trim();
                        String diachi=info[7].trim();
                        Double luong=Double.parseDouble(info[7].trim());
                        
                        if(!kiemTraTonTai(maNV)){
                            dsNV=Arrays.copyOf(dsNV, size+1);
                            dsNV[size]=new NhanVien(maNV,hoNV,tenNV,chucvuNv,ngaySinhNV,gioitinh,sdt,diachi,luong);
                            System.err.print("\n╔══════════════════════════════════════════\n");
                            System.err.printf("║ Ma Nhan Vien  %s  Da Them      \n",maNV);
                            System.err.print("╚══════════════════════════════════════════");
                            size++;
                            
                        }else{
                            System.err.print("\n╔══════════════════════════════════════════\n");
                            System.err.printf("║ Ma Nhan Vien  %s  Da Co      \n",maNV);
                            System.err.print("╚══════════════════════════════════════════");
                        }
                    }else{
                        System.out.println("Du Lieu Khong Hop Le: " + line);
                    }
                }
                if (empty) {
                    System.out.println("\nFILE EMPTY WITH NOTHING");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
}

    @Override
    public void ghiFile() {
        try {
            PrintWriter pw=new PrintWriter("KhachHang_Output.txt","UTF-8");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            for (NhanVien nv : dsNV) {
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
