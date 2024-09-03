package com.example.sbbmission.domain.answer.answer.dto;

import com.example.sbbmission.domain.answer.answer.entity.Answer;
import com.example.sbbmission.domain.question.question.entity.Question;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

public class AnswerDto {

    @Data
    public static class AnswerRequestDto {
        private String content;

        public Answer toEntity(Question question) {
            return Answer.builder()
                    .content(this.content)
                    .question(question)
                    .build();
        }

    }

    @Data
    @Builder
    public static class AnswerResponseDto {
        private Long id;
        private String content;
        private LocalDateTime createDate;
        private Question question;

        public static AnswerResponseDto fronEntity(Answer answer) {
            return AnswerResponseDto.builder()
                    .id(answer.getId())
                    .content(answer.getContent())
                    .createDate(answer.getCreateDate())
                    .question(answer.getQuestion())
                    .build();
        }

    }






}
