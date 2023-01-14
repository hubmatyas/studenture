package net.studenture.api.entities;

import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "milestone_result")
@RequiredArgsConstructor
public class MilestoneResult {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "milestone", columnDefinition = "ENUM('TEST', 'WORKSHOP',' EXAM')")
    @Enumerated(EnumType.STRING)
    private Milestones milestone = Milestones.TEST;

    @Column(name = "maximum")
    @Min(5)
    @Max(100)
    private int maximum = 20;

    @Column(name = "result")
    @Min(0)
    @Max(100)
    private int result = 0;

    @ManyToOne
    @JoinColumn(name = "term_id")
    private SubjectTerm subjectTerm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Milestones getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestones milestone) {
        this.milestone = milestone;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public SubjectTerm getSubjectTerm() {
        return subjectTerm;
    }

    public void setSubjectTerm(SubjectTerm subjectTerm) {
        this.subjectTerm = subjectTerm;
    }

    @Override
    public String toString() {
        return "MilestoneResult{" +
                "id=" + id +
                ", milestone=" + milestone +
                ", maximum=" + maximum +
                ", result=" + result +
                '}';
    }
}
