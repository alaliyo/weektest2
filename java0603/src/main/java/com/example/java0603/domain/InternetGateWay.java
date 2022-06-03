package com.example.java0603.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class InternetGateWay {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final InternetGateWay internetGateWay;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, InternetGateWay gateWay) {
        Subnet subnet1 = internetGateWay.finalize(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return id;
    }
}
