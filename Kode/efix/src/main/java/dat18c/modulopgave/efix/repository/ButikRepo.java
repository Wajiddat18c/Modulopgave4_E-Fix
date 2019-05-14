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

    public List<Butik> fetchAllButik(){

        String sql = "SELECT * FROM BUTIK";

        RowMapper<Butik> rowMapper = new BeanPropertyRowMapper<>(Butik.class);

        return template.query(sql, rowMapper);
    }

    public Butik findButikById(int idButik){
        //sql query der finder person vha. id
        String sql ="SELECT * FROM BUTIK WHERE idButik=?";
        //instantier rowmapper til at mappe query result til person object
        RowMapper<Butik> rowMapper = new BeanPropertyRowMapper<>(Butik.class);
        //udfør query med JdbcTemplate
        return template.queryForObject(sql, rowMapper, idButik);
    }

    public void updateButik(Butik butik){
        //sql statement der opdaterer rækken id med butik objektet
        String sql ="UPDATE butik SET navn=?, adresse=?, mobilNummer=?, beskrivelse=?, aabningstider=?, email=? WHERE idButik=?";
        //udfør update med JdbcTemplate
        template.update(sql, butik.getNavn(), butik.getAdresse(), butik.getMobilNummer(), butik.getBeskrivelse(), butik.getAabningstider(), butik.getEmail(), butik.getIdButik());
    }
}
