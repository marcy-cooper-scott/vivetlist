package com.vivetlist.main.repos;

import com.vivetlist.main.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PostRepo extends CrudRepository<Post, Long>{

    public Post findById(long id);
    public void delete(Post post);
    public Post findAllByGroup_Id(long id);

}
