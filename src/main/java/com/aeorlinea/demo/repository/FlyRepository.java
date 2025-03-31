package com.aeorlinea.demo.repository;

import com.aeorlinea.demo.entity.Fly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlyRepository extends JpaRepository<Fly, Integer> {

}
