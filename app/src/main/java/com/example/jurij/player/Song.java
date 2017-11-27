package com.example.jurij.player;

/**
 * Created by Jurij on 20. 11. 2017.
 */

public class Song {
    private String naslov;
    private String avtor;
    private String dolzina;
    private String zvrst;
    private String path;

    public  Song(){
        this.naslov="null";
        this.avtor="null";
        this.dolzina="null";
        this.zvrst="null";
    }

    public Song(String Naslov, String Avtor, String Dolzina, String Zvrst, String pot) {
        this.naslov = Naslov;
        this.avtor = Avtor;
        this.zvrst = Zvrst;
        this.dolzina=Dolzina;
        this.path=pot;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getAvtor() {
        return avtor;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    public String getDolzina() {
        return dolzina;
    }

    public void setDolzina(String dolzina) {
        this.dolzina = dolzina;
    }

    public String getZvrst() {
        return zvrst;
    }

    public void setZvrst(String zvrst) {
        this.zvrst = zvrst;
    }
}
