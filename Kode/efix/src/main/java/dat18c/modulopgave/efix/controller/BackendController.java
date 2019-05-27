/**
 * dat18c.modulopgave.efix.controller
 */
package dat18c.modulopgave.efix.controller;

import dat18c.modulopgave.efix.model.*;
import dat18c.modulopgave.efix.repository.KategoriRepo;
import dat18c.modulopgave.efix.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**This a BackendController that handles logic
 *
 */
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

    /**
     * This method redirect to htmlpage
     * @return htmlPage
     */
    @RequestMapping("/")
    public String home(){
        return "adminindex";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/butik")
    public String butikData(Model model){

        model.addAttribute("butikker", butikService.fetchAll());

        return "butik";
    }

    /**
     *
     * @param idButik
     * @param model
     * @return
     */
    @GetMapping("/update/{idButik}")
    public String showUpdate(@PathVariable("idButik") int idButik, Model model){
        //tilføj person med id til viewmodel
        model.addAttribute("butikker", butikService.findById(idButik));
        return "update";
    }

    /**
     *
     * @param butik
     * @return
     */
    @PostMapping("/update")
    public String updateDoIt(@ModelAttribute Butik butik){
        //kald update service
        butikService.update(butik);
        //sikr mod refresh fejl og sletter igen
        return "redirect:/admin/butik";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/prod")
    public String produkterData(Model model){

        model.addAttribute("produkt", produkterService.fetchAll());

        return "prod";
    }

    /**
     *
     * @return
     */
    @GetMapping("/create")
    public String showCreate(Model model){

        model.addAttribute("Kategorier", kategoriService.fetchAll());
        return "create";
    }

    /**
     *
     * @param produkter
     * @return
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Produkter produkter){
        produkterService.addItem(produkter);
        return "redirect:/admin/prod";
    }

    /**
     *
     * @param idProdukter
     * @return
     */
    @GetMapping("/delete/{iden}")
    public String delete(@PathVariable("iden") int idProdukter){
        produkterService.deleteById(idProdukter);
        return "redirect:/admin/prod";
    }

    /**
     *
     * @param idProdukter
     * @param model
     * @return
     */
    @GetMapping("/updateprod/{id}")
    public String Update(@PathVariable("id") int idProdukter, Model model){
        model.addAttribute("produkt", produkterService.findById(idProdukter));
        model.addAttribute("Kategorier", kategoriService.fetchAll());
        return "updateprod";
    }

    /**
     *
     * @param produkter
     * @return
     */
    @PostMapping("/updateprod")
    public String updateIt(@ModelAttribute Produkter produkter){
        produkterService.update(produkter);
        return "redirect:/admin/prod";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/nyhed")
    public String nyhedsbrevData(Model model){

        model.addAttribute("nyhed", nyhedsbrevService.fetchAll());

        return "nyhed";
    }

    /**
     *
     * @return
     */
    @GetMapping("/addnyhed")
    public String showAddNyhed(){
        return "addnyhed";
    }

    /**
     *
     * @param nyhedsbrev
     * @return
     */
    @PostMapping("/addnyhed")
    public String addnyhed(@ModelAttribute Nyhedsbrev nyhedsbrev){
        nyhedsbrevService.addItem(nyhedsbrev);
        return "redirect:/nyhed";
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("deletenyhed/{id}")
    public String unsubscribe(@PathVariable int id){
        nyhedsbrevService.deleteById(id);
        return "redirect:/admin/nyhed";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/repair")
    public String repairData(Model model){
        model.addAttribute("rep", repairService.fetchAll());
        return "repair";
    }

    /**
     *
     * @return
     */
    @GetMapping("/newrepair")
    public String showNewRepair(){
        return "newrepair";
    }

    /**
     *
     * @param repair
     * @return
     */
    @PostMapping("newrepair")
    public String newRepair(@ModelAttribute Repair repair){
        repairService.addItem(repair);
        return "redirect:/";
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("deleteordre/{id}")
    public String deleteOrdre(@PathVariable int id){
        repairService.deleteById(id);
        return "redirect:/admin/repair";
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updaterepair/{id}")
    public String updateRepair(@PathVariable("id") int id, Model model){
        model.addAttribute("rep", repairService.findById(id));
        return "updaterepair";
    }

    /**
     *
     * @param repair
     * @return
     */

    @PostMapping("/updaterepair")
    public String updateRepair(@ModelAttribute Repair repair){
        repairService.update(repair);
        return "redirect:/admin/repair";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping ("/reparationspriser")
    public String reprationspriserData(Model model){
        model.addAttribute("pris", reparationspriserService.fetchAll());
        return "reparationspriser";
    }

    /**
     *
     * @return
     */
    @GetMapping("/addreparationspriser")
    public String Showreparationspriser(){
        return "addreparationspriser";
    }

    /**
     *
     * @param reparationspriser
     * @return
     */
    @PostMapping("/addreparationspriser")
    public String createpriser(@ModelAttribute Reparationspriser reparationspriser){
        reparationspriserService.addItem(reparationspriser);
        return "redirect:/admin/reparationspriser";
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/deletereparationspriser/{id}")
    public String deletereparationspriser(@PathVariable("id") int id){
        reparationspriserService.deleteById(id);
        return "redirect:/admin/reparationspriser";
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updatereparationspriser/{id}")
    public String updatepriser(@PathVariable("id") int id, Model model){
        model.addAttribute("pris", reparationspriserService.findById(id));
        return "updatereparationspriser";

    }

    /**
     *
     * @param reparationspriser
     * @return
     */
    @PostMapping("/updatereparationspriser")
    public String updatePriser(@ModelAttribute Reparationspriser reparationspriser){
        reparationspriserService.update(reparationspriser);
        return "redirect:/admin/reparationspriser";
    }


}
