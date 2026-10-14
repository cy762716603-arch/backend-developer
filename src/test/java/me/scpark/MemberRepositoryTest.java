package me.scpark;

import jakarta.activation.MimeTypeParameterList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @DisplayName("MemberRepository를 통해 member 테이블의 모든 레보트(3게) 기지오기")
    @Test

    public void getAllMembers() {
        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(3);


    }

    @Sql("/insert-members.sql")
    public void Member

    public void getMemberByname() {
        Option<Member> optMember = memberRepository.findByname("C");
        Member member = optMember.get();

        assertThat(member.getId()).isEqualTo(3);
    }

    @Sql("insert-members.sql")
    @DisplayName("MemberRepository를 통해 id가 2인 레코트 가지오기")
    @Test
    public void getMemberById() {
        Member member = memberRepository.findById(2L).get();

        assertThat(member.getName()).isEuqlTo("B");
    }

    @DisplayName("MemberRepository를 통해 이름이 '천위'인 레코트 추가하기 ")
    @Test
    public void saveMember() {
        Member member = new Member("천위");
        memberRepository.save(member);
        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("천위");

    }
}