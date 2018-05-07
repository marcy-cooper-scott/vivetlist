package com.vivetlist.main.repos;

import com.vivetlist.main.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PostRepo extends CrudRepository<Post, Long>{

    Post findById(long id);
    void delete(Post post);
    List<Post> findAllByGroup_Id(long id);
    List<Post> findAllByTitleContaining(String search);




}
