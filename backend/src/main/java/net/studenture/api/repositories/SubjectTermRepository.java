package net.studenture.api.repositories;

import net.studenture.api.entities.Subject;
import net.studenture.api.entities.SubjectTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTermRepository extends JpaRepository <SubjectTerm,Long> {
}
