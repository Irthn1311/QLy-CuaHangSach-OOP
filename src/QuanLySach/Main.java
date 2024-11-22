package QuanLySach;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "sach.dat";
        BinaryFileSach binaryFileSach = new BinaryFileSach();

        // Tạo các đối tượng Sach và gán giá trị
        Sach sach1 = new Sach();
        sach1.setMaSach("S001");
        sach1.setTenSach("Lập Trình Java");
        sach1.setMaTacGia("TG001");
        sach1.setMaNXB("NXB001");
        sach1.setTheLoai("Giáo Trình");
        sach1.setDonGiaBan(50000);
        sach1.setSoLuongSachHienCo(100);

        SachChuyenNganh sach2 = new SachChuyenNganh();
        sach2.setMaSach("S002");
        sach2.setTenSach("Lập Trình C++");
        sach2.setMaTacGia("TG002");
        sach2.setMaNXB("NXB002");
        sach2.setTheLoai("Chuyen nganh");
        sach2.setDonGiaBan(60000);
        sach2.setSoLuongSachHienCo(150);
        sach2.setMonChuyenNganh("Khoa Học Máy Tính");

        SachThamKhao sach3 = new SachThamKhao();
        sach3.setMaSach("S003");
        sach3.setTenSach("Lập Trình Python");
        sach3.setMaTacGia("TG003");
        sach3.setMaNXB("NXB003");
        sach3.setTheLoai("Tham Khao");
        sach3.setDonGiaBan(70000);
        sach3.setSoLuongSachHienCo(200);
        sach3.setLinhVuc("Tu Nhien");
        sach3.setDoTuoi(18);

        // Ghi các đối tượng vào file
        binaryFileSach.writeFile(fileName, sach1);
        binaryFileSach.writeFile(fileName, sach2);
        binaryFileSach.writeFile(fileName, sach3);

        // Đọc các đối tượng từ file và hiển thị thông tin
        binaryFileSach.readFile(fileName);
    }
}