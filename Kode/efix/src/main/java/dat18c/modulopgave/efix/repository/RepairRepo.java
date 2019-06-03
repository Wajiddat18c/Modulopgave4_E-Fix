/**
 * dat18c.modulopgave.efix.repository
 */
package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is a Repository class that handles Sql quarries.
 * @author Thomas Broe
 */
@Repository
public class RepairRepo implements Crud<Repair> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Repair> fetchAll() {

        String sql = "SELECT * FROM repair";

        RowMapper<Repair> rowMapper = new BeanPropertyRowMapper<>(Repair.class);

        return template.query(sql, rowMapper);
    }

    @Override
    public void addItem(Repair repair) {
        String sql = "INSERT INTO repair (idRepair, description, model, serial_number, system_version, password, first_name, last_name, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        template.update(sql, repair.getIdRepair(), repair.getDescription(), repair.getModel(), repair.getSerial_number(), repair.getSystem_version(), repair.getPassword(), repair.getFirst_name(), repair.getLast_name(), repair.getPhone(), repair.getEmail());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM repair WHERE idRepair=?";

        template.update(sql, id);
    }

    @Override
    public Repair findById(int id) {

        String sql = "SELECT * FROM repair WHERE idRepair=?";

        RowMapper<Repair> rowMapper = new BeanPropertyRowMapper<>(Repair.class);

        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void update(Repair repair) {

        String sql = "UPDATE repair SET description=?, model=?, serial_number=?, system_version=?, password=?, first_name=?, last_name=?, phone=?, email=? WHERE IdRepair=?";

        template.update(sql, repair.getDescription(), repair.getModel(), repair.getSerial_number(), repair.getSystem_version(), repair.getPassword(), repair.getFirst_name(), repair.getLast_name(), repair.getPhone(), repair.getEmail(), repair.getIdRepair());
    }

}
