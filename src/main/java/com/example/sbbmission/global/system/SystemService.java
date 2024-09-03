package com.example.sbbmission.global.system;

import com.example.sbbmission.domain.question.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemService {

    private final QuestionRepository questionRepository;

    public boolean isSampleDateCreated() {
        return questionRepository.count() > 0 ;
    }

}
