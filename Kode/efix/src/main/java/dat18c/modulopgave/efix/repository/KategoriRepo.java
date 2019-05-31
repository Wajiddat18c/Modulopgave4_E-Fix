/**
 * dat18c.modulopgave.efix.repository
 */
package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is a Repository class that handles Sql quarries.
 */
@Repository
public class KategoriRepo implements Crud<Kategori> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List fetchAll() {
        String sql = "SELECT * FROM kategorier";
        RowMapper<Kategori> rowMapper = new BeanPropertyRowMapper<>(Kategori.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Kategori findById(int id) {
        return null;
    }

    @Override
    public void update(Kategori kategori) {

    }

    @Override
    public void addItem(Kategori kategori) {

    }

    @Override
    public void deleteById(int id) {

    }
}
