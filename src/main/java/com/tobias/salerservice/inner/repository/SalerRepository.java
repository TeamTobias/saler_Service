package com.tobias.salerservice.inner.repository;

import com.tobias.salerservice.inner.domain.Saler;
import org.springframework.data.repository.CrudRepository;

public interface SalerRepository extends CrudRepository<Saler, Long> {
    Saler findById(int id);
    void deleteById(int id);
}
