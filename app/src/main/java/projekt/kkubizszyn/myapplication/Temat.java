package projekt.kkubizszyn.myapplication;

import java.io.Serializable;

class Temat implements Serializable {


    private static final long serialVersionUID = 1L;
    private String kategoria;
    private String tytul;
    private String zakres;
    private String opis_dł;
    private String opis_kr;

    public Temat(String kategoria, String tytul, String zakres, String opis_dl, String opis_kr) {
        this.kategoria = kategoria;
        this.tytul = tytul;
        this.zakres = zakres;
        this.opis_dł = opis_dl;
        this.opis_kr = opis_kr;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getTytul() {
        return tytul;
    }

    public String getZakres() {
        return zakres;
    }

    public String getOpis_dł() {
        return opis_dł;
    }

    public String getOpis_kr() {
        return opis_kr;
    }
}
