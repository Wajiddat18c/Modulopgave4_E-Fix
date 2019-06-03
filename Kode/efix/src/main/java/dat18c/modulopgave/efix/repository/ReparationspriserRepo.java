/**
 * dat18c.modulopgave.efix.repository
 */
package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Reparationspriser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is a Repository class that handles Sql quarries.
 * @author Ali Al-Sharefi
 */
@Repository
public class ReparationspriserRepo implements Crud<Reparationspriser> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Reparationspriser> fetchAll() {
        String sql = "SELECT * FROM REPARATIONSPRISER";
        RowMapper<Reparationspriser> rowMapper = new BeanPropertyRowMapper<>(Reparationspriser.class);

        return template.query(sql, rowMapper);
    }

    @Override
    public Reparationspriser findById(int id) {
        String sql = "SELECT * FROM REPARATIONSPRISER WHERE idReparationspriser=?";

        RowMapper<Reparationspriser> rowMapper = new BeanPropertyRowMapper<>(Reparationspriser.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void addItem(Reparationspriser reparationspriser) {
        String sql = "INSERT INTO REPARATIONSPRISER(idReparationspriser, brand, model, tid, beskrivelse, pris) VALUES (?,?,?,?,?,?)";

        template.update(sql, reparationspriser.getIdReparationspriser(), reparationspriser.getBrand(), reparationspriser.getModel(), reparationspriser.getTid(), reparationspriser.getBeskrivelse(), reparationspriser.getPris());

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM REPARATIONSPRISER WHERE idReparationspriser=?";
        template.update(sql, id);
    }

    @Override
    public void update(Reparationspriser reparationspriser) {
        String sql = "UPDATE REPARATIONSPRISER SET brand=?, model=?, tid=?, beskrivelse=?, pris=? WHERE idReparationspriser=?";
        template.update(sql, reparationspriser.getBrand(), reparationspriser.getModel(), reparationspriser.getTid(), reparationspriser.getBeskrivelse(), reparationspriser.getPris(), reparationspriser.getIdReparationspriser());
    }

}
