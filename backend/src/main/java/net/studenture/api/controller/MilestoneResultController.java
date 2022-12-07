package net.studenture.api.controller;

import lombok.RequiredArgsConstructor;
import net.studenture.api.entities.MilestoneResult;
import net.studenture.api.services.MilestoneResultServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class MilestoneResultController {
    private static final Logger logger = LogManager.getLogger(MilestoneResultController.class);

    @Autowired
    private final MilestoneResultServiceImpl milestoneResultService;

    @GetMapping("/milestone")
    public String greeting(Model model) {
        model.addAttribute("milestone", new MilestoneResult());
        logger.info(milestoneResultService.findAll());
        List<MilestoneResult> listMilestones = milestoneResultService.findAll();
        model.addAttribute("list", listMilestones);
        return "milestone";
    }

    @PostMapping(value = "/milestone/add")
    public String addMilestone(@ModelAttribute("milestone") @Valid MilestoneResult milestone) {

        logger.info(milestone);
        if (milestone.getId() == null) {
            milestoneResultService.addMilestoneResult(milestone);
        } else {
            milestoneResultService.updateMilestoneResult(milestone);
        }
        return "redirect:/milestone";
    }

    @GetMapping(value = "milestone/remove/{id}")
    public String deleteMilestone(@PathVariable("id") Long id) {
        this.milestoneResultService.deleteMilestoneResult(id);
        return "redirect:/milestone";
    }

    @GetMapping(value = "milestone/showFormForUpdate/{id}")
    public String updateMilestone(@PathVariable("id") Long id, Model model) {
        Optional<MilestoneResult> milestone = milestoneResultService.findByID(id);
        model.addAttribute("milestone", milestone);
        model.addAttribute("list", this.milestoneResultService.findAll());
        return "redirect:/milestone";
    }

    @PostMapping(value = "/milestone-update")
    public String updateMilestoneForm(MilestoneResult milestone){
        milestoneResultService.updateMilestoneResult(milestone);
        return "redirect:/milestone";
    }

    @GetMapping(value = "milestone/{id}")
    public String getMilestone(@PathVariable("id") Long id, Model model) {
        model.addAttribute("milestone", this.milestoneResultService.findByID(id));
        return "milestone";
    }
}
