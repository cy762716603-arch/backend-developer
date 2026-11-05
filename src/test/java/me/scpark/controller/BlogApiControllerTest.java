import me.scpark.dto.AddArticleRequest;
import me.scpark.repository.BlogRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    @DisplayName("블로그 글 추가에 성공한다.")
    public void addArticle() throws Exception { // ✅ throws Exception
        String title = "11월4일 마지막 수업시간";
        String content = "JUnit으로 블로그 글 생성요청 지리가 성공하는지 실습한다.";
        AddArticleRequest req = new AddArticleRequest(title, content);
        String reqBody = objectMapper.writeValueAsString(req);
        String url = "/api/articles";

        var result = mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(reqBody))
                .andDo(print())
                .andExpect(status().isCreated());

        List<Article> articles = blogRepository.findAll();
        assertThat(articles.size(), equalTo(1));
        assertThat(articles.get(0).getTitle(), equalTo(title));
        assertThat(articles.get(0).getContent(), equalTo(content));
    }
}