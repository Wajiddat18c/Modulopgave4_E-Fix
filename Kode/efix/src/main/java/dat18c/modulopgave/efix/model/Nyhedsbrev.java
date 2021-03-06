/**
 * dat18c.modulopgave.efix.model
 */
package dat18c.modulopgave.efix.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class defines data structure.
 * @author Wajid Ahmad
 */
@Entity
public class Nyhedsbrev {

    @Id
    private int idNyhedsbrev;
    private String eMail;
    private boolean acceptPP;

    public Nyhedsbrev(int idNyhedsbrev, String eMail, boolean acceptPP) {
        this.idNyhedsbrev = idNyhedsbrev;
        this.eMail = eMail;
        this.acceptPP = acceptPP;
    }

    public Nyhedsbrev() {
    }

    public Nyhedsbrev(int idNyhedsbrev, String eMail) {
        this.idNyhedsbrev = idNyhedsbrev;
        this.eMail = eMail;
    }

    public boolean isAcceptPP() {
        return acceptPP;
    }

    public void setAcceptPP(boolean acceptPP) {
        this.acceptPP = acceptPP;
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
