package org.study.Spring.basic.study;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;

    public PostDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
