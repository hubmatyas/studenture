package net.studenture.api.services;

import net.studenture.api.entities.SubjectTerm;
import net.studenture.api.repositories.SubjectTermRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectTermServiceImpl implements SubjectTermService {

    private static final Logger loggerSubject = LogManager.getLogger(SubjectTermServiceImpl.class);

    @Autowired
    private final SubjectTermRepository subjectTermRepository;

    public SubjectTermServiceImpl(SubjectTermRepository subjectTermRepository) {
        this.subjectTermRepository = subjectTermRepository;
    }

    @Override
    public void addSubjectTerm(SubjectTerm subjectTerm) {
        this.subjectTermRepository.save(subjectTerm);
    }

    @Override
    public Optional<SubjectTerm> findByID(Long id) {
        Optional<SubjectTerm> optional = this.subjectTermRepository.findById(id);
        SubjectTerm subjectTerm = null;
        if (optional.isPresent()) {
            subjectTerm = optional.get();
        } else {
            loggerSubject.error("SubjectTerm not found,id " + id);
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
        loggerSubject.info(this.subjectTermRepository.findAll());
        return this.subjectTermRepository.findAll();
    }


}
