package net.studenture.api.repositories;

import net.studenture.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGoogleRepository extends JpaRepository<User,String> {

}
