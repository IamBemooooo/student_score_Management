package Entites;

import java.io.Serializable;

public class BangDiem implements Serializable {
    private int idMH;
    private int idSV;
    private int Diem;

    public BangDiem() {
    }

    public BangDiem(int idMH, int diem, int idSV) {
        this.idMH = idMH;
        this.Diem = diem;
        this.idSV = idSV;
    }

    public int getIdMH() {
        return idMH;
    }

    public void setIdMH(int idMH) {
        this.idMH = idMH;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int diem) {
        Diem = diem;
    }

    @Override
    public String toString() {
        return "BangDiem{" +
                "idMH=" + idMH +
                ", idSV=" + idSV +
                ", Diem=" + Diem +
                '}';
    }
}
