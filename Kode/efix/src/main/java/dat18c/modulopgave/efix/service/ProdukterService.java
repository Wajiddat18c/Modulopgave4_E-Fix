package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Produkter;
import dat18c.modulopgave.efix.repository.ProdukterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdukterService implements Crud<Produkter>{

    @Autowired
    ProdukterRepo produkterRepo;

    @Override
    public List<Produkter> fetchAll(){
        return produkterRepo.fetchAll();
    }
    @Override
    public Produkter findById(int idProdukter){
        return produkterRepo.findById(idProdukter);
    }
    @Override
    public void addItem(Produkter produkter){
        produkterRepo.addItem(produkter);
    }
    @Override
    public void deleteById(int idProdukter){
        produkterRepo.deleteById(idProdukter);
    }
    @Override
    public void update(Produkter produkter){
        produkterRepo.update(produkter);
    }
}
