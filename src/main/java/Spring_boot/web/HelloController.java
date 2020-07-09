package Spring_boot.web;

import Spring_boot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController                                 // 문자열, json을 반환하는 컨트롤러로 만들어줌
public class HelloController {
    //1
    @GetMapping("/hello")                       // /hello 요청이 오면 hello를 반환
    public String helloHello() {
        return "hello";
    }
    //2
    @GetMapping("/hello/dto")                   // /hello/dto 요청이 오면 HelloResponseDto
    public HelloResponseDto helloDto(@RequestParam("name") /* get요청에 대한  파마리터*/ String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
