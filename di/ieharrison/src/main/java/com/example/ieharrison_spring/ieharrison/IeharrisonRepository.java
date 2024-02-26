package com.example.ieharrison_spring.ieharrison;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IeharrisonRepository extends JpaRepository<Ieharrison, Integer> {
    // <...Integer> es porque el @id de Persona es un Integer

}
