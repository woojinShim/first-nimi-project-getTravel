package com.sparta.week03_prac.controller;


import com.sparta.week03_prac.domain.MemoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller

public class ViewController {

    private final MemoRepository memoRepository;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/detail")
    public String sendid(@RequestParam Long id, Model model) {
        model.addAttribute("idx", id);
        System.out.println("idx " + id);
        return "detail.html";
    }
    @GetMapping("/")
    public String any(){
        return "index.html";
    }
}


