package net.studenture.api.entities;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

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
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "subject")
@Getter
@Setter
@RequiredArgsConstructor
public class Subject {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "guarant")
    private String guarant;

    @Column(name = "credits", nullable = false)
    @Min(3)
    @Max(20)
    private int credits = 20;

    @Column(name = "goal")
    private String goal;

    @Column(name = "degree", columnDefinition = "ENUM('BC', 'MGR)")
    @Enumerated(EnumType.STRING)
    private Degree degree = Degree.BC;

    @Column(name = "language", columnDefinition = "ENUM('CZ', 'EN)")
    @Enumerated(EnumType.STRING)
    private Language language = Language.CZ;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", guarant='" + guarant + '\'' +
                ", credits=" + credits +
                ", goal='" + goal + '\'' +
                ", degree='" + degree + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Subject subject = (Subject) o;
        return id != null && Objects.equals(id, subject.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
