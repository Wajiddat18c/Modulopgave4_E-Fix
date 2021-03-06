/**
 * dat18c.modulopgave.efix.service
 */
package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Nyhedsbrev;
import dat18c.modulopgave.efix.repository.NyhedsbrevRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements Crud Interface
 * @author Wajid Ahmad
 */
@Service
public class NyhedsbrevService implements Crud<Nyhedsbrev> {

    @Autowired
    NyhedsbrevRepo nyhedsbrevRepo;

    @Override
    public List<Nyhedsbrev> fetchAll() {
        return nyhedsbrevRepo.fetchAll();
    }

    @Override
    public void addItem(Nyhedsbrev nyhedsbrev) {
        nyhedsbrevRepo.addItem(nyhedsbrev);
    }

    @Override
    public void deleteById(int id) {
        nyhedsbrevRepo.deleteById(id);
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
    public boolean checkForValidation(Nyhedsbrev nyhedsbrev){ return nyhedsbrevRepo.checkForValidation(nyhedsbrev);}
}
