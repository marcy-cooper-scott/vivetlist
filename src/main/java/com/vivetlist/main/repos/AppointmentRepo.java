package com.vivetlist.main.repos;

import com.vivetlist.main.models.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends CrudRepository<Appointment, Long> {

    @Query(nativeQuery = true, value = "SELECT * from appointments as a WHERE a.user_id = ?")
    List<Appointment> findByUserID(Long id);
}
