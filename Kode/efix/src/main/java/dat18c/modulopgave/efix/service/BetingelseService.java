/**
 * dat18c.modulopgave.efix.service
 */
package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Betingelse;
import dat18c.modulopgave.efix.repository.BetingelseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements Crud Interface
 */
@Service
public class BetingelseService implements Crud<Betingelse> {

    @Autowired
    BetingelseRepo repo;

    @Override
    public List fetchAll() {
        return null;
    }

    @Override
    public Betingelse findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void update(Betingelse betingelse) {
        repo.update(betingelse);
    }

    @Override
    public void addItem(Betingelse betingelse) {
        repo.addItem(betingelse);
    }

    @Override
    public void deleteById(int id) {

    }
}
