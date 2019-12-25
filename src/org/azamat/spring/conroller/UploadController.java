package org.azamat.spring.conroller;

import org.azamat.spring.model.EnterForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/upload")
    public String upload(Model model) {
        model.addAttribute("enterForm", new EnterForm());
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute EnterForm enterForm,
                         @RequestParam("file") MultipartFile file) {
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String resultFileName = file.getOriginalFilename();
            try {
                file.transferTo(new File(uploadPath + "/" + resultFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            enterForm.setFilename(resultFileName);
        }

        return "redirect:/result";
    }



}
