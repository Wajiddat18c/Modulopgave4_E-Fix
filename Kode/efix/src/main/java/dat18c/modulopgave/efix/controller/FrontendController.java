/**
 * dat18c.modulopgave.efix.controller
 */
package dat18c.modulopgave.efix.controller;

import dat18c.modulopgave.efix.model.Calculator;
import dat18c.modulopgave.efix.model.Images;
import dat18c.modulopgave.efix.model.Nyhedsbrev;
import dat18c.modulopgave.efix.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This a FrontendController that handles logic
 *
 * @author Aleksandr Sorokin
 * @author Ali Al-Sharefi
 * @author Thomas Broe
 * @author Wajid Ahmad
 */
@Controller
public class FrontendController {

    @Autowired
    ButikService butikService;

    @Autowired
    NyhedsbrevService nyhedsbrevService;

    @Autowired
    ProdukterService produkterService;

    @Autowired
    SearchService searchService;

    @Autowired
    ReparationspriserService reparationspriserService;

    @Autowired
    BetingelseService betingelseService;

    /**
     * This method redirect to htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/")
    public String frontPage(Model model) {

        model.addAttribute("butikker", butikService.fetchAll());
        return "index";
    }

    /**
     * This method redirect to buy htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/buy")
    public String buy(Model model) {
        return "buy";
    }

    /**
     * This method redirect to sell htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/sell")
    public String sell(Model model) {
        return "sell";
    }

    /**
     * This method calculate phone prices
     *
     * @param calculator attribute called from Model class.
     * @param model      attribute to call Service classes.
     * @return htmlPage.
     */
    @PostMapping("udregn")
    public String udregn(@ModelAttribute Calculator calculator, Model model) {

        HashMap<String, Integer> phone = new HashMap<>();
        phone.put("Iphone X", 6000);
        phone.put("Samsung S9", 5600);
        phone.put("Huawei P20", 4000);
        phone.put("Iphone 4", 1200);


        ArrayList<Integer> phoneCondition = new ArrayList<>(3);
        phoneCondition.add(2); //[0] good cond
        phoneCondition.add(3); //[1] decent cond
        phoneCondition.add(0); //[2] bad cond


        int pickPhone = calculator.getPickPhone();
        int pickPower = calculator.getPickPower();
        int pickMainFeatures = calculator.getPickMainFeatures();
        int pickAppearance = calculator.getPickAppearance();
        int pickScreen = calculator.getPickScreen();
        int pickLiquid = calculator.getPickLiquid();
        int pickDeviceLocks = calculator.getPickDeviceLocks();

        System.out.println(pickPower + "TEST" + pickMainFeatures);
        switch (pickPhone) {
            case 1:
                if (pickPower == 1 && pickMainFeatures == 1 && pickAppearance == 1
                        && pickScreen == 1 && pickLiquid == 1 && pickDeviceLocks == 1) {
                    int a = phone.get("Iphone X") / phoneCondition.get(0);
                    model.addAttribute("result", a);
                } else if (pickPower == 1 && pickMainFeatures == 1 && pickAppearance == 2
                        && pickScreen == 1 && pickLiquid == 1 && pickDeviceLocks == 1) {
                    int a = phone.get("Iphone X") / phoneCondition.get(1);
                    model.addAttribute("result", a);
                } else {
                    int a = 0;
                    model.addAttribute("result", a);
                }

                break;
            case 2:
                if (pickPower == 1 && pickMainFeatures == 1 && pickAppearance == 1
                        && pickScreen == 1 && pickLiquid == 1 && pickDeviceLocks == 1) {
                    int a = phone.get("Samsung S9") / phoneCondition.get(0);
                    model.addAttribute("result", a);
                } else if (pickPower == 1 && pickMainFeatures == 1 && pickAppearance == 2
                        && pickScreen == 1 && pickLiquid == 1 && pickDeviceLocks == 1) {
                    int a = phone.get("Samsung S9") / phoneCondition.get(1);
                    model.addAttribute("result", a);
                } else {
                    int a = 0;
                    model.addAttribute("result", a);
                }

                break;
            case 3:
                if (pickPower == 1 && pickMainFeatures == 1 && pickAppearance == 1
                        && pickScreen == 1 && pickLiquid == 1 && pickDeviceLocks == 1) {
                    int a = phone.get("Huawei P20") / phoneCondition.get(0);
                    model.addAttribute("result", a);
                } else if (pickPower == 1 && pickMainFeatures == 1 && pickAppearance == 2
                        && pickScreen == 1 && pickLiquid == 1 && pickDeviceLocks == 1) {
                    int a = phone.get("Huawei P20") / phoneCondition.get(1);
                    model.addAttribute("result", a);
                } else {
                    int a = 0;
                    model.addAttribute("result", a);
                }


                break;
            case 4:
                if (pickPower == 1 && pickMainFeatures == 1 && pickAppearance == 1
                        && pickScreen == 1 && pickLiquid == 1 && pickDeviceLocks == 1) {
                    int a = phone.get("Iphone 4") / phoneCondition.get(0);
                    model.addAttribute("result", a);
                } else if (pickPower == 1 && pickMainFeatures == 1 && pickAppearance == 2
                        && pickScreen == 1 && pickLiquid == 1 && pickDeviceLocks == 1) {
                    int a = phone.get("Iphone 4") / phoneCondition.get(1);
                    model.addAttribute("result", a);
                } else {
                    int a = 0;
                    model.addAttribute("result", a);
                }


                break;
            default:
                System.out.println("Wrong input!");
//                System.out.println(pickPhone + " + " + pickCondition);
                break;
        }
        return "calculator";
    }


