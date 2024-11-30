package QuanLyPhieuNhapHang;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import Interface.CRUD;

public class DSPhieuNhapHang implements CRUD{
    private int size;
    private PhieuNhapHang[] listPNH;
    private Scanner sc=new Scanner(System.in);
    public DSPhieuNhapHang(int n){
       listPNH=new PhieuNhapHang[n];
       size=0;
    }
    @Override
    public void xem(){
       System.out.print("\n===============================");
        System.out.print("\nThong tin phieu nhap hang");
       for(int i=0;i<size;i++){
           listPNH[i].xuatPNH();
       }
       System.out.print("\n===============================");
    }

    @Override
    public void them(){
     System.out.print("\nNhap so luong ban muon them");
     int n=sc.nextInt();
      for(int i=0;i<n;i++){
         listPNH[i].nhapPNH();
         listPNH[size++]=new PhieuNhapHang();
      }
    }

    @Override
    public void sua(){
        while(true){
            System.out.print("\n");
        }
    }

    @Override
    public void xoa(){
        System.out.print("\nNhap ma sach can xoa");

    }
    
    @Override 
    public void timkiem(){
        System.out.print("\nNhap ma phieu nhap hang");
        String mapnh=sc.nextLine();
       
  
    }

    @Override
    public void thongke(){
        while (true) {
            System.out.print("\n==============Bang thong ke================");
            System.out.print("\n");
            
        }
      
    }
    
    @Override 
    public void docFile(){
        File file=new File("pnh.txt");
        System.out.print("\nFile:"+file.exists());
        try {
            
            
        } catch (Exception e) {
            System.out.print("\nLoi File!");
        }
    }

    @Override 
    public void ghiFile(){
   

    }

    public void Menu(){
       
        while (true) {
            System.out.print("\n-------------MenuOfPNH-------------------");
            System.out.print("\n1. Xem danh sach ");
            System.out.print("\n2. Them vao danh sach ");
            System.out.print("\n3. Sua trong danh sach ");
            System.out.print("\n4. Xoa trong danh sach ");
            System.out.print("\n5. Tim kiem trong danh sach ");
            System.out.print("\n6.Thong ke ");
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
                    System.out.print("\nThoat menu!");
                    ghiFile(); 
                    sc.close(); 
                default:
                    System.out.print("\nLoi lua chon!");
            }
        }
}
}
