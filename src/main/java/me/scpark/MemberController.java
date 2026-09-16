package me.scpark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/member")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();

    }


}
