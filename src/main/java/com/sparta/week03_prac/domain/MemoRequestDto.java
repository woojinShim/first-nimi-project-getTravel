package com.sparta.week03_prac.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

@NoArgsConstructor
public class MemoRequestDto {
    private String title;
    private String username;
    private String contents;
}
