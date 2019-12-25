package org.azamat.spring.conroller;

import org.azamat.spring.model.EnterForm;
import org.azamat.spring.rep.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;



@Controller
public class EnterFormController {
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/enterform")
    public String eneterForm(Model model) {
        model.addAttribute("enterForm", new EnterForm());
        return "enterform";
    }

    @PostMapping("/enterform")
    public String eneterFormToJSON(@ModelAttribute @Valid EnterForm enterForm,
                                   BindingResult results,
                                   Model model) {
        if (results.hasErrors()) {
            return "enterform";
        }
        Repository.toJSON(enterForm);

        return "result";
    }

//    @PostMapping("/result")
//    public String find(@ModelAttribute EnterForm enterForm1, Model model) {
//        model.addAttribute("enterForm1", Repository.find(enterForm1));
//        return "search";
//    }
}
