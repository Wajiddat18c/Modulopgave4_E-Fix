/**
 * dat18c.modulopgave.efix.repository
 */
package dat18c.modulopgave.efix.repository;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Nyhedsbrev;
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
public class NyhedsbrevRepo implements Crud<Nyhedsbrev> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Nyhedsbrev> fetchAll() {

        String sql = "SELECT * FROM nyhedsbrev";

        RowMapper<Nyhedsbrev> rowMapper = new BeanPropertyRowMapper<>(Nyhedsbrev.class);

        return template.query(sql, rowMapper);
    }

    @Override
    public void addItem(Nyhedsbrev nyhedsbrev) {
        String sql = "INSERT INTO nyhedsbrev (idNyhedsbrev, eMail) VALUES (?, ?)";

        template.update(sql, nyhedsbrev.getIdNyhedsbrev(), nyhedsbrev.geteMail());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM nyhedsbrev WHERE idNyhedsbrev=?";

        template.update(sql, id);
    }

    @Override
    public Nyhedsbrev findById(int id) {
        return null;
    }

    @Override
    public void update(Nyhedsbrev nyhedsbrev) {

    }

    /**
     * This method checkFor unique emails in out database
     *
     * @param nyhedsbrev Nyhedsbrev
     * @return boolean
     */
    public boolean checkForValidation(Nyhedsbrev nyhedsbrev){
        String sqlSelect = "SELECT eMail FROM nyhedsbrev"+
                " WHERE eMail=?";
//                " AND tickets.row="+ticket.getRow()+
//                " AND seat="+ticket.getSeat();
        System.out.println(sqlSelect);
        RowMapper<Nyhedsbrev> rowMapper = new BeanPropertyRowMapper<>(Nyhedsbrev.class);
        if(!template.query(sqlSelect, rowMapper, nyhedsbrev.geteMail()).isEmpty()) {
//            throw new RuntimeException("One or more of the selected seats were bought. Please try again from the beginning, the database was rolled back");
            System.out.println("TEST!");
            return false;
        }
        else{
            System.out.println("Testrepo");

            String sql = "INSERT INTO nyhedsbrev (idNyhedsbrev, eMail) VALUES (?, ?)";

            template.update(sql, nyhedsbrev.getIdNyhedsbrev(), nyhedsbrev.geteMail());
            return true;
        }
    }
}
