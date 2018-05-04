package com.vivetlist.main.repos;

import com.vivetlist.main.models.Medicine;
import org.springframework.data.repository.CrudRepository;

public interface MedicineRepo extends CrudRepository<Medicine, Long> {
}
