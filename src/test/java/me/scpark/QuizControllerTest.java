package me.scpark;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.ContentRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.awt.*;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @DisplayName("quiz(): GET /quiz?code=1 응답 코트는 201,응답 본문은 Created ")
    @Test
    void quiz() throws Exception {

        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(get(url).param("code","1"));

        result.andExpect(status().isCreated()).andExpect((ResultMatcher) content().string("Created"));
    }



    @DisplayName("POST: /quiz 요정, 요청 바디에{'value':1}이민 응답 코트는 403,응답은 Forbiden")

    @Test
    void postQuiz1() throws Exception {
         final String url ="/quiz";

         final ResultActions result = mockMvc.perform(post(URI.create(url))
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(objectMapper.writeValueAsString(new Code(1))));

         result.andExpect(status().isForbidden()).andExpect((ResultMatcher) content().string("Forbidden"));
    }



    @Test
    @DisplayName("quiz(): GET /quiz?code=1 응답 코트는 201,응답 본문은 OK ")
    void postQuiz2() throws Exception {
        final String url ="/quiz";

        final ResultActions result = mockMvc.perform(post(URI.create(url))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Code(1))));

        result.andExpect(status().isForbidden()).andExpect((ResultMatcher) content().string("Forbidden"));
    }



}