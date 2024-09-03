package com.example.sbbmission.domain.question.question.entity;

import com.example.sbbmission.domain.answer.answer.entity.Answer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    @Builder
    public Question(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }




    public void modifySubject(String newSubject) {
        this.subject = newSubject;
    }

    public void modifyContent(String newContent) {
        this.content = newContent;
    }



}
