package net.studenture.api.services;

import net.studenture.api.entities.MilestoneResult;
import net.studenture.api.entities.Subject;

import java.util.List;
import java.util.Optional;

public interface MilestoneResultService {

    public void addMilestoneResult(MilestoneResult milestoneResult);

    public Optional<MilestoneResult> findByID(Long id);

    public void deleteMilestoneResult(Long id);

    public void updateMilestoneResult(MilestoneResult milestoneResult);

    public List<MilestoneResult> findAll();

}
