import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class DSSach implements CRUD {
    Sach[] run;
    Scanner sc=new Scanner(System.in);
    private int size=3;

    public DSSach(){
        run= new Sach[3];
        run[0] = new Sach("S001", "Luoc Su Loai Nguoi","TG001","NXB001","Lich Su va Triet Hoc",13000.0,100);
        run[1] = new SachThamKhao("S002", "Dac Nhan Tam","TG002","NXB001","Ky Nang Song",15000.0,87,"Ky Nang Xa Hoi,Tam Ly Hoc, Lanh Dao Va Quan Ly",16);
        run[2] = new SachChuyenNganh("S003", "Giai Tich","TG003","NXB002","Toan Hoc Va Giai Tich",20000.0,99,"Toan Hoc");
    }

    @Override
    public void xem() {
        boolean checks=false;
        System.out.print("\nThong Tin Cua Nhan Vien");
        for(Sach s: run){
            if( s !=null){
                s.xuat();
                checks=true;
            }
        }
        if(!checks){
            System.out.print("\nKhông có quyền sách nào trong danh sách!!!");
        }
    }

    @Override
    public void them(){
        for(int i=0;i<run.length;i++){
            if(run[i]==null){
                run[i]=new Sach();
                run[i].nhap();
                size++;
                return;
            }
        }
        if(size==run.length){
            Sach[] newRun= new Sach[run.length+1];
            for(int i=0;i<run.length;i++){
                if(run[i]!= null){
                    newRun[i]=run[i];
                }
            }
            run=newRun;
        }
        run[size]=new Sach();
        run[size].nhap();
        size++;
    }

    @Override
    public void sua() {
        boolean bookFound=false;
        System.out.print("\nNhap Ma Sach Can Sua: ");
        String checked = sc.nextLine();
        for(Sach s: run){
            if(s !=null && checked.equals(s.getMaSach())){
                s.nhap();
                bookFound=true;
                break;
            }
        }
        if (!bookFound) {
            System.out.print("\nKHONG TIM THAY MA NHAN VIEN: "+checked);
        } else {
            System.out.print("\nCHINH SUA THONG TIN NHAN VIENTHANH CONG!!!");
        } 
    }

    @Override
    public void xoa(){
        boolean bookFound=false;
        System.out.print("\nNhap Ma Sach Can Xoa: ");
        String checked=sc.nextLine();
        for(int i=0;i<run.length;i++){
            if(run[i]!=null && checked.equals(run[i].getMaSach())){
                run[i]=null;
                bookFound=true;
                size--;
                break;
            }
        }
        if (!bookFound) {
            System.out.print("\nKHONG TIM THAY MA SACH: "+checked);
        } else {
            System.out.print("\nXOA THONG TIN SACH THANH CONG!!!");
        } 
    }   

    @Override
    public void timkiem() {
		@SuppressWarnings("resource")
        int find;
        do {
            System.out.println("\nLua Chọn Tìm Kiếm:");
            System.out.println("1. Tìm Kiếm Theo Mã Sách");
            System.out.println("2. Tìm Kiếm Theo Tên Sách");
            System.out.println("3. Tìm Kiếm Theo Tác Giả");
            System.out.println("0. Thoát");
            System.out.print("Lua Chọn Của Bạn: ");
            find = sc.nextInt();
            sc.nextLine();
            switch (find) {
                case 1:
                    boolean bookFound1 = false;
                    System.out.print("\nNhập Mã Sách Cần Tìm Kiếm: ");
                    String checked1 = sc.nextLine();
                    for (int i = 0; i < run.length; i++) {
                        if (run[i] != null && checked1.equals(run[i].getMaSach())) {
                            run[i].xuat();
                            bookFound1 = true;
                            break;
                        }
                    }
                    if (!bookFound1) {
                        System.out.println("\nKhông Tìm Thấy Mã Sách: " + checked1);
                    }
                    break;
                case 2:
                    boolean bookFound2 = false;
                    System.out.print("\nNhập Tên Sách Cần Tìm Kiếm: ");
                    String checked2 = sc.nextLine().toLowerCase();
                    for (int i = 0; i < run.length; i++) {
                        if (run[i] != null && run[i].getTenSach().toLowerCase().contains(checked2)) {
                            run[i].xuat();
                            bookFound2 = true;
                        }
                    }
                    if (!bookFound2) {
                        System.out.println("\nKhông Tìm Thấy Tên Sách: " + checked2);
                    }
                    break;
                case 3:
                    boolean bookFound3 = false;
                    System.out.print("\nNhập  Mã Tác Giả Cần Tìm Kiếm: ");
                    String checked3 = sc.nextLine().toLowerCase();
                    for (int i = 0; i < run.length; i++) {
                        if (run[i] != null && run[i].getMaTacGia().toLowerCase().contains(checked3)) {
                            run[i].xuat();
                            bookFound3 = true;
                        }
                    }
                    if (!bookFound3) {
                        System.out.println("\nKhông Tìm Thấy Tác Giả: " + checked3);
                    }
                    break;
                case 0:
                    System.out.println("Thoát thành công.");
                    break;
                default:
                    System.out.println("\nNhập Sai! Vui Lòng Nhập Lại.");
                    break;
            }
        } while (find != 0);
    }

    @Override
    public void thongke() {
		@SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLua Chon Thong Ke:");
            System.out.println("1. Thong Ke So Luong Sach Theo The Loai");
            System.out.println("2. Thong Ke So Luong Sach Theo Tac Gia");
            System.out.println("3. Thong Ke So Luong Sach Theo Nha Xuat an");
            System.out.println("4. Thong Ke So Luong Sach Theo Gia Ban");
            System.out.println("0. Thoát");
            System.out.print("\nLua Chon Cua Ban: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    String[] theloai= new String[100];
                    int[] soluongTL=new int[100];
                    int visitTL=0;
                    for(int i=0;i<run.length;i++){
                        if (run[i]!=null){
                            boolean find=false;
                            for (int j=0;j<visitTL;j++){
                                if(run[i].getTheLoai().equalsIgnoreCase(theloai[j])){
                                    soluongTL[j]++;
                                    find=true;
                                    break;
                                }
                            }
                            if(!find){
                                theloai[visitTL]=run[i].getTheLoai();
                                soluongTL[visitTL]=1;
                                visitTL++;
                            }
                        }
                    }
                    System.out.println("\nThống Kê Số Lượng Sách Theo Thể Loại:");
                    for (int i = 0; i < visitTL; i++) {
                        System.out.println(theloai[i] + ": " + soluongTL[i]);
                    }
                    break;

                    
                case 2:
                    String[] tacgia = new String[100];
                    int[] soluongTG = new int[100];
                    int visitTG = 0;
                    for (int i = 0; i < run.length; i++) {
                        if(run[i] !=null){
                            boolean find = false;
                            for (int j = 0; j < visitTG; j++) {
                                if (run[i]!=null && run[i].getMaTacGia().equalsIgnoreCase(tacgia[j])) {
                                    soluongTG[j]++;
                                    find = true;
                                    break;
                                }
                            }
                            if (!find) {
                                tacgia[visitTG] = run[i].getMaTacGia();
                                soluongTG[visitTG] = 1;
                                visitTG++;
                            }
                        }
                    }
                    System.out.println("\nThống Kê Số Lượng Sách Theo Tác Giả:");
                    for (int i = 0; i < visitTG; i++) {
                        System.out.println(tacgia[i] + ": " + soluongTG[i]);
                    }
                    break;
                case 3:
                    String[] nxb = new String[100];
                    int[] soLuongNXB = new int[100];
                    int visitNXB = 0;
                    for (int i = 0; i < run.length; i++) {
                        if(run[i]!=null){
                            boolean find = false;
                            for (int j = 0; j < visitNXB; j++) {
                                if (run[i]!=null && run[i].getMaNXB().equalsIgnoreCase(nxb[j])) {
                                    soLuongNXB[j]++;
                                    find = true;
                                    break;
                                }
                            }
                            if (!find) {
                                nxb[visitNXB] = run[i].getMaNXB();
                                soLuongNXB[visitNXB] = 1;
                                visitNXB++;
                            }
                        }
                    }
                    System.out.println("\nThống Kê Số Lượng Sách Theo Nhà Xuất Bản:");
                    for (int i = 0; i < visitNXB; i++) {
                        System.out.println(nxb[i] + ": " + soLuongNXB[i]);
                    }
                    break;
                case 4:
                    System.out.print("\nNhập Giá Tiền Cần Thống Kê: ");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    int countOver = 0;
                    int countUnder = 0;
                    for (int i = 0; i < run.length; i++) {
                        if(run[i] !=null){
                            if (run[i].getDonGiaBan() > x) {
                                countOver++;
                            }
                            if (run[i].getDonGiaBan() < x) {
                                countUnder++;
                            }
                        }    
                    }
                    System.out.println("\nSố Lượng Sách Có Giá Trên " + x + ": " + countOver);
                    System.out.println("Số Lượng Sách Có Giá Dưới " + x + ": " + countUnder);
                    break;
                case 0:
                    System.out.println("Thoát thành công.");
                    break;
                default:
                    System.out.println("\nNhập Sai! Vui Lòng Nhập Lại.");
                    break;
            }
        } while (choice != 0);
    }

    

    @Override
    public void docFile() {
        File readf = new File("sach.txt");
        try {
            if (!readf.exists()) {
                System.out.print("FILE MOI DA DUOC TAO");
                readf.createNewFile();
            }
            try (BufferedReader br = Files.newBufferedReader(readf.toPath(), StandardCharsets.UTF_8)) {
                boolean empty = true;
                String line;
                while ((line = br.readLine()) != null) {
                    empty = false;
                    String[] info = line.split("\\|");
                    if (info.length == 7 || info.length == 8 || info.length == 9) {
                        String maSach = info[0].trim();
                        String tenSach = info[1].trim();
                        String maTacGia = info[2].trim();
                        String maNXB = info[3].trim();
                        String theLoai = info[4].trim();
                        Double donGiaBan = Double.parseDouble(info[5].trim());
                        int soLuongSachHienCo = Integer.parseInt(info[6].trim());
                        
                        String monChuyenNganh = null;
                        String linhVuc = null;
                        int doTuoi = 0;
    
                        if (info.length == 8) {
                            monChuyenNganh = info[7].trim();
                        }
    

                        if (info.length == 9) {
                            linhVuc = info[7].trim(); 
                            doTuoi = Integer.parseInt(info[8].trim()); 
                        }
    
                        if (size == run.length) {
                            Sach[] newRun = new Sach[run.length + 1];
                            for(int j=0;j<run.length;j++){
                                if(run[j]!=null){
                                    newRun[j]=run[j];
                                }
                            }
                            run = newRun;
                        }
    
                        if (info.length == 7) {
                            run[size] = new Sach(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo);
                        } else if (info.length == 8) {
                            run[size] = new SachChuyenNganh(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo, monChuyenNganh);
                        } else if (info.length == 9) {
                            run[size] = new SachThamKhao(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo, linhVuc, doTuoi);
                        }
    
                        size++; 
                    } else {
                        System.out.println("Dữ liệu không hợp lệ: " + line);
                    }
                }
    
                if (empty) {
                    System.out.println("\nFILE RONG");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void ghiFile() {
        try {
            PrintWriter pw=new PrintWriter("NhanVien_Input.txt");
            for(Sach s:run){
                String line=s.getMaSach() + " | " + s.getTenSach() + " | " + s.getMaTacGia() + " | " + s.getMaNXB() + " | "
                + s.getTheLoai() + " | " + s.getDonGiaBan() + " | " + s.getSoLuongSachHienCo();
                pw.println(line);
            }            
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}