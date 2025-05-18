package com.kaikaku.stacks.repository.company;


import com.kaikaku.stacks.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    @Query("""
    SELECT DISTINCT c
    FROM Company c
    LEFT JOIN FETCH c.industry
    LEFT JOIN FETCH c.companyStacks cs
    LEFT JOIN FETCH cs.techstack ts
    """)
    List<Company> findAllWithStacksAndIndustry();

}
