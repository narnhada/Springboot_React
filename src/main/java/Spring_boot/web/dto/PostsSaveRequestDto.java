package Spring_boot.web.dto;

import Spring_boot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter                                                    // getA(){}를 자동 생성
@NoArgsConstructor                                         // 파라미터가 없는 기본생성자 추가 >> public Posts(){}
public class PostsSaveRequestDto {                         // Controller와 Service에서 사용할 Dto클래스
    private String title;
    private String content;
    private String author;

    @Builder                                                //setter 역할
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
