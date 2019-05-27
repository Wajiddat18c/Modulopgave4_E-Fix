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
public class Repair {

    @Id
    private int idRepair;
    private String description;
    private String model;
    private String serial_number;
    private String system_version;
    private String password;
    private String first_name;
    private String last_name;
    private int phone;
    private String email;

    public Repair() {
    }

    public Repair(int idRepair, String description, String model, String serial_number, String system_version, String password, String first_name, String last_name, int phone, String email) {
        this.idRepair = idRepair;
        this.description = description;
        this.model = model;
        this.serial_number = serial_number;
        this.system_version = system_version;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
    }

    public int getIdRepair() {
        return idRepair;
    }

    public void setIdRepair(int idRepair) {
        this.idRepair = idRepair;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getSystem_version() {
        return system_version;
    }

    public void setSystem_version(String system_version) {
        this.system_version = system_version;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
