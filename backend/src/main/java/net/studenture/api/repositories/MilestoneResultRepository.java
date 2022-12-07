package net.studenture.api.repositories;

import net.studenture.api.entities.MilestoneResult;
import net.studenture.api.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneResultRepository extends JpaRepository <MilestoneResult,Long> {
}
