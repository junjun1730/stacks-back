package com.kaikaku.stacks.service.company;

import com.kaikaku.stacks.entity.company.Industries;
import com.kaikaku.stacks.repository.company.IndustriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final IndustriesRepository industriesRepository;

    public List<Industries> findAllIndustries(){
        return industriesRepository.findAll();
    }

}
