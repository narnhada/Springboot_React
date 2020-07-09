package Spring_boot.domain.posts;
/* 쿼리매퍼 DAO와 비슷하다  */

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                                                             // 클래스 내 모든필드에 get메소드 생성
@NoArgsConstructor                                                  // 파라미터가 없는 기본생성자 추가 >> public Posts(){}
@Entity                                                             // JPA 어노테이션
public class Posts {                                                // DB에 매칭될 클래스

    @Id //PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // PK생성 규칙,IDENTITY >> sql의 auto_increment 같음
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)            // null값 허용을 안하지만, 에러 발생은 안함...
    private String content;
    private String author;

    @Builder                                                        // setter의 역할
    public Posts(String title,String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }



}
