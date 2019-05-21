package dat18c.modulopgave.efix.controller;
import dat18c.modulopgave.efix.service.ButikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

    @Autowired
    ButikService butikService;

    @GetMapping("/")
    public String frontPage(Model model){

        model.addAttribute("butikker", butikService.fetchAllButiks());
        return "index";
    }
}
