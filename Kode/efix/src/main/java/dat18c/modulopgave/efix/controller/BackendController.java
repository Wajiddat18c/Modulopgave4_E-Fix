package dat18c.modulopgave.efix.controller;

import dat18c.modulopgave.efix.model.*;
import dat18c.modulopgave.efix.repository.KategoriRepo;
import dat18c.modulopgave.efix.service.*;
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

    @Autowired
    RepairService repairService;

    @Autowired
    ReparationspriserService reparationspriserService;

    @Autowired
    KategoriService kategoriService;

    @RequestMapping("/")
    public String home(){
        return "adminindex";
    }

    @GetMapping("/butik")
    public String butikData(Model model){

        model.addAttribute("butikker", butikService.fetchAll());

        return "butik";
    }

    // få fat id fra stien vha. @PathVariable
    @GetMapping("/update/{idButik}")
    public String showUpdate(@PathVariable("idButik") int idButik, Model model){
        //tilføj person med id til viewmodel
        model.addAttribute("butikker", butikService.findById(idButik));
        return "update";
    }

    // opdater person - @ModelAttribute bruges til at få fat i person fra post
    @PostMapping("/update")
    public String updateDoIt(@ModelAttribute Butik butik){
        //kald update service
        butikService.update(butik);
        //sikr mod refresh fejl og sletter igen
        return "redirect:/admin/butik";
    }

    @GetMapping("/prod")
    public String produkterData(Model model){

        model.addAttribute("produkt", produkterService.fetchAll());

        return "prod";
    }

    @GetMapping("/create")
    public String showCreate(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Produkter produkter){
        produkterService.addItem(produkter);
        return "redirect:/admin/prod";
    }

    @GetMapping("/delete/{iden}")
    public String delete(@PathVariable("iden") int idProdukter){
        produkterService.deleteById(idProdukter);
        return "redirect:/admin/prod";
    }

    @GetMapping("/updateprod/{id}")
    public String Update(@PathVariable("id") int idProdukter, Model model){
        model.addAttribute("produkt", produkterService.findById(idProdukter));
        model.addAttribute("Kategorier", kategoriService.fetchAll());
        return "updateprod";
    }

    // opdater person - @ModelAttribute bruges til at få fat i person fra post
    @PostMapping("/updateprod")
    public String updateIt(@ModelAttribute Produkter produkter){
        produkterService.update(produkter);
        return "redirect:/admin/prod";
    }

    @GetMapping("/nyhed")
    public String nyhedsbrevData(Model model){

        model.addAttribute("nyhed", nyhedsbrevService.fetchAll());

        return "nyhed";
    }
    @GetMapping("/addnyhed")
    public String showAddNyhed(){
        return "addnyhed";
    }

    @PostMapping("/addnyhed")
    public String addnyhed(@ModelAttribute Nyhedsbrev nyhedsbrev){
        nyhedsbrevService.addItem(nyhedsbrev);
        return "redirect:/nyhed";
    }
    @GetMapping("deletenyhed/{id}")
    public String unsubscribe(@PathVariable int id){
        nyhedsbrevService.deleteById(id);
        return "redirect:/admin/nyhed";
    }

    @GetMapping("/repair")
    public String repairData(Model model){
        model.addAttribute("rep", repairService.fetchAll());
        return "repair";
    }
    @GetMapping("/newrepair")
    public String showNewRepair(){
        return "newrepair";
    }
    @PostMapping("newrepair")
    public String newRepair(@ModelAttribute Repair repair){
        repairService.addItem(repair);
        return "redirect:/";
    }
    @GetMapping("deleteordre/{id}")
    public String deleteOrdre(@PathVariable int id){
        repairService.deleteById(id);
        return "redirect:/admin/repair";
    }

    @GetMapping("/updaterepair/{id}")
    public String updateRepair(@PathVariable("id") int id, Model model){
        model.addAttribute("rep", repairService.findById(id));
        return "updaterepair";
    }


    @PostMapping("/updaterepair")
    public String updateRepair(@ModelAttribute Repair repair){
        repairService.update(repair);
        return "redirect:/admin/repair";
    }

    @GetMapping ("/reparationspriser")
    public String reprationspriserData(Model model){
        model.addAttribute("pris", reparationspriserService.fetchAll());
        return "reparationspriser";
    }

    @GetMapping("/addreparationspriser")
    public String Showreparationspriser(){
        return "addreparationspriser";
    }
    @PostMapping("/addreparationspriser")
    public String createpriser(@ModelAttribute Reparationspriser reparationspriser){
        reparationspriserService.addItem(reparationspriser);
        return "redirect:/admin/reparationspriser";
    }


    @GetMapping("/deletereparationspriser/{id}")
    public String deletereparationspriser(@PathVariable("id") int id){
        reparationspriserService.deleteById(id);
        return "redirect:/admin/reparationspriser";
    }

    @GetMapping("/updatereparationspriser/{id}")
    public String updatepriser(@PathVariable("id") int id, Model model){
        model.addAttribute("pris", reparationspriserService.findById(id));
        return "updatereparationspriser";

    }
    @PostMapping("/updatereparationspriser")
    public String updatePriser(@ModelAttribute Reparationspriser reparationspriser){
        reparationspriserService.update(reparationspriser);
        return "redirect:/admin/reparationspriser";
    }




}
