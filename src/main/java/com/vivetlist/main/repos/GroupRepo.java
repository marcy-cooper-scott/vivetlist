package com.vivetlist.main.repos;

import com.vivetlist.main.models.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepo extends CrudRepository<Group, Long>{

    public Group findAllById(long id);
    public Group findById(long id);

}
