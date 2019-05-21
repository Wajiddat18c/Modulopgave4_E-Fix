package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.model.Repair;
import dat18c.modulopgave.efix.repository.RepairRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {

    @Autowired
    RepairRepo repairRepo;
    public List<Repair> fetchAllRepair(){
        return repairRepo.fetchAllRepair();
    }

    public void addRepair(Repair repair){
        repairRepo.addRepair(repair);
    }

    public void deleteRepair(int id){
        repairRepo.deleteRepair(id);
    }
}
