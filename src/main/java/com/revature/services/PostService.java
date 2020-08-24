package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repos.PostRepo;
import com.revature.repos.UserRepo;

@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public List<Post> getAllPosts() {
		return postRepo.getAllPostsByOrderByPostedDateDesc();
	}
	
	public Optional<List<Post>> getPostsByAuthor(Integer userId) {
		Optional<User> newUser = userRepo.findById(userId);
		return postRepo.getPostsByAuthor(newUser);
	}
	
	public Optional<List<Post>> getPostsBySaver(Integer savedBy) {
		Optional<User> newUser = userRepo.findById(savedBy);
		return postRepo.getPostsBySavedBy(newUser);
	}
	
	public Post savePost(Post post) {
		return postRepo.save(post);
	}
}
