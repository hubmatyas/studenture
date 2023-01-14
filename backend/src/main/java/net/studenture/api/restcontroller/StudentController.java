package net.studenture.api.restcontroller;

import java.util.Map;
import net.studenture.api.repositories.UserRepository;
import net.studenture.api.restcontroller.body.SubjectTermRegister;
import net.studenture.api.services.RecordCardService;
import net.studenture.api.services.SubjectTermService;
import net.studenture.api.services.UserService;
import net.studenture.api.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final UserService userService;
    private final SubjectTermService subjectTermService;
    private final RecordCardService recordCardService;
    private final UserRepository userRepository;

    @Autowired
    public StudentController(UserService userService, SubjectTermService subjectTermService, RecordCardService recordCardService,
        final UserRepository userRepository) {
        this.userService = userService;
        this.subjectTermService = subjectTermService;
        this.recordCardService = recordCardService;
        this.userRepository = userRepository;
    }

    @PostMapping("/term/register")
    public String termRegister(@RequestBody SubjectTermRegister subjectTermRegister, @RequestHeader Map<String, String> session) {
        if (Session.checkSession(userRepository, session)) {
            return null;
        } else {
            return null;
        }
    }
}
