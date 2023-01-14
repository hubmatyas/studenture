package net.studenture.api.restcontroller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.studenture.api.entities.MilestoneResult;
import net.studenture.api.services.MilestoneResultServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/milestone")
public class MilestoneResultController {
    private static final Logger logger = LogManager.getLogger(MilestoneResultController.class);

    @Autowired
    private final MilestoneResultServiceImpl milestoneResultService;

    @GetMapping("")
    public List<MilestoneResult> greeting(Model model) {
        model.addAttribute("milestone", new MilestoneResult());
        logger.info(milestoneResultService.findAll());
        List<MilestoneResult> listMilestones = milestoneResultService.findAll();
        model.addAttribute("list", listMilestones);
        return listMilestones;
    }

    @PostMapping(value = "/add")
    public String addMilestone(@ModelAttribute("milestone") @Valid MilestoneResult milestone) {

        logger.info(milestone);
        if (milestone.getId() == null) {
            milestoneResultService.addMilestoneResult(milestone);
            return "Added";
        } else {
            milestoneResultService.updateMilestoneResult(milestone);
            return "Updated";
        }
    }

    @GetMapping(value = "/remove/{id}")
    public String deleteMilestone(@PathVariable("id") Long id) {
        this.milestoneResultService.deleteMilestoneResult(id);
        return "Deleted";
    }

    // idk for what is this
    @GetMapping(value = "/showFormForUpdate/{id}")
    public String updateMilestone(@PathVariable("id") Long id, Model model) {
        Optional<MilestoneResult> milestone = milestoneResultService.findByID(id);
        model.addAttribute("milestone", milestone);
        model.addAttribute("list", this.milestoneResultService.findAll());
        return "redirect:/milestone";
    }

    @PostMapping(value = "/update")
    public String updateMilestoneForm(MilestoneResult milestone){
        milestoneResultService.updateMilestoneResult(milestone);
        return "Updated";
    }

    @GetMapping(value = "/{id}")
    public MilestoneResult getMilestone(@PathVariable("id") Long id, Model model) {
        Optional<MilestoneResult> milestoneResultOptional = this.milestoneResultService.findByID(id);
        if (milestoneResultOptional.isPresent()) {
            return milestoneResultOptional.get();
        } else {
            return null;
        }
    }
}
