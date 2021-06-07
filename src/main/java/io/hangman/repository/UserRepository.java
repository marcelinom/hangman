package io.hangman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.hangman.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
