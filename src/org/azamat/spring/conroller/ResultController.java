package org.azamat.spring.conroller;

import org.azamat.spring.model.EnterForm;
import org.azamat.spring.rep.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ResultController {
    @GetMapping("/result")
    public String upload(Model model) {
        model.addAttribute("enterForm1", new EnterForm());
        return "result";
    }
    @PostMapping("/result")
    public String find(@ModelAttribute EnterForm enterForm1,
                       Model model,
                       HttpServletRequest request,
                       @RequestHeader(value="User-Agent") String userAgent) {

        model.addAttribute("enterForm1", Repository.find(enterForm1));
        HttpSession session = request.getSession(true);
        Date creationTime = new Date(session.getCreationTime());
        model.addAttribute("date", creationTime);
        model.addAttribute("user", userAgent);
        if (Repository.find(enterForm1) != null)
            return "search";
        return "notfound";
    }
}
