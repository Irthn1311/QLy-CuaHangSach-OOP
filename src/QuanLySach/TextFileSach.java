package QuanLySach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileSach {
    public void readFile() {
        String fileName = "sach.txt";
        try (BufferedReader br = new BufferedReader(new FileReader("data/" + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                String maSach = info[0].trim();
                String tenSach = info[1].trim();
                String maTacGia = info[2].trim();
                String maNXB = info[3].trim();
                String theLoai = info[4].trim();
                double donGiaBan = Double.parseDouble(info[5].trim());
                int soLuongSachHienCo = Integer.parseInt(info[6].trim());

                Sach sach;
                if (theLoai.equalsIgnoreCase("Chuyen Nganh")) {
                    String monChuyenNganh = info[7].trim();
                    sach = new SachChuyenNganh(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo, monChuyenNganh);
                } else if (theLoai.equalsIgnoreCase("Tham Khao")) {
                    String linhVuc = info[7].trim();
                    int doTuoi = Integer.parseInt(info[8].trim());
                    sach = new SachThamKhao(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo, linhVuc, doTuoi);
                } else {
                    sach = new Sach(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo);
                }

                sach.xuat();
                System.out.println("----------");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void writeFile(String fileName, Sach sach) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/" + fileName, true))) {
            bw.write(sach.getMaSach() + "|" + sach.getTenSach() + "|" + sach.getMaTacGia() + "|" + sach.getMaNXB() + "|" + sach.getTheLoai() + "|" + sach.getDonGiaBan() + "|" + sach.getSoLuongSachHienCo());

            if (sach instanceof SachChuyenNganh) {
                bw.write("|" + ((SachChuyenNganh) sach).getMonChuyenNganh());
            } else if (sach instanceof SachThamKhao) {
                bw.write("|" + ((SachThamKhao) sach).getLinhVuc() + "|" + ((SachThamKhao) sach).getDoTuoi());
            } else {
                bw.write("| |0");
            }
            bw.write("\n----------\n");
        }
    }
}