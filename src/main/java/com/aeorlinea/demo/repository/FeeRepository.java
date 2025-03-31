package com.aeorlinea.demo.repository;

import com.aeorlinea.demo.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends JpaRepository<Fee,Integer> {
}
