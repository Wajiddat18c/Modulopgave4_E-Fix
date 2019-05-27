/**
 * dat18c.modulopgave.efix.model
 */
package dat18c.modulopgave.efix.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/** This class defines data structure.
 *
 */
@Entity
public class Butik {

    @Id
    private int idButik;
    private String navn;
    private String adresse;
    private int mobilNummer;
    private String beskrivelse;
    private String aabningstider;
    private String email;

    public Butik() {
    }

    public Butik(int idButik, String navn, String adresse, int mobilNummer, String beskrivelse, String aabningstider, String email) {
        this.idButik = idButik;
        this.navn = navn;
        this.adresse = adresse;
        this.mobilNummer = mobilNummer;
        this.beskrivelse = beskrivelse;
        this.aabningstider = aabningstider;
        this.email = email;
    }

    public int getIdButik() {
        return idButik;
    }

    public void setIdButik(int idButik) {
        this.idButik = idButik;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getMobilNummer() {
        return mobilNummer;
    }

    public void setMobilNummer(int mobilNummer) {
        this.mobilNummer = mobilNummer;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getAabningstider() {
        return aabningstider;
    }

    public void setAabningstider(String aabningstider) {
        this.aabningstider = aabningstider;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
