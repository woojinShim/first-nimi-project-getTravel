package com.sparta.week03_prac.controller;

import com.sparta.week03_prac.domain.Memo;
import com.sparta.week03_prac.domain.MemoRepository;
import com.sparta.week03_prac.domain.MemoRequestDto;
import com.sparta.week03_prac.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class  MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(yesterday, now);
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    @GetMapping("/api/memos/{id}")
    public Memo sendingid(@PathVariable Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시물을 찾을 수 없습니다.")
        );
        return memo;
    }

    @DeleteMapping("/api/memos{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

}

