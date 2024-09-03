package com.example.sbbmission.domain.question.question.repository;

import com.example.sbbmission.domain.answer.answer.entity.Answer;
import com.example.sbbmission.domain.answer.answer.repository.AnswerRepository;
import com.example.sbbmission.domain.question.question.entity.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    @DisplayName("수정시 update 쿼리 문이 잘 나가는지 확인 ")
    @Transactional
    void t1() {
        Question q = Question.builder()
                .subject("제목")
                .content("내용")
                .build();

        questionRepository.save(q); // 저장

        q.modifySubject("수정제목111");
        q.modifyContent("수정내용111");

        questionRepository.save(q); //save를 하면 알아서 변경 내용 감지가 작동하기에 수정 쿼리 문이 나갈 것이다

    }
    @Test
    @DisplayName("answer를 저장하면은 갑의 관계이기 때문에 을을 호출 할 수 있다 : JoinColumn덕분  ")
    void t2() {
        Question q = Question.builder()
                .subject("제목")
                .content("내용")
                .build();

        questionRepository.save(q); // 저장

        q.modifySubject("수정제목");
        q.modifyContent("수정내용");

        questionRepository.save(q); //save를 하면 알아서 변경 내용 감지가 작동하기에 수정 쿼리 문이 나갈 것이다

        Answer answer = Answer.builder()
                .content("댓글1")
                .question(q)
                .build();

        answerRepository.save(answer);
        List<Answer> answerList = q.getAnswers();


        String content1 = answerList.getFirst().getContent();

        assertThat(answerList.getFirst()).isEqualTo(answer);

    }

    @Test
    @DisplayName("DB 연결이 끊어지는지 확인 " )
    @Transactional
    void t3() {
        Optional<Question> oq = questionRepository.findById(3L);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswers();

        assertEquals(1,answerList.size());



    }

    @Test
    @DisplayName("findBySubject 테스트  " )
    @Transactional
    void t4() {
        Optional<Question> oq = questionRepository.findBySubject("수정제목111");
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswers();

        assertThat(q.getContent()).isEqualTo("수정내용111");



    }

    @Test
    @DisplayName("findBySubject 가져온 객체를 삭제  " )
    @Transactional
    void t5() {

        List<Question> all1 = questionRepository.findAll();
        Question question = all1.stream().findFirst().get();


        questionRepository.delete(question);

        List<Question> all2 = questionRepository.findAll();


        assertThat(all1.size()).isGreaterThan(all2.size());



    }


}