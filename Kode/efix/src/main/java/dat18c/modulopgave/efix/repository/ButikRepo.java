/**
 * dat18c.modulopgave.efix.repository
 */
package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Butik;
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
public class ButikRepo implements Crud<Butik> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Butik> fetchAll() {

        String sql = "SELECT * FROM BUTIK";

        RowMapper<Butik> rowMapper = new BeanPropertyRowMapper<>(Butik.class);

        return template.query(sql, rowMapper);
    }

    @Override
    public Butik findById(int idButik) {
        //sql query der finder butik vha. id
        String sql = "SELECT * FROM BUTIK WHERE idButik=?";
        //instantier rowmapper til at mappe query result til butik object
        RowMapper<Butik> rowMapper = new BeanPropertyRowMapper<>(Butik.class);
        //udfør query med JdbcTemplate
        return template.queryForObject(sql, rowMapper, idButik);
    }

    @Override
    public void addItem(Butik butik) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(Butik butik) {
        //sql statement der opdaterer rækken id med butik objektet
        String sql = "UPDATE butik SET navn=?, adresse=?, mobilNummer=?, beskrivelse=?, aabningstider=?, email=? WHERE idButik=?";
        //udfør update med JdbcTemplate
        template.update(sql, butik.getNavn(), butik.getAdresse(), butik.getMobilNummer(), butik.getBeskrivelse(), butik.getAabningstider(), butik.getEmail(), butik.getIdButik());
    }
}
