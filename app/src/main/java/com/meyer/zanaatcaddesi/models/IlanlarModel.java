package com.meyer.zanaatcaddesi.models;

public class IlanlarModel {
    String baslik;
    String aciklama;
    String konum;
    String kategori;

    String img_url_1;
    String img_url_2;
    String img_url_3;
    int fiyat;


    public IlanlarModel(String baslik, String aciklama, String konum, String kategori, String img_url_1, String img_url_2, String img_url_3, int fiyat) {
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.konum = konum;
        this.kategori = kategori;
        this.img_url_1 = img_url_1;
        this.img_url_2 = img_url_2;
        this.img_url_3 = img_url_3;
        this.fiyat = fiyat;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getImg_url_1() {
        return img_url_1;
    }

    public void setImg_url_1(String img_url_1) {
        this.img_url_1 = img_url_1;
    }

    public String getImg_url_2() {
        return img_url_2;
    }

    public void setImg_url_2(String img_url_2) {
        this.img_url_2 = img_url_2;
    }

    public String getImg_url_3() {
        return img_url_3;
    }

    public void setImg_url_3(String img_url_3) {
        this.img_url_3 = img_url_3;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
