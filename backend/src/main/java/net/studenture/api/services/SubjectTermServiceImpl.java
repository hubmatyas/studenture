package net.studenture.api.services;

import net.studenture.api.entities.Degree;
import net.studenture.api.entities.MilestoneResult;
import net.studenture.api.entities.Milestones;
import net.studenture.api.entities.Semester;
import net.studenture.api.entities.Subject;
import net.studenture.api.entities.SubjectTerm;
import net.studenture.api.repositories.SubjectRepository;
import net.studenture.api.repositories.SubjectTermRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectTermServiceImpl implements SubjectTermService {

    private static final Logger logger = LogManager.getLogger(SubjectTermServiceImpl.class);

    @Autowired
    private final SubjectTermRepository subjectTermRepository;

     public SubjectTermServiceImpl(SubjectTermRepository subjectTermRepository) {
        this.subjectTermRepository = subjectTermRepository;
    }

    @Override
    public void addSubjectTerm(SubjectTerm subjectTerm) {
        this.subjectTermRepository.save(subjectTerm);
    }

    public void addtest() {
        SubjectTerm test = new SubjectTerm();
        Subject subject = new Subject();

        subject.setName("Test subject");
        subject.setDegree(Degree.BC);

        test.setAcademicYear("2022/2023");
        test.setSemester(Semester.LS);

        MilestoneResult milestoneResult = new MilestoneResult();
        milestoneResult.setMilestone(Milestones.TEST);
        milestoneResult.setMaximum(100);
        milestoneResult.setResult(20);

        MilestoneResult milestoneResult1 = new MilestoneResult();
        milestoneResult1.setMilestone(Milestones.EXAM);
        milestoneResult1.setMaximum(100);
        milestoneResult1.setResult(20);

        List<MilestoneResult> result = new ArrayList<>();
        result.add(milestoneResult);
        result.add(milestoneResult1);

        test.setMilestoneResults(result);
        logger.info(test);
    }

    @Override
    public Optional<SubjectTerm> findByID(Long id) {
        Optional<SubjectTerm> optional = this.subjectTermRepository.findById(id);
        SubjectTerm subjectTerm = null;
        if (optional.isPresent()) {
            subjectTerm = optional.get();
        } else {
            logger.error("SubjectTerm not found,id " + id);
            throw new RuntimeException("SubjectTerm not found...");
        }
        return Optional.of(subjectTerm);
    }

    @Override
    public void deleteSubjectTerm(Long id) {
        this.subjectTermRepository.deleteById(id);

    }

    @Override
    public void updateSubjectTerm(SubjectTerm subjectTerm) {
        this.subjectTermRepository.save(subjectTerm);
    }

    @Override
    public List<SubjectTerm> findAll() {
        logger.info(this.subjectTermRepository.findAll());
        return this.subjectTermRepository.findAll();
    }


}
