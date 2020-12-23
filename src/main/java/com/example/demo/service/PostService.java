package com.example.demo.service;
import com.example.demo.entity.Posts;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;
    public Posts savePost(Posts post)
    {
        return repository.save(post);
    }
    public List<Posts> savePosts(List<Posts> posts)
    {
        return repository.saveAll(posts);
    }
    public List<Posts> getPosts()
    {
        return repository.findAll();
    }
    public Posts getPostById(int id)
    {
        return repository.findById(id).orElse(null);
    }
    public Posts getPostByName(String name)
    {
        return repository.findByName(name);
    }
    public String deletePost(int id){
        repository.deleteById(id);
        return "post removed";
    }
    public Posts updatePost(Posts post){
        Posts existingPost=repository.findById(post.getId()).orElse(null);
        existingPost.setName(post.getName());
        return repository.save(existingPost);

    }
}
