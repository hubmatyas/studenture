package net.studenture.api.services;

import net.studenture.api.Application;
import net.studenture.api.entities.Subject;
import net.studenture.api.repositories.SubjectRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    private static final Logger loggerSubject = LogManager.getLogger(SubjectServiceImpl.class);

    @Autowired
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void addSubject(Subject subject) {
        this.subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> findByID(Long id) {
        Optional<Subject> optional = this.subjectRepository.findById(id);
        Subject subject = null;
        if (optional.isPresent()) {
            subject = optional.get();
        } else {
            loggerSubject.error("Subject not found");
            throw new RuntimeException("Subject not found...");
        }
        return Optional.of(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        this.subjectRepository.deleteById(id);
    }

    @Override
    public void updateSubject(Subject subject) {
        this.subjectRepository.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        loggerSubject.info(this.subjectRepository.findAll());
        return this.subjectRepository.findAll();
    }
}
