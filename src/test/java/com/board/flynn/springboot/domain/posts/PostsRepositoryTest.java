package com.board.flynn.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 유닛테스트가 끝날떄 마다 수향되는 메소드 지정 -> 테스트시에 메모리에 쓰레기값 청소. 플러쉬? 버퍼 비우기 같은 역할로 이해.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder().title(title).content(content).author("Flynn").build());
        //테이블에 인서트/업데이트 시도함. id값이 있다면, 업데이트, 없으면 인서트 쿼리.

        //when
        List<Posts> postsList = postsRepository.findAll();
        //셀렉트 * 프롬 post -> 만약 테이블이 크면 어떤 계획을 세워야하지??? - 2회차떄 구글링..

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
    //실행된 쿼리를 로그로 볼 순 없을까? -> 스프링 부트에선 application.propertise , application.yml 파일로 코드 한줄로 설정 가능.
    //src/main/resource 디렉토리 아래에 application.propertise 생성.
    // 쿼리가 맘에 안들떈 쿼리 만들어서 쓸 수 있는가??
}
