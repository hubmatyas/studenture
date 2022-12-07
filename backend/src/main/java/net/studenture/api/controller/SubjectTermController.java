package net.studenture.api.controller;

import lombok.RequiredArgsConstructor;
import net.studenture.api.entities.SubjectTerm;
import net.studenture.api.repositories.SubjectTermRepository;
import net.studenture.api.services.SubjectTermServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class SubjectTermController {

    @Autowired
    private final SubjectTermRepository subjectTermRepository;

    @Autowired
    private final SubjectTermServiceImpl subjectTermService;

    @GetMapping("/subjectterm")
    public String greeting(Model model) {
        model.addAttribute("subjectterm", new SubjectTerm());
        List<SubjectTerm> list = subjectTermService.findAll();
        model.addAttribute("list", list);
        return "subjectterm";
    }

    @PostMapping(value = "/subjectterm/add")
    public String addSubject(@ModelAttribute("subjectterm") @Valid SubjectTerm subjectTerm) {
        if (subjectTerm.getId() == null) {
            this.subjectTermService.addSubjectTerm(subjectTerm);
        } else {
            this.subjectTermService.updateSubjectTerm(subjectTerm);
        }
        return "redirect:/subjectterm";
    }

    @GetMapping(value = "subjectterm/remove/{id}")
    public String deleteSubject(@PathVariable("id") Long id) {
        this.subjectTermService.deleteSubjectTerm(id);
        return "redirect:/subjectterm";
    }

    @GetMapping(value = "subjectterm/edit/{id}")
    public String updateSubject(@PathVariable("id") Long id, Model model) {
        model.addAttribute("subjectterm", this.subjectTermService.findByID(id));
        model.addAttribute("list", this.subjectTermService.findAll());
        return "redirect:/subjectterm";
    }

    @GetMapping(value = "subjectterm/{id}")
    public String getSubject(@PathVariable("id") Long id, Model model) {
        model.addAttribute("subjectterm", this.subjectTermService.findByID(id));
        return "subjectterm";
    }
}
