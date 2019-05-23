package dat18c.modulopgave.efix.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reparationspriser {

    @Id
    private int idReparationspriser;
    private String brand;
    private String model;
    private String tid;
    private String beskrivelse;
    private int pris;

    public Reparationspriser() {

    }

    public Reparationspriser(int idReparationspriser, String brand, String model, String tid, String beskrivelse, int pris) {
        this.idReparationspriser = idReparationspriser;
        this.brand = brand;
        this.model = model;
        this.tid = tid;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }

    public int getIdReparationspriser() {
        return idReparationspriser;
    }

    public void setIdReparationspriser(int idReparationspriser) {
        this.idReparationspriser = idReparationspriser;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
