package de.kapitalrechner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.Valid;

@Controller
public class KapitalrechnerController {

    private Rechner rechner;
    public KapitalrechnerController(Rechner rechner){
        this.rechner = rechner;
    }

    @GetMapping("/")
    public String startseite(Model model) {
        model.addAttribute("kapitalForm",new KapitalForm(0,0,0) );
        return "kapitalrechner";
    }

    @GetMapping("/submit")
    public String berechnekapital(@Valid KapitalForm kapitalForm, BindingResult bindingResult, Model model  ) {
        model.addAttribute("kapitalForm" ,kapitalForm);
        if (bindingResult.hasErrors()) {
            return "kapitalrechner";
        }

        String endkapital =Double.toString(rechner.berechneEndkapitalMitZinseszins(kapitalForm))
            .replace("." , ",");


        model.addAttribute("endkapital", endkapital);
        return "kapitalrechner";
    }


}
