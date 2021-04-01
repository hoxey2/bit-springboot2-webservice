package com.example.web.springboot.web.domain.posts;

import com.example.web.springboot.domain.posts.Posts;
import com.example.web.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // In-memory database 자동실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() { //단일 메소드 끝날때 clean up
        postsRepository.deleteAll();
    }

    @Test
    public void insertNreadArticle() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // Builder design pattern
                .title(title)
                .content(content)
                .author("aaa@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //posts에 넣음

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
/*------------------------------------------------------------------*/
    @Test
    public void registBaseTimeEntity() {
        //given
        LocalDateTime now  = LocalDateTime.of(2021, 3, 25, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts =postsList.get(0);

        System.out.println(">>>>>>>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate().isAfter(now));
        assertThat(posts.getModifiedDate().isAfter(now));
    }


}
