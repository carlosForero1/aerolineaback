package com.aeorlinea.demo.repository;

import com.aeorlinea.demo.entity.Fly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlyRepository extends JpaRepository<Fly, Integer> {
}
