/**
 * dat18c.modulopgave.efix.model
 */
package dat18c.modulopgave.efix.model;

import javax.persistence.Id;

/**
 * This class defines data structure.
 */
public class Kategori {
    @Id
    private int idKategori;
    private String navn;

    public Kategori() {
    }

    public Kategori(int idKategori, String navn) {
        this.idKategori = idKategori;
        this.navn = navn;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
