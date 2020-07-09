package Spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication                                      // 스프링부트 자동설정, bean읽기,생성 자동설정
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);     // 내장was(톰캣)실행
    }
}
