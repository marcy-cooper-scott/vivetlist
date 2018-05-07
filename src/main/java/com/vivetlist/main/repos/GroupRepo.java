package com.vivetlist.main.repos;

import com.vivetlist.main.models.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepo extends CrudRepository<Group, Long>{

    Group findById(long id);
    List<Group> findAllByNameContaining(String search);


}
