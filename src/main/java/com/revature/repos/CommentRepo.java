package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Comment;
import com.revature.models.Post;;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {

	Optional<List<Comment>> getCommentsByPostOrderByDateDesc(Optional<Post> post);
}
