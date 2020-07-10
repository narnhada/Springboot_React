package Spring_boot.web;

import Spring_boot.service.posts.PostsService;
import Spring_boot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller                             //URL 매핑
public class IndexController {

    /*
    @GetMapping("/")
    public String index_(){             // 여기는 중요 X
                                        // src/main/resources/templates/index2.mustache
        return "index2";                // 머스테치 스타터 덕분에 문자열(index2)반환 할때 경로와 확장자명 자동지정
    }
    */
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index2";
    }


    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
