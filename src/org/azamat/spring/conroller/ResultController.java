package org.azamat.spring.conroller;

import org.azamat.spring.model.EnterForm;
import org.azamat.spring.rep.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultController {

    @GetMapping("/result")
    public String upload(Model model) {
        model.addAttribute("enterForm1", new EnterForm());
        return "result";
    }

    @PostMapping("/result")
    public String find(@ModelAttribute EnterForm enterForm1, Model model) {
        model.addAttribute("enterForm1", Repository.find(enterForm1));
        return "search";
    }
}
