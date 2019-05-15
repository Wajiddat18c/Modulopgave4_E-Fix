package dat18c.modulopgave.efix.controller;

import dat18c.modulopgave.efix.model.Butik;
import dat18c.modulopgave.efix.service.ButikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    ButikService butikService;

    @GetMapping("/butik")
    public String butikData(Model model){

        model.addAttribute("butikker", butikService.fetchAllButiks());

        return "butik.html";
    }

    // få fat id fra stien vha. @PathVariable
    @GetMapping("/update/{idButik}")
    public String showUpdate(@PathVariable("idButik") int idButik, Model model){
        //tilføj person med id til viewmodel
        model.addAttribute("butikker", butikService.findButikById(idButik));
        return "update";
    }

    // opdater person - @ModelAttribute bruges til at få fat i person fra post
    @PostMapping("/update")
    public String updateDoIt(@ModelAttribute Butik butik){
        //kald update service
        butikService.updateButik(butik);
        //sikr mod refresh fejl og sletter igen
        return "redirect:/butik";
    }
}
