package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.model.Produkter;
import dat18c.modulopgave.efix.model.Reparationspriser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReparationspriserRepo {

    @Autowired
    JdbcTemplate template;

    public List<Reparationspriser> fetchAllReparationspriser() {
        String sql = "SELECT * FROM REPARATIONSPRISER";
        RowMapper<Reparationspriser> rowMapper = new BeanPropertyRowMapper<>(Reparationspriser.class);

        return template.query(sql, rowMapper);
    }

    public Reparationspriser findReparationspriser(int id) {
        String sql = "SELECT * FROM REPARATIONSPRISER WHERE idReparationspriser=?";

        RowMapper<Reparationspriser> rowMapper = new BeanPropertyRowMapper<>(Reparationspriser.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public void addReparationspriser(Reparationspriser reparationspriser) {
        String sql = "INSERT INTO REPARATIONSPRISER(idReparationspriser, brand, model, tid, beskrivelse, pris) VALUES (?,?,?,?,?,?)";

        template.update(sql, reparationspriser.getIdReparationspriser(), reparationspriser.getBrand(), reparationspriser.getModel(), reparationspriser.getTid(), reparationspriser.getBeskrivelse(), reparationspriser.getPris());

    }

    public void deleteReparationspriser(int id){
        String sql = "DELETE FROM REPARATIONSPRISER WHERE idReparationspriser="+id;
        template.update(sql);
    }

    public void updateReparationspriser(Reparationspriser reparationspriser){
        String sql = "UPDATE REPARATIONSPRISER SET brand=?, model=?, tid=?, beskrivelse=?, pris=? WHERE idReparationspriser=?";
        template.update(sql, reparationspriser.getBrand(), reparationspriser.getModel(), reparationspriser.getTid(), reparationspriser.getBeskrivelse(), reparationspriser.getPris());
    }

}
