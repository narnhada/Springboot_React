package Spring_boot.service.posts;

import Spring_boot.domain.posts.Posts;
import Spring_boot.domain.posts.PostsRepository;
import Spring_boot.web.dto.PostsResponseDto;
import Spring_boot.web.dto.PostsSaveRequestDto;
import Spring_boot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor                         // 생성자로 bean객체를 받아 @Autowired와 동일한 효과를 얻음
@Service                                         // 컨트롤러와 dao중간 , @Transactional이 사용되어야 하는 영역
public class PostsService {
    private final PostsRepository postsRepository; // JpaRepository상속받아 crud메소드 생성

    @Transactional                               //  데이터에 대한 무결성을 유지하기 위한 처리 방법,에러가 발생되면 에러지점으로 롤백
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId(); //toEntity()호출 >> jpa적용
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id= "+ id));  // 에러나면
        posts.update(requestDto.getTitle(),requestDto.getContent());            // 타이틀이랑 내용만 바뀌게

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다. id= "+ id));

        return new PostsResponseDto(entity);
    }
}
