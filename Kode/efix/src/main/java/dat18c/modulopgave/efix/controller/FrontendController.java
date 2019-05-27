package dat18c.modulopgave.efix.controller;
import dat18c.modulopgave.efix.model.Calculator;
import dat18c.modulopgave.efix.model.Images;
import dat18c.modulopgave.efix.model.Nyhedsbrev;
import dat18c.modulopgave.efix.service.ButikService;

import dat18c.modulopgave.efix.service.NyhedsbrevService;
import dat18c.modulopgave.efix.service.ProdukterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class FrontendController {

    @Autowired
    ButikService butikService;

    @Autowired
    NyhedsbrevService nyhedsbrevService;

    @Autowired
    ProdukterService produkterService;

    @GetMapping("/")
    public String frontPage(Model model){

        model.addAttribute("butikker", butikService.fetchAll());
        return "index";
    }


    @GetMapping("/buy")
    public String buy(Model model){
        return "buy";
    }

    @GetMapping("/sell")
    public String sell(Model model){
        return "sell";
    }
    @PostMapping("udregn")
    public String udregn(@ModelAttribute Calculator calculator, Model model){

        HashMap<String, Integer> phone = new HashMap<>();
        phone.put("Iphone X", 6000);
        phone.put("Samsung S9", 5600);
        phone.put("Huawei P20", 4000);
        phone.put("Iphone 4", 1200);


        ArrayList<Integer> phoneCondition = new ArrayList<>(3);
        phoneCondition.add(8); //[0] bad cond
        phoneCondition.add(3); //[1] decent cond
        phoneCondition.add(2); //[2] good cond

        int tal = calculator.getPickPhone();
        int pick = calculator.getPickCondition();


        switch (tal) {
            case 1:
                if (pick == 1) {
                    int a = phone.get("Iphone X") / phoneCondition.get(0);
//                    a = a + 500;
                    model.addAttribute("result", a);
                } else if (pick == 2) {
                    int a = phone.get("Iphone X") / phoneCondition.get(1);
                    model.addAttribute("result", a);
                } else if (pick == 3) {
                    int a = (int) (phone.get("Iphone X") / phoneCondition.get(2));
                    model.addAttribute("result", a);
                }

                break;
            case 2:
                if (pick == 1) {
                    int a = phone.get("Samsung S9") / phoneCondition.get(0);
                    model.addAttribute("result", a);
                } else if (pick == 2) {
                    int a = phone.get("Samsung S9") / phoneCondition.get(1);
                    model.addAttribute("result", a);
                } else if (pick == 3) {
                    int a = (int) (phone.get("Samsung S9") / phoneCondition.get(2));
                    model.addAttribute("result", a);
                }

                break;
            case 3:
                if (pick == 1) {
                    int a = phone.get("Huawei P20") / phoneCondition.get(0);
                    System.out.println("Buy value:" + a);
                    model.addAttribute("result", a);
                } else if (pick == 2) {
                    int a = phone.get("Huawei P20") / phoneCondition.get(1);
                    System.out.println("Buy value:" + a);
                    model.addAttribute("result", a);
                } else if (pick == 3) {
                    int a = (int) (phone.get("Huawei P20") / phoneCondition.get(2));
                    System.out.println("Buy value:" + a);
                    model.addAttribute("result", a);
                }

                break;
            case 4:
                if (pick == 1) {
                    int a = phone.get("Iphone 4") / phoneCondition.get(0);
                    model.addAttribute("result", a);
                } else if (pick == 2) {
                    int a = phone.get("Iphone 4") / phoneCondition.get(1);
                    model.addAttribute("result", a);
                } else if (pick == 3) {
                    int a = (int) (phone.get("Iphone 4") / phoneCondition.get(2));
                    model.addAttribute("result", a);
                }

                break;
            default:
                System.out.println("Wrong input!");
                System.out.println(tal + " + " + pick);
                break;
        }
        return "calculator";
    }



    @GetMapping("/addnyhed")
    public String showAddNyhed(){
        return "addnyhed";
    }

    @PostMapping("/addnyhed")
    public String addnyhed(@ModelAttribute Nyhedsbrev nyhedsbrev){
        if(nyhedsbrev.isAcceptPP() && nyhedsbrev.geteMail().matches("[^@]+@[^@]+\\.[a-zA-Z]{2,6}")){
            nyhedsbrevService.addItem(nyhedsbrev);
            return "redirect:/";
        }
        else{
            return "addnyhed";
        }
    }
    @GetMapping("/privatliv")
    public String privatlivsPolitik(){return "privatliv/english";}

    @GetMapping("/newrepair")
    public String addNewRepair(){
        return "newrepair";
    }

    @GetMapping("/faq")
    public String faq(){
        return "faq";
    }



    @GetMapping("/Buyphone")
    public String index(Model model){
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
    @GetMapping("/Buypc")
    public String index1(Model model){
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

    @GetMapping("/Buyaccessories")
    public String index2(Model model){
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

}
