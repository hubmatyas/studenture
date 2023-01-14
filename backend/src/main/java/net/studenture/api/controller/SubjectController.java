package net.studenture.api.controller;

import lombok.RequiredArgsConstructor;
import net.studenture.api.entities.Subject;
import net.studenture.api.services.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class SubjectController {

    @Autowired
    private final SubjectServiceImpl subjectService;

    @GetMapping("/subject")
    public String greeting(Model model) {
        model.addAttribute("subject", new Subject());
        List<Subject> list = subjectService.findAll();
        model.addAttribute("list", list);
        return "subject";
    }

    @PostMapping(value = "/subject/add")
    public String addSubject(@ModelAttribute("subject") @Valid Subject subject) {

        if (subject.getId() == null) {
            this.subjectService.addSubject(subject);
        } else {
            this.subjectService.updateSubject(subject);
        }
        return "redirect:/subject";
    }

    @GetMapping(value = "remove/{id}")
    public String deleteSubject(@PathVariable("id") Long id) {
        this.subjectService.deleteSubject(id);
        return "redirect:/subject";
    }


    @GetMapping(value = "subject/{id}")
    public String getSubject(@PathVariable("id") Long id, Model model) {
        model.addAttribute("subject", this.subjectService.findByID(id));
        return "subject";
    }
}
