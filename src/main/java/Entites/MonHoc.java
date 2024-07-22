package Entites;

import java.io.Serializable;
import java.util.Currency;

public class MonHoc implements Serializable {
    private static int Count = 100;
    private int maMH;
    private String tenMon;
    private int soDonViHT;
    private String loaiMon;

    public MonHoc(String loaiMon, int soDonViHT, String tenMon) {
        this.maMH = Count++;
        this.loaiMon = loaiMon;
        this.soDonViHT = soDonViHT;
        this.tenMon = tenMon;
    }

    public MonHoc() {
    }

    public int getMaMH() {
        return maMH;
    }

    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoDonViHT() {
        return soDonViHT;
    }

    public void setSoDonViHT(int soDonViHT) {
        this.soDonViHT = soDonViHT;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "maMH=" + maMH +
                ", tenMon='" + tenMon + '\'' +
                ", soDonViHT=" + soDonViHT +
                ", loaiMon='" + loaiMon + '\'' +
                '}';
    }
}
