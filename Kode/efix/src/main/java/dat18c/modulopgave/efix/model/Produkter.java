package dat18c.modulopgave.efix.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produkter {

    @Id
    private int idProdukter;
    private String navn;
    private int pris;
    private String beskrivelse;
    private int Kategori_idKategori;

    public Produkter() {
    }

    public Produkter(int idProdukter, String navn, int pris, String beskrivelse, int kategori_idKategori) {
        this.idProdukter = idProdukter;
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
        Kategori_idKategori = kategori_idKategori;
    }

    public int getIdProdukter() {
        return idProdukter;
    }

    public void setIdProdukter(int idProdukter) {
        this.idProdukter = idProdukter;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getKategori_idKategori() {
        return Kategori_idKategori;
    }

    public void setKategori_idKategori(int kategori_idKategori) {
        Kategori_idKategori = kategori_idKategori;
    }
}
