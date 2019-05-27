/**
 * dat18c.modulopgave.efix.model
 */
package dat18c.modulopgave.efix.model;
/** This class defines data structure.
 *
 */
public class SearchResults {
    private String produktNavn;
    private String kategoriNavn;
    private String beskrivelse;
    private int idProdukter;
    private int pris;

    public SearchResults() {
    }

    public String getProduktNavn() {
        return produktNavn;
    }

    public void setProduktNavn(String produktNavn) {
        this.produktNavn = produktNavn;
    }

    public String getKategoriNavn() {
        return kategoriNavn;
    }

    public void setKategoriNavn(String kategoriNavn) {
        this.kategoriNavn = kategoriNavn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getIdProdukter() {
        return idProdukter;
    }

    public void setIdProdukter(int idProdukter) {
        this.idProdukter = idProdukter;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public SearchResults(String produktNavn, String kategoriNavn, String beskrivelse, int idProdukter, int pris) {
        this.produktNavn = produktNavn;
        this.kategoriNavn = kategoriNavn;
        this.beskrivelse = beskrivelse;
        this.idProdukter = idProdukter;
        this.pris = pris;
    }
}
