package me.scpark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@RestController

public class MemberService {


        @Autowired
        private MemberRepository memberRepository;

        public List<Member> getAllMembers() {
            return memberRepository.findAll();

        }

    }
