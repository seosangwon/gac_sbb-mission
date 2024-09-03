package com.example.sbbmission.domain.question.question.servcie;

import com.example.sbbmission.domain.question.question.dto.QuestionDto;
import com.example.sbbmission.domain.question.question.entity.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class QuestionServiceTest {
    @Autowired
    private QuestionService questionService;


    @Test
    @DisplayName("Question 생성 ")
    @Rollback(value = false)
    public void t1() {
        QuestionDto.QuestionRequestDto request = new QuestionDto.QuestionRequestDto();
        request.setSubject("테스트제목");
        request.setContent("테스트내용");
        QuestionDto.QuestionResponseDto question = questionService.createQuestion(request);

        Assertions.assertThat(question.getSubject()).isEqualTo("테스트제목");
    }

    @Test
    @DisplayName("1번 Question 생성 및 조회")
    @Rollback(value = false)
    public void t2() {
        QuestionDto.QuestionResponseDto question = questionService.findById(1L);
        Assertions.assertThat(question.getSubject()).isEqualTo("제목1");
    }
    @Test
    @DisplayName("Question 삭제 ")
    @Rollback(value = false)
    public void t3() {
        List<Question> all = questionService.findAll();
        // 리스트가 비어있지 않다면 마지막 요소를 가져옵니다.
        if (!all.isEmpty()) {
            Question lastQuestion = all.get(all.size() - 1); // 리스트의 마지막 요소 가져오기
            questionService.remove(lastQuestion);
        }



    }



}