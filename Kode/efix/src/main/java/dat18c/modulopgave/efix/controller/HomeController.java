package dat18c.modulopgave.efix.controller;

import dat18c.modulopgave.efix.service.ButikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ButikService butikService;

    @GetMapping("/forside")
    public String butikData(Model model){

        model.addAttribute("butiks", butikService.fetchAllButiks());

        return "forside";
    }
}
