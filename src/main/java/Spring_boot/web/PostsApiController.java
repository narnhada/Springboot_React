package Spring_boot.web;

import Spring_boot.service.posts.PostsService;
import Spring_boot.web.dto.PostsResponseDto;
import Spring_boot.web.dto.PostsSaveRequestDto;
import Spring_boot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor                            // final필드가 포함된 생성자를 생성
@RestController                                     // 문자열, json을 반환하는 컨트롤러로 만들어줌
public class PostsApiController {
    private final PostsService postsService;        // service 영역 controller와 dao의 중간영역

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")               // get요청, id이 받으면 id에 따른 값들 반환
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);

        return id;
    }


}
