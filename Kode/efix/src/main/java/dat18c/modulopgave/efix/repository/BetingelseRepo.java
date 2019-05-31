package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Betingelse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BetingelseRepo implements Crud<Betingelse> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List fetchAll() {
        return null;
    }

    @Override
    public Betingelse findById(int id) {
        String sql = "SELECT * FROM betingelser WHERE idbetingelser=?";
        RowMapper<Betingelse> rowMapper = new BeanPropertyRowMapper<>(Betingelse.class);
        //udfør query med JdbcTemplate
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void update(Betingelse betingelse) {
        String sql = "UPDATE betingelser SET indhold=? WHERE idbetingelser=?";

        template.update(sql, betingelse.getIndhold(), betingelse.getIdbetingelser());
    }

    @Override
    public void addItem(Betingelse betingelse) {

    }

    @Override
    public void deleteById(int id) {

    }
}
