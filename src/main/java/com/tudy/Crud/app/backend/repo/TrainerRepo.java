package com.tudy.Crud.app.backend.repo;

import com.tudy.Crud.app.backend.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer,Long> {
}
