/**
 * dat18c.modulopgave.efix.controller
 */
package dat18c.modulopgave.efix.controller;

import dat18c.modulopgave.efix.model.*;
import dat18c.modulopgave.efix.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * This a BackendController that handles logic
 * @author Aleksandr Sorokin
 * @author Ali Al-Sharefi
 * @author Thomas Broe
 * @author Wajid Ahmad
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

    @Autowired
    BetingelseService betingelseService;

    /**
     * This method redirect index htmlpage.
     *
     * @return htmlPage.
     */
    @RequestMapping("/")
    public String home() {
        return "adminindex";
    }

    /**
     * This method redirect to butik htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/butik")
    public String butikData(Model model) {

        model.addAttribute("butikker", butikService.fetchAll());

        return "butik";
    }

    /**
     * This method redirect to update butik info htmlpage.
     *
     * @param idButik Id from Database.
     * @param model   attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/update/{idButik}")
    public String showUpdate(@PathVariable("idButik") int idButik, Model model) {
        //tilføj person med id til viewmodel
        model.addAttribute("butikker", butikService.findById(idButik));
        return "update";
    }

    /**
     * This method redirect to update butik info htmlpage.
     *
     * @param butik update service,
     * @return htmlPage.
     */
    @PostMapping("/update")
    public String updateDoIt(@ModelAttribute Butik butik) {
        //kald update service
        butikService.update(butik);
        //sikr mod refresh fejl og sletter igen
        return "redirect:/admin/butik";
    }

    /**
     * This method redirect to produkter htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/prod")
    public String produkterData(Model model) {

        model.addAttribute("produkt", produkterService.fetchAll());

        return "prod";
    }

    /**
     * This method redirect to create new produkter htmlpage.
     *
     * @return htmlPage.
     */
    @GetMapping("/create")
    public String showCreate(Model model) {

        model.addAttribute("Kategorier", kategoriService.fetchAll());
        return "create";
    }

    /**
     * This method redirect to produkter htmlpage.
     *
     * @param produkter called from Model classes.
     * @return htmlPage.
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Produkter produkter) {
        produkterService.addItem(produkter);
        return "redirect:/admin/prod";
    }

    /**
     * This method deletes database entry.
     *
     * @param idProdukter called from Database table.
     * @return htmlPage.
     */
    @GetMapping("/delete/{iden}")
    public String delete(@PathVariable("iden") int idProdukter) {
        produkterService.deleteById(idProdukter);
        return "redirect:/admin/prod";
    }

    /**
     * This method redirect to update produkter htmlpage.
     *
     * @param idProdukter Id from Database.
     * @param model       attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/updateprod/{id}")
    public String Update(@PathVariable("id") int idProdukter, Model model) {
        model.addAttribute("produkt", produkterService.findById(idProdukter));
        model.addAttribute("Kategorier", kategoriService.fetchAll());
        return "updateprod";
    }

    /**
     * This method redirect to update produkter htmlpage.
     *
     * @param produkter called from Model classes.
     * @return htmlPage.
     */
    @PostMapping("/updateprod")
    public String updateIt(@ModelAttribute Produkter produkter) {
        produkterService.update(produkter);
        return "redirect:/admin/prod";
    }

    /**
     * This method redirect to nyhed htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/nyhed")
    public String nyhedsbrevData(Model model) {

        model.addAttribute("nyhed", nyhedsbrevService.fetchAll());

        return "nyhed";
    }

    /**
     * This method redirect to add new nyhed htmlpage.
     *
     * @return htmlPage.
     */
    @GetMapping("/addnyhed")
    public String showAddNyhed() {
        return "addnyhed";
    }

    /**
     * This method redirect to nyhed htmlpage.
     *
     * @param nyhedsbrev called from Model classes.
     * @return htmlPage.
     */
    @PostMapping("/addnyhed")
    public String addnyhed(@ModelAttribute Nyhedsbrev nyhedsbrev) {
        nyhedsbrevService.addItem(nyhedsbrev);
        return "redirect:/nyhed";
    }

    /**
     * This method deletes database entry.
     *
     * @param id called from Database table.
     * @return htmlPage.
     */
    @GetMapping("deletenyhed/{id}")
    public String unsubscribe(@PathVariable int id) {
        nyhedsbrevService.deleteById(id);
        return "redirect:/admin/nyhed";
    }

    /**
     * This method redirect to repair htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/repair")
    public String repairData(Model model) {
        model.addAttribute("rep", repairService.fetchAll());
        return "repair";
    }

    /**
     * This method redirect to create new repair htmlpage.
     *
     * @return htmlPage.
     */
    @GetMapping("/newrepair")
    public String showNewRepair() {
        return "newrepair";
    }

    /**
     * This method redirect to html htmlpage.
     *
     * @param repair called from Model classes.
     * @return htmlPage.
     */
    @PostMapping("newrepair")
    public String newRepair(@ModelAttribute Repair repair) {
        repairService.addItem(repair);
        return "redirect:/";
    }

    /**
     * This method deletes database entry.
     *
     * @param id called from Database table.
     * @return htmlPage.
     */
    @GetMapping("deleteordre/{id}")
    public String deleteOrdre(@PathVariable int id) {
        repairService.deleteById(id);
        return "redirect:/admin/repair";
    }

    /**
     * This method redirect to update repair htmlpage.
     *
     * @param id    Id from Database.
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/updaterepair/{id}")
    public String updateRepair(@PathVariable("id") int id, Model model) {
        model.addAttribute("rep", repairService.findById(id));
        return "updaterepair";
    }

    /**
     * This method redirect to update repair htmlpage.
     *
     * @param repair called from Model classes.
     * @return htmlPage.
     */

    @PostMapping("/updaterepair")
    public String updateRepair(@ModelAttribute Repair repair) {
        repairService.update(repair);
        return "redirect:/admin/repair";
    }

    /**
     * This method redirect to reparationspriser htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/reparationspriser")
    public String reprationspriserData(Model model) {
        model.addAttribute("pris", reparationspriserService.fetchAll());
        return "reparationspriser";
    }

    /**
     * This method redirect to add reparationspriser htmlpage.
     *
     * @return htmlPage.
     */
    @GetMapping("/addreparationspriser")
    public String Showreparationspriser() {
        return "addreparationspriser";
    }

    /**
     * This method redirect to reparationspiser htmlpage.
     *
     * @param reparationspriser called from Model classes.
     * @return htmlPage.
     */
    @PostMapping("/addreparationspriser")
    public String createpriser(@ModelAttribute Reparationspriser reparationspriser) {
        reparationspriserService.addItem(reparationspriser);
        return "redirect:/admin/reparationspriser";
    }

    /**
     * This method deletes database entry.
     *
     * @param id called from Database table.
     * @return htmlPage.
     */
    @GetMapping("/deletereparationspriser/{id}")
    public String deletereparationspriser(@PathVariable("id") int id) {
        reparationspriserService.deleteById(id);
        return "redirect:/admin/reparationspriser";
    }

    /**
     * This method redirect to update reparationspriser htmlpage.
     *
     * @param id    Id from Database.
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/updatereparationspriser/{id}")
    public String updatepriser(@PathVariable("id") int id, Model model) {
        model.addAttribute("pris", reparationspriserService.findById(id));
        return "updatereparationspriser";

    }

    /**
     * This method redirect to reparationspriser htmlpage.
     *
     * @param reparationspriser called from Model classes.
     * @return htmlPage.
     */
    @PostMapping("/updatereparationspriser")
    public String updatePriser(@ModelAttribute Reparationspriser reparationspriser) {
        reparationspriserService.update(reparationspriser);
        return "redirect:/admin/reparationspriser";
    }

    @GetMapping("/betingelser")
    public String visBetingelser(Model model) {
        model.addAttribute("Privatliv", betingelseService.findById(1));
        return "betingelser";
    }

    @PostMapping("/betingelser")
    public String test(@ModelAttribute Betingelse betingelse) {
        betingelseService.update(betingelse);
        return "redirect:/admin/";
    }

}
