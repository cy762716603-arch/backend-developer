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


    public void getMemberByname() {
        Option<Member> optMember = memberRepository.findByname("C");
        Member member = optMember.get();

        assertThat(member.getId()).isEqualTo(3);
    }

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



    @DisplayName("테이블 member 에서 id가 3인 레코트 삭제하기")
    @Test
    @Sql("/insert-members.sql")
    public void deleById3(){

        memberRepository.deleteById(3L);

        List<member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(2);
        assertThat(members.size()).isZero();

    }
    @DisplayName("테이블 member name이'A','B'인 레코트를 한 번에 십입하기")
    @Test
    public void saveMembers(){

        List<Member> members = List.of(new Member("A"),new Member("B"));
        memberRepository.saveAll(members);
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }
}

   @Sql("/insert-members.sql")
   @DisplayName("변견감지 가능을 통해 Id가 2인 레코트의 이름을 'B', 'BB'로 변경하기.")
   @Test
   public void update(){
       Member member = memberRepository.findById(2L).get();

       member.name = "BB";
       member.setName("BB");

       member = memberRepository.findById(2L).get();
       assertThat(member.getName()).isEqualTo("88");

   }
