package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.model.Butik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ButikRepo {

    @Autowired
    JdbcTemplate template;

    public List<Butik> fetchAllBuik(){

        String sql = "SELECT * FROM butik";

        RowMapper<Butik> rowMapper = new BeanPropertyRowMapper<>(Butik.class);

        return template.query(sql, rowMapper);
    }

}
