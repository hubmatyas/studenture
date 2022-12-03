package net.studenture.api.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "milestone_result")
@Getter
@Setter
@RequiredArgsConstructor
public class MilestoneResult {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "ENUM('TEST', 'WORKSHOP',' EXAM')")
    @Enumerated(EnumType.STRING)
    private Milestones milestone;

    @Column(name = "maximum", nullable = false)
    @Min(5)
    @Max(100)
    private int maximum = 20;

    @Column(name = "result")
    @Min(1)
    @Max(100)
    private int result = 20;

    public enum Milestones {
        TEST,
        WORKSHOP,
        EXAM
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
