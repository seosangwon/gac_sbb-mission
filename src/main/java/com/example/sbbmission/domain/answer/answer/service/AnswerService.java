package com.example.sbbmission.domain.answer.answer.service;

import com.example.sbbmission.domain.answer.answer.dto.AnswerDto;
import com.example.sbbmission.domain.answer.answer.entity.Answer;
import com.example.sbbmission.domain.answer.answer.repository.AnswerRepository;
import com.example.sbbmission.domain.question.question.entity.Question;
import com.example.sbbmission.domain.question.question.excpetion.CustomException;
import com.example.sbbmission.domain.question.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    @Transactional
    public AnswerDto.AnswerResponseDto createAnswer(Long questionId , AnswerDto.AnswerRequestDto request) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new CustomException.DataNotFoundException("answer not found"));
        Answer answer = answerRepository.save(request.toEntity(question));

        return AnswerDto.AnswerResponseDto.fronEntity(answer);

    }

}
