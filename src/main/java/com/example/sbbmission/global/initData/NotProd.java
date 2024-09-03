package com.example.sbbmission.global.initData;


import com.example.sbbmission.domain.answer.answer.dto.AnswerDto;
import com.example.sbbmission.domain.answer.answer.service.AnswerService;
import com.example.sbbmission.domain.question.question.dto.QuestionDto;
import com.example.sbbmission.domain.question.question.servcie.QuestionService;
import com.example.sbbmission.global.system.SystemService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod")
public class NotProd {

    @Bean
    public ApplicationRunner initNotProd(
            QuestionService questionService,
            SystemService systemService,
            AnswerService answerService
    ) {
        System.out.println("initData 실행 ~~~~~~~~~~~~~~~~");
        return args -> {
            if (systemService.isSampleDateCreated()) return;
            for (long i = 1; i < 6; i++) {
                QuestionDto.QuestionRequestDto request = new QuestionDto.QuestionRequestDto();
                request.setSubject("제목"+i);
                request.setContent("내용"+i);
                questionService.createQuestion(request);

                for (long j = 1; j < 3; j++) {
                    AnswerDto.AnswerRequestDto AnswerRequest = new AnswerDto.AnswerRequestDto();
                    AnswerRequest.setContent("댓글"+j);
                    answerService.createAnswer(i, AnswerRequest);
                }

            }


        };
    }



}
