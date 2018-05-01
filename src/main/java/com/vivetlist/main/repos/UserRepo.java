package com.vivetlist.main.repos;

import com.vivetlist.main.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

    User findByUsername(String username);

    public User findById(long id);
}

