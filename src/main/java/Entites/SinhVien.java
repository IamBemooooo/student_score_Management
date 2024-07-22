package Entites;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private static int Count = 100;
    private int maSV;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String lop;

    public SinhVien(String lop, String sdt, String diaChi, String hoTen) {
        this.maSV = Count++;
        this.lop = lop;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.hoTen = hoTen;
    }

    public SinhVien() {
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV=" + maSV +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", lop='" + lop + '\'' +
                '}';
    }
}
