package com.vivetlist.main.repos;

import com.vivetlist.main.models.Medicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicineRepo extends CrudRepository<Medicine, Long> {

    List<Medicine> findAllByUserId (long id);
}
