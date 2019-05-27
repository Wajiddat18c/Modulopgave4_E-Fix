/**
 * dat18c.modulopgave.efix.service
 */
package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Kategori;
import dat18c.modulopgave.efix.repository.KategoriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/** This class implements Crud Interface
 *
 */
@Service
public class KategoriService implements Crud<Kategori> {

    @Autowired
    KategoriRepo kategoriRepo;

    @Override
    public List fetchAll() {
        return kategoriRepo.fetchAll();
    }

    @Override
    public Kategori findById(int id) {
        return null;
    }

    @Override
    public void update(Kategori kategori) {

    }

    @Override
    public void addItem(Kategori kategori) {

    }

    @Override
    public void deleteById(int id) {

    }
}
