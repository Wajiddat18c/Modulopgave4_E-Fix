package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.model.SearchResults;
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
public class SearchRepo {
    @Autowired
    JdbcTemplate template;

    /**
     * This method gets a search results from Database query.
     * @param query search from Database
     * @return template
     */
    public List<SearchResults> getResults(String query){
        String sql = "SELECT pris, idProdukter, beskrivelse, produkter.navn AS produktNavn, kategorier.navn AS kategoriNavn" +
                " FROM produkter" +
                " INNER JOIN kategorier ON kategorier.idKategori = produkter.Kategori_idKategori" +
                " WHERE beskrivelse LIKE '%"+query+"%'" +
                " OR produkter.navn LIKE '%"+query+"%'" +
                " OR produkter.pris LIKE '%"+query+"%'" +
                " OR kategorier.navn LIKE '%"+query+"%'";
        RowMapper<SearchResults> rowMapper = new BeanPropertyRowMapper<>(SearchResults.class);

        return template.query(sql, rowMapper);
    }
}
