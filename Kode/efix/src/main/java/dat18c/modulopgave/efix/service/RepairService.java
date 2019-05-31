/**
 * dat18c.modulopgave.efix.service
 */
package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.Crud;
import dat18c.modulopgave.efix.model.Repair;
import dat18c.modulopgave.efix.repository.RepairRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements Crud Interface
 */
@Service
public class RepairService implements Crud<Repair> {

    @Autowired
    RepairRepo repairRepo;

    @Override
    public List<Repair> fetchAll() {
        return repairRepo.fetchAll();
    }

    @Override
    public void addItem(Repair repair) {
        repairRepo.addItem(repair);
    }

    @Override
    public void deleteById(int id) {
        repairRepo.deleteById(id);
    }

    @Override
    public Repair findById(int id) {
        return repairRepo.findById(id);
    }

    @Override
    public void update(Repair repair) {
        repairRepo.update(repair);
    }
}
