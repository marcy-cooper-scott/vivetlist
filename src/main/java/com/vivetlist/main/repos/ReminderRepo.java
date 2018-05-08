package com.vivetlist.main.repos;

import com.vivetlist.main.models.Reminder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepo extends CrudRepository<Reminder, Long> {

    @Query(nativeQuery = true, value = "select * from reminders as r where r.user_id = ?")
    List<Reminder> findByUserID(Long id);


}
