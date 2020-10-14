package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Post;
import com.revature.services.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}
	
	@GetMapping("/author/{userId}")
	public Optional<List<Post>> getPostsByAuthor(@PathVariable Integer userId) {
		return postService.getPostsByAuthor(userId);
	}
	
	@PostMapping
	public Post savePost(@RequestBody Post post) {
		return postService.savePost(post);
	}
}
