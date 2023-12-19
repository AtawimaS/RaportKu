package com.oop.dashboard;

public class ModelData {

    private String semester;
    private int matematika;
    private int ipa;
    private int ips;
    private int bin;
    private int big;
    private float rerataSemester;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getMatematika() {
        return matematika;
    }

    public void setMatematika(int matematika) {
        this.matematika = matematika;
    }

    public int getIpa() {
        return ipa;
    }

    public void setIpa(int ipa) {
        this.ipa = ipa;
    }

    public int getIps() {
        return ips;
    }

    public void setIps(int ips) {
        this.ips = ips;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public int getBig() {
        return big;
    }

    public void setBig(int big) {
        this.big = big;
    }

    public float getRerataSemester() {
        return rerataSemester;
    }

    public void setRerataSemester(float rerataSemester) {
        this.rerataSemester = rerataSemester;
    }

    public ModelData(String semester, int matematika, int ipa, int ips, int bin, int big, float rerataSemester) {
        this.semester = semester;
        this.matematika = matematika;
        this.ipa = ipa;
        this.ips = ips;
        this.bin = bin;
        this.big = big;
        this.rerataSemester = rerataSemester;
    }

    public ModelData() {
    }
}
