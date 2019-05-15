package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.model.Produkter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdukterRepo {

    @Autowired
    JdbcTemplate template;

    public List<Produkter> fetchAllProdukter() {

        String sql = "SELECT * FROM PRODUKTER";

        RowMapper<Produkter> rowMapper = new BeanPropertyRowMapper<>(Produkter.class);

        return template.query(sql, rowMapper);

    }

    public Produkter findProdukterById(int idProdukter){

        String sql = "SELECT * FROM PRODUKTER WHERE idProdukter=?";

        RowMapper<Produkter> rowMapper = new BeanPropertyRowMapper<>(Produkter.class);

        return template.queryForObject(sql, rowMapper, idProdukter);
    }

}
