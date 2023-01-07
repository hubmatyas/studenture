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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "subject_term")
@RequiredArgsConstructor
public class SubjectTerm {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "academic_year")
    private String academicYear = "2022/2023";

    @Column(name = "semester", columnDefinition = "ENUM('ZS', 'LS)")
    @Enumerated(EnumType.STRING)
    private Semester semester = Semester.ZS;

    @OneToMany
    @JoinColumn(name = "term_id")
    private List<MilestoneResult> milestoneResults;


    @Min(0)
    @Max(100)
    @Column(name = "result")
    private int subjectResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public List<MilestoneResult> getMilestoneResults() {
        return milestoneResults;
    }

    public void setMilestoneResults(List<MilestoneResult> milestoneResults) {
        this.milestoneResults = milestoneResults;
    }

    public int getSubjectResult() {
        return subjectResult;
    }

    public void setSubjectResult(int subjectResult) {
        this.subjectResult = subjectResult;
    }


    @Override
    public String toString() {
        return "SubjectTerm{" +
                "id=" + id +
                ", subject=" + subject +
                ", academicYear='" + academicYear + '\'' +
                ", semester=" + semester +
                ", milestoneResults=" + milestoneResults +
                ", subjectResult=" + subjectResult +
                '}';
    }
}
