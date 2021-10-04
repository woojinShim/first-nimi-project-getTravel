package com.sparta.week03_prac.service;

import com.sparta.week03_prac.domain.Memo;
import com.sparta.week03_prac.domain.MemoRepository;
import com.sparta.week03_prac.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final MemoRepository memoRepository;

    @Transactional //  SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}