package com.example.sbbmission.domain.question.question.controller;

import com.example.sbbmission.domain.question.question.dto.QuestionDto;
import com.example.sbbmission.domain.question.question.servcie.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Long id , Model model)  {
        QuestionDto.QuestionResponseDto response = questionService.findById(id);
        model.addAttribute("question", response);

        return "/question/details";

    }

}
