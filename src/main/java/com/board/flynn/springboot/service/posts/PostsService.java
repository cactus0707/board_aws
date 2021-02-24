package com.board.flynn.springboot.service.posts;

import com.board.flynn.springboot.domain.posts.Posts;
import com.board.flynn.springboot.domain.posts.PostsRepository;
import com.board.flynn.springboot.web.dto.PostsResponseDto;
import com.board.flynn.springboot.web.dto.PostsSaveRequestDto;
import com.board.flynn.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service

public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다.id=" + id));
        //예외 처리 방식?? 스프링에서 예외처리 어떻게 흘러가는지 찾아봐야함.. 자바두 마찬가지, 스택 언와인딩 규칙(?) 검색 필요..(2회차 때)
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다 id" + id));
        return new PostsResponseDto(entity);
    }
}
//업데이트 기능에선 쿼리 날리는 부분이 없음. JPA 영속성 컨텍스트 떄문이며, 논리적인 개념. 컴파일타임에 체크하는건지..? 런타임에 항상 붙어 있다는건지
// 세부 동작 필요함 (2회차) -> 더티첵 업데이트 방식. 파일 백업방식에서 아이디어를 얻어온거같다..(내가 그렇게 이해하는걸수도..?)