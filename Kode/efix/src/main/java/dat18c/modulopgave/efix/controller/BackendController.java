package dat18c.modulopgave.efix.controller;

import dat18c.modulopgave.efix.model.*;
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

    @GetMapping("/repair")
    public String repairData(Model model){
        model.addAttribute("rep", repairService.fetchAllRepair());
        return "repair";
    }
    @GetMapping("/newrepair")
    public String showNewRepair(){
        return "newrepair";
    }
    @PostMapping("newrepair")
    public String newRepair(@ModelAttribute Repair repair){
        repairService.addRepair(repair);
        return "redirect:/";
    }
    @GetMapping("deleteordre/{id}")
    public String deleteOrdre(@PathVariable int id){
        repairService.deleteRepair(id);
        return "redirect:/admin/repair";
    }

    @GetMapping("/updaterepair/{id}")
    public String updateRepair(@PathVariable("id") int id, Model model){
        model.addAttribute("rep", repairService.findRepairById(id));
        return "updaterepair";
    }


    @PostMapping("/updaterepair")
    public String updateRepair(@ModelAttribute Repair repair){
        repairService.updateRepair(repair);
        return "redirect:/admin/repair";
    }

    @GetMapping ("/reparationspriser")
    public String reprationspriserData(Model model){
        model.addAttribute("pris", reparationspriserService.fetchAllReparationspriser());
        return "reparationspriser";
    }

    @GetMapping("/addreparationspriser")
    public String Showreparationspriser(){
        return "addreparationspriser";
    }
    @PostMapping("/addreparationspriser")
    public String createpriser(@ModelAttribute Reparationspriser reparationspriser){
        reparationspriserService.addReparationspriser(reparationspriser);
        return "redirect:/admin/reparationspriser";
    }


    @GetMapping("/deletereparationspriser/{id}")
    public String deletereparationspriser(@PathVariable("id") int id){
        reparationspriserService.deleteReparationspriser(id);
        return "redirect:/admin/reparationspriser";
    }

    @GetMapping("/updatereparationspriser/{id}")
    public String updatepriser(@PathVariable("id") int id, Model model){
        model.addAttribute("pris", reparationspriserService.findReparationspriserById(id));
        return "updatereparationspriser";

    }
    @PostMapping("/updatereparationspriser")
    public String updatePriser(@ModelAttribute Reparationspriser reparationspriser){
        reparationspriserService.updateReparationspriser(reparationspriser);
        return "redirect:/admin/reparationspriser";
    }




}
