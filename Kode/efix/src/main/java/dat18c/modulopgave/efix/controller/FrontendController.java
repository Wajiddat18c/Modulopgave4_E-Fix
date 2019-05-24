package dat18c.modulopgave.efix.controller;
import dat18c.modulopgave.efix.model.Images;
import dat18c.modulopgave.efix.model.Nyhedsbrev;
import dat18c.modulopgave.efix.service.ButikService;

import dat18c.modulopgave.efix.service.NyhedsbrevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontendController {

    @Autowired
    ButikService butikService;

    @Autowired
    NyhedsbrevService nyhedsbrevService;

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

    @GetMapping("/addnyhed")
    public String showAddNyhed(){
        return "addnyhed";
    }

    @PostMapping("/addnyhed")
    public String addnyhed(@ModelAttribute Nyhedsbrev nyhedsbrev){
        if(nyhedsbrev.isAcceptPP() && nyhedsbrev.geteMail().matches("[^@]+@[^@]+\\.[a-zA-Z]{2,6}")){
            nyhedsbrevService.addNyhedsbrev(nyhedsbrev);
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
        images.add(new Images(3, "Huawei", 90, 900));
        model.addAttribute("images", images);
        return "Buyphone";
    }
    @GetMapping("/Buypc")
    public String index1(Model model){
        List<Images> images = new ArrayList<>();
//        images.add(new Images(1, "Iphonex", 100, 90));

        model.addAttribute("images", images);
        return "Buypc";
    }

}
