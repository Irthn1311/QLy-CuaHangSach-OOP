package QuanLySach;

// Lớp trừu tượng SanPham
public abstract class SanPham {
    protected String maSP;
    protected String tenSP;
    protected double giaBan;

    public SanPham(String maSP, String tenSP, double giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
    }

    // Phương thức trừu tượng
    public abstract double tinhGia();

    // Các phương thức getter và setter
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
}