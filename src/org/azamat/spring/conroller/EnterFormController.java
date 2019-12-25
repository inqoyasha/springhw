package org.azamat.spring.conroller;

import org.azamat.spring.model.EnterForm;
import org.azamat.spring.rep.Repository;

import org.azamat.spring.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Controller
public class EnterFormController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    MailSender mailSender;

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
        String mes = String.format("Hello, %s %s!", enterForm.getFirstName(), enterForm.getPatronymic());
        mailSender.send(enterForm.getEmail(), "YO", mes);
        Repository.toJSON(enterForm);
        model.addAttribute("enterForm1", new EnterForm());
        return "result";
    }
}
