package com.example.sbbmission.domain.question.question.servcie;

import com.example.sbbmission.domain.question.question.dto.QuestionDto;
import com.example.sbbmission.domain.question.question.entity.Question;
import com.example.sbbmission.domain.question.question.excpetion.CustomException;
import com.example.sbbmission.domain.question.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionDto.QuestionResponseDto findById (Long id) {
        Question findQuestion = questionRepository.findById(id).
                orElseThrow(() -> new CustomException.DataNotFoundException("question not found"));
        QuestionDto.QuestionResponseDto response = QuestionDto.QuestionResponseDto.fromEntity(findQuestion);

        return response;
    }

    @Transactional
    public QuestionDto.QuestionResponseDto createQuestion(QuestionDto.QuestionRequestDto request) {
        Question question = questionRepository.save(request.toEntity());
        QuestionDto.QuestionResponseDto response = QuestionDto.QuestionResponseDto.fromEntity(question);

        return response;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();

    }

    public void remove(Question lastQuestion) {
        questionRepository.delete(lastQuestion);

    }
}
