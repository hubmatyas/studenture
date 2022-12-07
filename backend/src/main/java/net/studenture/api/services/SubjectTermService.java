package net.studenture.api.services;

import net.studenture.api.entities.Subject;
import net.studenture.api.entities.SubjectTerm;

import java.util.List;
import java.util.Optional;


public interface SubjectTermService {

    public void addSubjectTerm(SubjectTerm subjectTerm);

    public Optional<SubjectTerm> findByID(Long id);

    public void deleteSubjectTerm(Long id);

    public void updateSubjectTerm(SubjectTerm subjectTerm);

    public List<SubjectTerm> findAll();

}
