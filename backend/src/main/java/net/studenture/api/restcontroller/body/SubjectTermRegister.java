package net.studenture.api.restcontroller.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectTermRegister {
    private long studentId;
    private long subjectTermId;
}
