package QuanLySach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileSach {
    public void readFile(String fileName) {
        try {
            FileInputStream f = new FileInputStream("data/" + fileName);
            DataInputStream inStream = new DataInputStream(f);
            try {
                while (true) {
                    String maSach = inStream.readUTF();
                    String tenSach = inStream.readUTF();
                    String maTacGia = inStream.readUTF();
                    String maNXB = inStream.readUTF();
                    String theLoai = inStream.readUTF();
                    double donGiaBan = inStream.readDouble();
                    int soLuongSachHienCo = inStream.readInt();

                    Sach sach;
                    if (theLoai.equalsIgnoreCase("Chuyen Nganh")) {
                        String monChuyenNganh = inStream.readUTF();
                        sach = new SachChuyenNganh(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo, monChuyenNganh);
                    } else if (theLoai.equalsIgnoreCase("Tham Khao")) {
                        String linhVuc = inStream.readUTF();
                        int doTuoi = inStream.readInt();
                        sach = new SachThamKhao(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo, linhVuc, doTuoi);
                    } else {
                        inStream.readUTF(); // Skip empty string
                        inStream.readInt(); // Skip zero
                        sach = new Sach(maSach, tenSach, maTacGia, maNXB, theLoai, donGiaBan, soLuongSachHienCo);
                    }

                    sach.xuat();
                    String separator = inStream.readUTF();
                    System.out.println(separator);
                }
            } catch (EOFException e) {
                // Kết thúc file
            } finally {
                inStream.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void writeFile(String fileName, Sach sach) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("data/" + fileName, true));
        outStream.writeUTF(sach.getMaSach());
        outStream.writeUTF(sach.getTenSach());
        outStream.writeUTF(sach.getMaTacGia());
        outStream.writeUTF(sach.getMaNXB());
        outStream.writeUTF(sach.getTheLoai());
        outStream.writeDouble(sach.getDonGiaBan());
        outStream.writeInt(sach.getSoLuongSachHienCo());

        if (sach instanceof SachChuyenNganh) {
            outStream.writeUTF(((SachChuyenNganh) sach).getMonChuyenNganh());
        } else if (sach instanceof SachThamKhao) {
            outStream.writeUTF(((SachThamKhao) sach).getLinhVuc());
            outStream.writeInt(((SachThamKhao) sach).getDoTuoi());
        } else {
            outStream.writeUTF("");
            outStream.writeInt(0);
        }
        outStream.writeUTF("----------");
        outStream.close();
    }
}