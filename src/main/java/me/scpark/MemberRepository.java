package me.scpark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public interface MemberRepository {

    @Autowired
    private MemberService memberService;
    @GetMapping("/member")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();

    }


}
