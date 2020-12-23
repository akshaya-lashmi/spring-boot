package com.example.demo.controller;

import com.example.demo.entity.Posts;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class PostController {
    @Autowired
    private PostService service;
    @PostMapping("/addpost")

    public Posts addPost(@RequestBody Posts post)
    {
        return service.savePost(post);
    }
    @PostMapping("/addposts")
    public List<Posts> addPosts(@RequestBody List<Posts> posts)
    {
        return service.savePosts(posts);

    }
    @RequestMapping("/findpost")
    public List<Posts> findAllPosts()
    {
        return service.getPosts();
    }
}
