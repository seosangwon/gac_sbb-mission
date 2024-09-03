package com.example.sbbmission.domain.answer.answer.repository;

import com.example.sbbmission.domain.answer.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
