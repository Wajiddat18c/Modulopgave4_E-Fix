package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.model.Nyhedsbrev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NyhedsbrevRepo {

    @Autowired
    JdbcTemplate template;

    public List<Nyhedsbrev> fetchAllNyhedsbrev(){

        String sql = "SELECT * FROM nyhedsbrev";

        RowMapper<Nyhedsbrev> rowMapper = new BeanPropertyRowMapper<>(Nyhedsbrev.class);

        return template.query(sql, rowMapper);
    }
    public void addNyhedsbrev(Nyhedsbrev nyhedsbrev){
        String sql = "INSERT INTO nyhedsbrev (idNyhedsbrev, eMail) VALUES (?, ?)";

        template.update(sql, nyhedsbrev.getIdNyhedsbrev(), nyhedsbrev.geteMail());
    }

    public void deleteNyhedsbrev(int id){
        String sql = "DELETE FROM nyhedsbrev WHERE idNyhedsbrev=id";

        template.update(sql);
    }
}
