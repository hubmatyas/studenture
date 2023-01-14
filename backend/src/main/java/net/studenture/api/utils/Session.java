package net.studenture.api.utils;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import net.studenture.api.entities.User;
import net.studenture.api.repositories.UserRepository;

public class Session {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static Random rnd = new Random();

    public static String createSessionId(){
        StringBuilder sb = new StringBuilder( 10 );
        for( int i = 0; i < 10; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public static Boolean checkSession(UserRepository userRepository, Map<String, String> session) {
        Optional<User> userOptional = userRepository.findBySessionId(session.get("sessionId"));

        return false;
    }
}
