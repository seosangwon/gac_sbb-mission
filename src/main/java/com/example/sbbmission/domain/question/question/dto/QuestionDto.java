package com.example.sbbmission.domain.question.question.dto;

import com.example.sbbmission.domain.answer.answer.entity.Answer;
import com.example.sbbmission.domain.question.question.entity.Question;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


public class QuestionDto {

    @Data
    public static class QuestionRequestDto {
        private String subject;
        private String content;
        private LocalDateTime createDate;


        public Question toEntity() {
            return Question.builder()
                    .subject(this.getSubject())
                    .content(this.getContent())
                    .build();
        }


    }

    @Data
    @Builder
    public static class QuestionResponseDto {

        private Long id;
        private String subject;
        private String content;
        private LocalDateTime createDate;
        private List<Answer> answers;

        // 엔티티를 DTO로 변환하는 메서드
        public static QuestionResponseDto fromEntity(Question question) {
            return QuestionResponseDto.builder()
                    .id(question.getId())
                    .subject(question.getSubject())
                    .content(question.getContent())
                    .createDate(question.getCreateDate())
                    .answers(question.getAnswers())
                    .build();
        }


    }

}
