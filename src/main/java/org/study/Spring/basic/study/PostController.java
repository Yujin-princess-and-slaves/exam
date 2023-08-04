package org.study.Spring.basic.study;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    public final PostService postService;

    @PostMapping("/create/post")
    public PostDto create(@RequestBody PostDto postDto){
        return postService.create(postDto);
    }

    @GetMapping("/read/{id}")
    public PostDto readOne(@PathVariable Long id){
        return postService.readOne(id);
    }

    @GetMapping("/read/all")
    public List<PostDto> readAll(){
        return postService.readAll();
    }

    @PutMapping("/update")
    public PostDto update(@RequestBody PostDto postDto){
        return postService.update(postDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }
}
