package com.example.sbbmission.domain.answer.answer.entity;

import com.example.sbbmission.domain.question.question.entity.Question;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Builder
    public Answer(String content, Question question)  {
        this.content = content;
        setQuestion(question);
    }

    //연관관계 편의 메서드 : answer가 생성되면은 question의 answerList에 추가 하기
    private void setQuestion(Question question) {
        this.question = question;
        question.getAnswers().add(this);
    }


}
