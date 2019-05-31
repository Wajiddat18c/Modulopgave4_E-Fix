package dat18c.modulopgave.efix.model;

import javax.persistence.Id;

public class Betingelse {
    @Id
    int idbetingelser;
    String indhold;

    public int getIdbetingelser() {
        return idbetingelser;
    }

    public void setIdbetingelser(int idbetingelser) {
        this.idbetingelser = idbetingelser;
    }

    public String getIndhold() {
        return indhold;
    }

    public void setIndhold(String indhold) {
        this.indhold = indhold;
    }

    public Betingelse() {
    }

    public Betingelse(int id, String indhold) {
        this.idbetingelser = id;
        this.indhold = indhold;
    }
}
