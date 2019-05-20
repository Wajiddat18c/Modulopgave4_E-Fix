package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.model.Nyhedsbrev;
import dat18c.modulopgave.efix.repository.NyhedsbrevRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NyhedsbrevService {

    @Autowired
    NyhedsbrevRepo nyhedsbrevRepo;

    public List<Nyhedsbrev> fetchAllNyhedsbrev(){
        return nyhedsbrevRepo.fetchAllNyhedsbrev();
    }

    public void addNyhedsbrev(Nyhedsbrev nyhedsbrev){
        nyhedsbrevRepo.addNyhedsbrev(nyhedsbrev);
    }

    public void deleteNyhedsbrev(int id){
        nyhedsbrevRepo.deleteNyhedsbrev(id);
    }
}
