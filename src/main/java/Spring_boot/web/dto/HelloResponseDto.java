package Spring_boot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter                                 // getA(){}를 자동 생성
@RequiredArgsConstructor                // final필드가 포함된 생성자를 생성
public class HelloResponseDto {         // DataTransferObject >>  /hello/dto?name='a'&amount=1 들어온 값을 객체에 전달
    private final String name;          // final이 없이 실행시키면 DTO에서 생성자가 없다고 나옴
    private final int amount;

}

/*
@RestController >> json으로 반환됨이 확인됨
// 20200709154655
// http://localhost:8080/hello/dto?name=a&amount=1

{
  "name": "a",
  "amount": 1
}
*/