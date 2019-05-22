package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.model.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairRepo {

    @Autowired
    JdbcTemplate template;

    public List<Repair> fetchAllRepair(){

        String sql = "SELECT * FROM repair";

        RowMapper<Repair> rowMapper = new BeanPropertyRowMapper<>(Repair.class);

        return template.query(sql, rowMapper);
    }
    public void addRepair(Repair repair){
        String sql = "INSERT INTO repair (idRepair, description, model, serial_number, system_version, password, first_name, last_name, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        template.update(sql, repair.getIdRepair(), repair.getDescription(), repair.getModel(), repair.getSerial_number(), repair.getSystem_version(), repair.getPassword(), repair.getFirst_name(), repair.getLast_name(), repair.getPhone(), repair.getEmail());
    }

    public void deleteRepair(int id){
        String sql = "DELETE FROM repair WHERE idRepair="+id;

        template.update(sql);
    }

    public Repair findRepairById(int id){

        String sql = "SELECT * FROM repair WHERE idRepair=?";

        RowMapper<Repair> rowMapper = new BeanPropertyRowMapper<>(Repair.class);

        return template.queryForObject(sql, rowMapper, id);
    }

    public void updateRepair(Repair repair){

        String sql ="UPDATE repair SET description=?, model=?, serial_number=?, system_version=?, password=?, first_name=?, last_name=?, phone=?, email=? WHERE IdRepair=?";

        template.update(sql, repair.getDescription(), repair.getModel(), repair.getSerial_number(),repair.getSystem_version(), repair.getPassword(), repair.getFirst_name(), repair.getLast_name(), repair.getPhone(), repair.getEmail(), repair.getIdRepair());
    }

}
