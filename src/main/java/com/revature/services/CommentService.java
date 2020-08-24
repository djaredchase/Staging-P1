package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.repos.CommentRepo;
import com.revature.repos.PostRepo;

@Service
public class CommentService {

	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	PostRepo postRepo;
	
	public Optional<List<Comment>> getCommentsByPost(Integer postId) {
		Optional<Post> newPost = postRepo.findById(postId);
		return commentRepo.getCommentsByPostOrderByDateDesc(newPost);
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepo.save(comment);
	}
}
