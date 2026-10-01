package me.scpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class MemberControllerTest {


    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void cleanup(){
        memberRepository.deleteAll();
    }
    @DisplayName("")
    @Test
    void getAllMembers()  throws Exception{

        Member m = new Member("SCPARK");

        Member saveMember = memberRepository.save(m);

        mockMvc.perform(get("member").accapt(MeaidType.APPLICATION_JSON));

       final ResultActions result = mockMvc.perform(get("/Member")).accept(MediaType.APPLICATION_JSON);

       result.andExpect(status().isOK()).andExpect(jsonPath("$[0].id").value(1L))
               .andExpect(jsonPath("$[0].name").value(saveMember.getName())
    }
}