package net.studenture.api.services;

import net.studenture.api.entities.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    public void addSubject(Subject subject);

    public Optional<Subject> findByID(Long id);

    public void deleteSubject(Long id);

    public void updateSubject(Subject subject);

    public List<Subject> findAll();

}
