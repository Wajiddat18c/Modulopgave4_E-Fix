package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.model.Butik;
import dat18c.modulopgave.efix.repository.ButikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ButikService {

    @Autowired
    ButikRepo butikRepo;

    public List<Butik> fetchAllButiks(){

        return butikRepo.fetchAllButik();
    }
    public Butik findButikById(int idButik){
        return butikRepo.findButikById(idButik);
    }

    public void updateButik(Butik butik){
        butikRepo.updateButik(butik);
    }
}
