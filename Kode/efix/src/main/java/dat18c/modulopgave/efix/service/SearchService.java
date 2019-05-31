/**
 * dat18c.modulopgave.efix.service
 */
package dat18c.modulopgave.efix.service;

import dat18c.modulopgave.efix.model.SearchResults;
import dat18c.modulopgave.efix.repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements Crud Interface
 */
@Service
public class SearchService {
    @Autowired
    SearchRepo searchRepo;

    public List<SearchResults> getResults(String query) {
        return searchRepo.getResults(query);
    }
}
