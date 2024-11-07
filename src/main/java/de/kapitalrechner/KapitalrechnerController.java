package de.kapitalrechner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class KapitalrechnerController {

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

        double endkapital = kapitalForm.berechneEndkapitalMitZinseszins();
        //TODO in html mit if verarbeiten
        model.addAttribute("endkapital", endkapital);
        return "kapitalrechner";
    }


}
