package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Post;
import com.revature.models.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> getAllPostsByOrderByPostedDateDesc();
	
	Optional<List<Post>> getPostsByAuthor(Optional<User> author);
	
	Optional<List<Post>> getPostsBySavedBy(Optional<User> savedBy);
}
