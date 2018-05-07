package com.vivetlist.main.repos;

import com.vivetlist.main.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long>{

    List<Comment> findAllByPostId(long id);
}
