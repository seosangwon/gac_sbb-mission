package com.example.sbbmission.domain.question.question.repository;

import com.example.sbbmission.domain.question.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question , Long> {


    Optional<Question> findBySubject(String subject);
}
