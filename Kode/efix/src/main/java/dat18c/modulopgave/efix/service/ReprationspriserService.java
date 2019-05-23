package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.model.Repair;
import dat18c.modulopgave.efix.model.Reparationspriser;
import dat18c.modulopgave.efix.repository.ReparationspriserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReprationspriserService {

    @Autowired
    ReparationspriserRepo reparationspriserRepo;
    public List<Reparationspriser> fetchAllReparationspriser(){
        return reparationspriserRepo.fetchAllReparationspriser();
    }

    public void addReparationspriser(Reparationspriser reparationspriser){
        reparationspriserRepo.addReparationspriser(reparationspriser);
    }

    public void deleteReparationspriser(int id){
        reparationspriserRepo.deleteReparationspriser(id);
    }

    public Reparationspriser findReparationspriserById(int id){
        return reparationspriserRepo.findReparationspriser(id);
    }

    public void updateReparationspriser(Reparationspriser reparationspriser){
        reparationspriserRepo.updateReparationspriser(reparationspriser);
    }
}
