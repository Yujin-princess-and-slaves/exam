package org.study.Spring.basic.study;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostDto create(PostDto postDto){
        Post post = new Post(postDto.getTitle(), postDto.getContent());

        Post save = postRepository.save(post);

        return new PostDto(save);
    }

    public PostDto readOne(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found post"));

        return new PostDto(post);
    }

    public List<PostDto> readAll(){
        return postRepository.findAll()
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    public PostDto update(PostDto postDto){
        Post post = postRepository.findById(postDto.getId())
                .orElseThrow(()->new IllegalArgumentException("Not found post"));

        post.update(postDto.getTitle(), postDto.getContent());

        return new PostDto(post);
    }

    public void delete(Long id){ postRepository.deleteById(id); }
}
