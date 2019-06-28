package projekt.kkubizszyn.myapplication;

import android.util.Log;

import java.io.Serializable;

class Temat implements Serializable {
    private static final String TAG = "Temat";

    private static final long serialVersionUID = 1L;
    private String kategoria;
    private String tytul;
    private String opis_dł;
    private String opis_kr;

    public Temat() {
    }

    public Temat(String kategoria, String tytul, String opis_dl, String opis_kr) {
        this.kategoria = kategoria;
        this.tytul = tytul;
        this.opis_dł = opis_dl;
        this.opis_kr = opis_kr;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }


    public void setOpis_dł(String opis_dł) {
        this.opis_dł = opis_dł;
    }

    public void setOpis_kr(String opis_kr) {
        this.opis_kr = opis_kr;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getTytul() {
        return tytul;
    }


    public String getOpis_dł() {
        return opis_dł;
    }

    public String getOpis_kr() {
        return opis_kr;
    }

}
