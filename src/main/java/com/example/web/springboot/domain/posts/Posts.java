package com.example.web.springboot.domain.posts;

//import com.example.web.springboot.domain.BaseTimeEntity;
import com.example.web.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor // 기본 생성자 메소드(파라먼트x)
@Entity
public class Posts extends BaseTimeEntity {

    @Id // 글번호(primary-key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성규칙 auto increment
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼 (500글자, not null)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)  // varchar(255)기본에서 text로 하면 255이상 글자 가능
    private String content;

    private String author;

    @Builder
    public Posts(String title, String  content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

//    public void update(String title, String content) {
//        this.title = title;
//        this.content =content;
//    }
}
