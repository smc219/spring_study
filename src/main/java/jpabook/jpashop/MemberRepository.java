package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;// 스프링부트가 결국 다 관리해주기 때문에 너무 걱정하지 않아도 된다.

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // 왜 이렇게 하는걸까? 커맨드랑 쿼리를 분리하기 위해
    }
    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
