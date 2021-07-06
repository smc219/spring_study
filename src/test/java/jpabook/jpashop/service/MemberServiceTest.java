package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    // 회원가입
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    EntityManager em;

    public void 회원가입() {
        Member member = new Member();
        member.setName("Kim");

        Long mid = memberService.join(member);

        assertEquals(member, memberService.findOne(mid));
    }
    // 전체 회원 목록
}