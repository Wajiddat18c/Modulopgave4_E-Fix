package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Reparationspriser;
import dat18c.modulopgave.efix.repository.ReparationspriserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparationspriserService implements Crud<Reparationspriser>{

    @Autowired
    ReparationspriserRepo reparationspriserRepo;
    @Override
    public List<Reparationspriser> fetchAll(){
        return reparationspriserRepo.fetchAll();
    }

    @Override
    public void addItem(Reparationspriser reparationspriser){
        reparationspriserRepo.addItem(reparationspriser);
    }
    @Override
    public void deleteById(int id){
        reparationspriserRepo.deleteById(id);
    }

    @Override
    public Reparationspriser findById(int id){
        return reparationspriserRepo.findById(id);
    }

    @Override
    public void update(Reparationspriser reparationspriser){
        reparationspriserRepo.update(reparationspriser);
    }
}
