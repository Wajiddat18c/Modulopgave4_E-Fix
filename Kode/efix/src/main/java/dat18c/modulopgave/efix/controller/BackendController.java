package dat18c.modulopgave.efix.controller;

import dat18c.modulopgave.efix.model.Butik;
import dat18c.modulopgave.efix.model.Nyhedsbrev;
import dat18c.modulopgave.efix.model.Produkter;
import dat18c.modulopgave.efix.service.ButikService;
import dat18c.modulopgave.efix.service.NyhedsbrevService;
import dat18c.modulopgave.efix.service.ProdukterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/")
public class BackendController {

    @Autowired
    ButikService butikService;

    @Autowired
    ProdukterService produkterService;

    @Autowired
    NyhedsbrevService nyhedsbrevService;

    @GetMapping("/")
    public String home(){
        return "adminindex";
    }

    @GetMapping("/butik")
    public String butikData(Model model){

        model.addAttribute("butikker", butikService.fetchAllButiks());

        return "butik";
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
        return "redirect:/admin/butik";
    }

    @GetMapping("/prod")
    public String produkterData(Model model){

        model.addAttribute("produkt", produkterService.fetchAllProdukters());

        return "prod";
    }

    @GetMapping("/create")
    public String showCreate(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Produkter produkter){
        produkterService.addProdukter(produkter);
        return "redirect:/admin/prod";
    }

    @GetMapping("/delete/{iden}")
    public String delete(@PathVariable("iden") int idProdukter){
        produkterService.deleteProdukter(idProdukter);
        return "redirect:/admin/prod";
    }

    @GetMapping("/updateprod/{id}")
    public String Update(@PathVariable("id") int idProdukter, Model model){
        model.addAttribute("produkt", produkterService.findProdukterById(idProdukter));
        return "updateprod";
    }

    // opdater person - @ModelAttribute bruges til at få fat i person fra post
    @PostMapping("/updateprod")
    public String updateIt(@ModelAttribute Produkter produkter){
        produkterService.updateProdukter(produkter);
        return "redirect:/admin/prod";
    }

    @GetMapping("/nyhed")
    public String nyhedsbrevData(Model model){

        model.addAttribute("nyhed", nyhedsbrevService.fetchAllNyhedsbrev());

        return "nyhed";
    }
    @GetMapping("/addnyhed")
    public String showAddNyhed(){
        return "addnyhed";
    }

    @PostMapping("/addnyhed")
    public String addnyhed(@ModelAttribute Nyhedsbrev nyhedsbrev){
        nyhedsbrevService.addNyhedsbrev(nyhedsbrev);
        return "redirect:/";
    }
    @GetMapping("deletenyhed/{id}")
    public String unsubscribe(@PathVariable int id){
        nyhedsbrevService.deleteNyhedsbrev(id);
        return "redirect:/admin/nyhed";
    }

}
