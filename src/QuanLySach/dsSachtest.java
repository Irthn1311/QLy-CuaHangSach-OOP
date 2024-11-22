package QuanLySach;

import java.util.Scanner;

public class dsSach {
    public void them(){
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("\nNhap so luong sach: ");
        n=sc.nextInt();
        Sach[] s=new Sach[n];
        for(int i=0;i<n;i++){
            System.out.print("\nNhap loai sach(1: sach tham khao, 2: sach chuyen nganh): ");
            int chon=sc.nextInt();
            if(chon==1){
                s[i]=new SachThamKhao();
            }
            else{
                s[i]=new SachChuyenNganh();
            }
            s[i].nhap();
        }
        for(int i=0;i<n;i++){
            s[i].xuat();
        }
    }

    public void xuat(){
        System.out.println("Danh sach sach: ");
    }
}
