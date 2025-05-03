package com.kaikaku.stacks.service.company;

import com.kaikaku.stacks.entity.company.Industries;
import com.kaikaku.stacks.entity.company.Stacks;
import com.kaikaku.stacks.exception.company.StacksNotFoundException;
import com.kaikaku.stacks.repository.company.IndustriesRepository;
import com.kaikaku.stacks.repository.company.StacksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final IndustriesRepository industriesRepository;
    private final StacksRepository stacksRepository;

    public List<Industries> findAllIndustries() {
        return industriesRepository.findAll();
    }

    public List<Stacks> findAllStacks() {
        List<Stacks> allStacks = stacksRepository.findAll();
        if (allStacks.isEmpty()) {
            throw new StacksNotFoundException("Database Loading Error");
        }
        return allStacks;
    }
}
