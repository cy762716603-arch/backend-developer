package me.scpark.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.scpark.domain.Article;
import me.scpark.dto.AddArticleRequest;
import me.scpark.repository.BlogRepository;
import me.scpark.service.BlogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BlogApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BlogRepository blogRepository;

    @DisplayName("불로그 글 추가에 성공합다.")
    @Test
    public void addArticle(){
        String title = "11월4일 마지막 수업시간";
        String content = "Junit으로 불로그 글 생성요청 지리가 성공하는지 실습니다";
        AddArticleRequest req = new AddArticleRequest(title, content);
        String reqBody = objectMapper.writeValueAsString(req);
        String url = "/api/articles";

        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(reqBody));

            result.andExpect(status().isCreated());
            List<Article> articles = blogRepository.findAll();
            assertThat(articles.size()).isEqu


    }

}