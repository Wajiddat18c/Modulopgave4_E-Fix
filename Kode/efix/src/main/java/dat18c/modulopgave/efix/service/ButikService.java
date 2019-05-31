/**
 * dat18c.modulopgave.efix.service
 */
package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Butik;
import dat18c.modulopgave.efix.repository.ButikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements Crud Interface
 */
@Service
public class ButikService implements Crud<Butik> {

    @Autowired
    ButikRepo butikRepo;

    @Override
    public void addItem(Butik butik) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Butik> fetchAll() {

        return butikRepo.fetchAll();
    }

    @Override
    public Butik findById(int idButik) {
        return butikRepo.findById(idButik);
    }

    @Override
    public void update(Butik butik) {
        butikRepo.update(butik);
    }
}
