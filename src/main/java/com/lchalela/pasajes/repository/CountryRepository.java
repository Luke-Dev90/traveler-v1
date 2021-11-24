package com.lchalela.pasajes.repository;

import com.lchalela.pasajes.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    @Query(value = "SELECT * FROM Country C Where C.name LIKE '=?1%'",nativeQuery = true)
    List<Country> getCountryByName(String name);
}