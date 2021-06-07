package io.hangman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.hangman.entity.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer>{
}
