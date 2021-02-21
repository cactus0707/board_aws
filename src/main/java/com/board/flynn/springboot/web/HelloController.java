package com.board.flynn.springboot.web;

import com.board.flynn.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
        //새 오브젝트로 HelloResponseDto에 매개 변수로 name과 amount 를 반환 했음.
        //그런데 HelloResponseDto에는 매개변수를 받는 부분이 없음.
        // 어노테이션을 쓸수 있게해준 Dependency들 덕분인가 ? 임포트 부분의 Lib or frameWork때문인가?
        //그것도 아니라면 view단 엔드포인트에서 주는 값을 name,amount값을 할당문 일 것 같다.(),= 으로 할당문 처럼. - 유
        // 생성자 관계가 아직 풀리지 않은 숙제. 우선은 빠르게 1회독하고 한번 더 볼때 임포트 파트와 어노테이션 부분을 이해 해야겠다.
        //C++에선 rule of 0,3,5로 수동으로 제어했었는데, 지금의 자바스프링부트는 어떨까, 자바는 어떨까 더 서칭 필요.
    }
}
