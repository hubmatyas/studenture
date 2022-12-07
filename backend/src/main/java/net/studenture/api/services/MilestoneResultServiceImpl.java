package net.studenture.api.services;

import net.studenture.api.entities.MilestoneResult;
import net.studenture.api.entities.Subject;
import net.studenture.api.repositories.MilestoneResultRepository;
import net.studenture.api.repositories.SubjectRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilestoneResultServiceImpl implements MilestoneResultService {
    private static final Logger logger = LogManager.getLogger(MilestoneResultServiceImpl.class);

    @Autowired
    private final MilestoneResultRepository milestoneResultRepository;

    public MilestoneResultServiceImpl(MilestoneResultRepository milestoneResultRepository) {
        this.milestoneResultRepository = milestoneResultRepository;
    }



    @Override
    public Optional<MilestoneResult> findByID(Long id) {
        Optional<MilestoneResult> optional = this.milestoneResultRepository.findById(id);
        MilestoneResult milestoneResult = null;
        if (optional.isPresent()) {
            milestoneResult = optional.get();
        } else {
            logger.error("MilestoneResult not found");
            throw new RuntimeException("MilestoneResult not found...");
        }
        return Optional.of(milestoneResult);
    }

    @Override
    public void deleteMilestoneResult(Long id) {
        this.milestoneResultRepository.deleteById(id);
    }

    @Override
    public void addMilestoneResult(MilestoneResult milestoneResult) {
        logger.info(milestoneResult);
        this.milestoneResultRepository.save(milestoneResult);
    }

    @Override
    public void updateMilestoneResult(MilestoneResult milestoneResult) {
        this.milestoneResultRepository.save(milestoneResult);
    }

    @Override
    public List<MilestoneResult> findAll() {
        logger.info(this.milestoneResultRepository.findAll());
        return this.milestoneResultRepository.findAll();
    }
}
