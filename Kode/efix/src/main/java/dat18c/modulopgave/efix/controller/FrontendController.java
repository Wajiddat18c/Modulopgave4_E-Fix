package dat18c.modulopgave.efix.controller;
import dat18c.modulopgave.efix.model.Nyhedsbrev;
import dat18c.modulopgave.efix.service.ButikService;

import dat18c.modulopgave.efix.service.NyhedsbrevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontendController {

    @Autowired
    ButikService butikService;

    @Autowired
    NyhedsbrevService nyhedsbrevService;

    @GetMapping("/")
    public String frontPage(Model model){

        model.addAttribute("butikker", butikService.fetchAllButiks());
        return "index";
    }

    @GetMapping("/reparation")
    public String reparation(Model model){
        return "reparation";
    }

    @GetMapping("/buy")
    public String buy(Model model){
        return "buy";
    }

    @GetMapping("/sell")
    public String sell(Model model){
        return "sell";
    }

    @GetMapping("/addnyhed")
    public String showAddNyhed(){
        return "addnyhed";
    }

    @GetMapping("/newrepair")
    public String addNewRepair(){
        return "newrepair";
    }
}
