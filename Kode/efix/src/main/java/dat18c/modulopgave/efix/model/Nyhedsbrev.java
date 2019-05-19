package dat18c.modulopgave.efix.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nyhedsbrev {

    @Id
    private int idNyhedsbrev;
    private String eMail;

    public Nyhedsbrev() {
    }

    public Nyhedsbrev(int idNyhedsbrev, String eMail) {
        this.idNyhedsbrev = idNyhedsbrev;
        this.eMail = eMail;
    }

    public int getIdNyhedsbrev() {
        return idNyhedsbrev;
    }

    public void setIdNyhedsbrev(int idNyhedsbrev) {
        this.idNyhedsbrev = idNyhedsbrev;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
