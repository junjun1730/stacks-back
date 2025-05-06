package com.kaikaku.stacks.repository.company;


import com.kaikaku.stacks.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
