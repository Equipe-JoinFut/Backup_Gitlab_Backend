package com.ages.joinfut.repository;

import com.ages.joinfut.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByidUser(Long id);
    List<User> findByemail(String email);
}
