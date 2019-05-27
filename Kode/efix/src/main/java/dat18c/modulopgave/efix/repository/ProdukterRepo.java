package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Produkter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/** This is a Repository class that handles Sql quarries.
 *
 */
@Repository
public class ProdukterRepo implements Crud<Produkter>{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Produkter> fetchAll() {

        String sql = "SELECT * FROM PRODUKTER";

        RowMapper<Produkter> rowMapper = new BeanPropertyRowMapper<>(Produkter.class);

        return template.query(sql, rowMapper);

    }
    @Override
    public Produkter findById(int idProdukter){

        String sql = "SELECT * FROM PRODUKTER WHERE idProdukter=?";

        RowMapper<Produkter> rowMapper = new BeanPropertyRowMapper<>(Produkter.class);

        return template.queryForObject(sql, rowMapper, idProdukter);
    }

    @Override
    public void addItem(Produkter produkter) {
        // prepared statement
        String sql = "INSERT INTO PRODUKTER (idProdukter, navn, pris, beskrivelse, Kategori_idKategori) VALUES (?, ?, ?, ?, ?)";
        // udfør insert med jdbc template
        template.update(sql, produkter.getIdProdukter(), produkter.getNavn(), produkter.getPris(), produkter.getBeskrivelse(), produkter.getKategori_idKategori());
    }

    @Override
    public void deleteById(int idProdukter){
        // delete statement
        String sql = "DELETE FROM PRODUKTER WHERE idProdukter=?";

        //kald update med delete statement og id
        template.update(sql, idProdukter);
    }
    @Override
    public void update(Produkter produkter){
        //sql statement der opdaterer rækken id med person objektet
        String sql ="UPDATE PRODUKTER SET navn=?, pris=?, beskrivelse=?, Kategori_idKategori=? WHERE idProdukter=?";
        //udfør update med JdbcTemplate
        template.update(sql, produkter.getNavn(), produkter.getPris(), produkter.getBeskrivelse(), produkter.getKategori_idKategori(), produkter.getIdProdukter());
    }

}
