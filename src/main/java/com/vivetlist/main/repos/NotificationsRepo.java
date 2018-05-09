package com.vivetlist.main.repos;

import com.vivetlist.main.models.Notification_Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationsRepo extends CrudRepository<Notification_Type, Long> {

}
