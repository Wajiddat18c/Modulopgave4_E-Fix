package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.model.Produkter;
import dat18c.modulopgave.efix.repository.ProdukterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdukterService {

    @Autowired
    ProdukterRepo produkterRepo;

    public List<Produkter> fetchAllProdukters(){
        return produkterRepo.fetchAllProdukter();
    }

    public Produkter findProdukterById(int idProdukter){
        return produkterRepo.findProdukterById(idProdukter);
    }
}