package QuanLyPhieuNhapHang;
public class Main {
    public void Menu(){
        System.out.print("\n1.Bang danh sach chi tiet phieu nhap hang");
        System.out.print("\n2.Bang danh sach phieu nhap hang");
    }
    public static void main(String[] args) {
        DanhSachCTPNH menu= new DanhSachCTPNH();
        menu.menu();
    }
}
