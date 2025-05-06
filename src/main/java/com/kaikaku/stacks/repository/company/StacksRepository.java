package com.kaikaku.stacks.repository.company;


import com.kaikaku.stacks.entity.company.Stack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StacksRepository extends JpaRepository<Stack,Integer> {

}
