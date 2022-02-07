package net.repository;


import net.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByFirstName(String firstName);
    User findByEmail(String email);
    User findByNumber(String number);
}