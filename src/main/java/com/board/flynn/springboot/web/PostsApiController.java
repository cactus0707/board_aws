package com.board.flynn.springboot.web;

import com.board.flynn.springboot.domain.posts.PostsRepository;
import com.board.flynn.springboot.service.posts.PostsService;
import com.board.flynn.springboot.web.dto.PostsResponseDto;
import com.board.flynn.springboot.web.dto.PostsSaveRequestDto;

import com.board.flynn.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/vi/posts/{id}")
    public  Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/vi/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
