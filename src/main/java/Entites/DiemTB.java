package Entites;

import java.io.Serializable;

public class DiemTB implements Serializable {
    private int MaSV;
    private String Name;
    private double DiemTB;

    public DiemTB() {
    }

    public DiemTB(int maSV, double diemTB, String name) {
        MaSV = maSV;
        DiemTB = diemTB;
        Name = name;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int maSV) {
        MaSV = maSV;
    }

    public double getDiemTB() {
        return DiemTB;
    }

    public void setDiemTB(double diemTB) {
        DiemTB = diemTB;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "DiemTB{" +
                "MaSV=" + MaSV +
                ", Name='" + Name + '\'' +
                ", DiemTB=" + DiemTB +
                '}';
    }
}
