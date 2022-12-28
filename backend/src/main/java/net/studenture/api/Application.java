package net.studenture.api;

import net.studenture.api.repositories.SubjectTermRepository;
import net.studenture.api.services.SubjectTermServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


		SubjectTermRepository subjectTermRepository = null;
		SubjectTermServiceImpl subjectTest = new SubjectTermServiceImpl(subjectTermRepository);
		//subjectTest.addtest();

		//logger.debug("Debugging log");
		//logger.info("Info log");
		//logger.warn("Hey, This is a warning!");
		//logger.error("Oops! We have an Error. OK");
		//logger.fatal("Damn! Fatal error. Please fix me.");
	}

}
