package org.azamat.spring.conroller;

import org.azamat.spring.model.EnterForm;
import org.azamat.spring.rep.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EnterFormController {
    @GetMapping("/enterform")
    public String eneterForm(Model model) {
        EnterForm ef = new EnterForm();
        model.addAttribute("enterform", ef);
        Repository.toJSON(ef);
        return "enterform";
    }

    @PostMapping("/enterform")
    public String eneterForm(@ModelAttribute EnterForm enterForm) {
        return "result";
    }
}
