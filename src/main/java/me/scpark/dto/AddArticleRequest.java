package me.scpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.scpark.domain.Article;
import org.apache.catalina.Session;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest implements Session {
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(title, content);
       // return Article.builder().title(title).content(content).build();
    }
}