    /**
     * This method redirect to nyheds htmlpage.
     *
     * @return htmlPage.
     */
    @GetMapping("/addnyhed")
    public String showAddNyhed() {
        return "addnyhed";
    }

    /**
     * This method redirect to crete new nyhed htmlpage.
     *
     * @param nyhedsbrev called from Model classes.
     * @return htmlPage.
     */
    @PostMapping("/addnyhed")
    public String addnyhed(@ModelAttribute Nyhedsbrev nyhedsbrev) {
        if (nyhedsbrev.isAcceptPP() && nyhedsbrev.geteMail().matches("[^@]+@[^@]+\\.[a-zA-Z]{2,6}")) {
//            nyhedsbrevService.addItem(nyhedsbrev);
            if(nyhedsbrevService.checkForValidation(nyhedsbrev))
                return "redirect:/";
            else
                return "redirect:/nyhederror";
        } else {
            return "redirect:/nyhederror";
        }
    }

    /**
     * This method request nyhedserror htmlpage.
     *
     * @return htmlPage.
     */
    @RequestMapping("/nyhederror")
    public String nyhedError() {
        return "nyhederror";
    }

    /**
     * This method redirect to privatoplitik htmlpage.
     *
     * @return htmlPage.
     */
    @GetMapping("/privatliv")
    public String privatlivsPolitik(Model model) {
        model.addAttribute("Privatliv", betingelseService.findById(1));
        return "privatliv/english";
    }

    /**
     * This method redirect to new repair htmlpage.
     *
     * @return htmlPage.
     */
    @GetMapping("/newrepair")
    public String addNewRepair() {
        return "newrepair";
    }

    /**
     * This method redirect to faq htmlpage.
     *
     * @return htmlPage.
     */
    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }


    /**
     * This method redirect to htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/Buyphone")
    public String index(Model model) {
        List<Images> images = new ArrayList<>();
        images.add(new Images(1, "Iphonex", 100, 90));
        images.add(new Images(2, "S9", 90, 500));
        images.add(new Images(3, "Huawei", 90, 1000));
        model.addAttribute("images", images);
        model.addAttribute("iphone", produkterService.findById(17));
        model.addAttribute("samsung", produkterService.findById(18));
        model.addAttribute("huawei", produkterService.findById(19));
        return "Buyphone";
    }

    /**
     * This method redirect to Buy pc htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/Buypc")
    public String index1(Model model) {
        List<Images> images = new ArrayList<>();
//        images.add(new Images(1, "Iphonex", 100, 90));
        images.add(new Images(4, "Macbookpro", 100, 90));
        images.add(new Images(5, "air", 90, 500));
        images.add(new Images(6, "Imac", 90, 1000));


        model.addAttribute("images", images);

        model.addAttribute("pro", produkterService.findById(20));
        model.addAttribute("air", produkterService.findById(21));
        model.addAttribute("imac", produkterService.findById(22));
        return "Buypc";
    }

    /**
     * This method redirect to Buy accessories htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/Buyaccessories")
    public String index2(Model model) {
        List<Images> images = new ArrayList<>();
        images.add(new Images(7, "Appleearpods", 100, 90));
        images.add(new Images(8, "Panzerglass", 90, 500));
        images.add(new Images(9, "Biloplader", 90, 1000));

//        images.add(new Images(1, "Iphonex", 100, 90));

        model.addAttribute("images", images);

        model.addAttribute("earpods", produkterService.findById(23));
        model.addAttribute("panserglas", produkterService.findById(24));
        model.addAttribute("biloplader", produkterService.findById(25));
        return "Buyaccessories";
    }

    /**
     * This method redirect to show repair price htmlpage.
     *
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/showrepairprice")
    public String index3(Model model) {
        List<Images> images = new ArrayList<>();
        images.add(new Images(10, "screen", 100, 90));
        images.add(new Images(11, "s", 90, 500));
        images.add(new Images(12, "mac", 90, 1000));

//        images.add(new Images(1, "Iphonex", 100, 90));

        model.addAttribute("images", images);

        model.addAttribute("iphone", reparationspriserService.findById(1));
        model.addAttribute("samsung", reparationspriserService.findById(2));
        model.addAttribute("mac", reparationspriserService.findById(3));
        return "showrepairprice";
    }

    /**
     * This method searches in our queries.
     *
     * @param query attribute from database
     * @param model attribute to call Service classes.
     * @return htmlPage.
     */
    @GetMapping("/search")
    public String searchResults(@RequestParam("query") String query, Model model) {
        model.addAttribute("Results", searchService.getResults(query));
        return "search";
    }

}
