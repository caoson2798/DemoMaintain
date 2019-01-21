package com.example.daiphongpc.demomaintain.Model;

public class Custommer {
    private String numberPhone;
    private String bienXe;

    public Custommer(String numberPhone, String bienXe) {
        this.numberPhone = numberPhone;
        this.bienXe = bienXe;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getBienXe() {
        return bienXe;
    }

    public void setBienXe(String bienXe) {
        this.bienXe = bienXe;
    }

    @Override
    public String toString() {
        return numberPhone+"\n"+bienXe;
    }
}
