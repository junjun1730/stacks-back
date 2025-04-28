package com.kaikaku.stacks.controller.company;

import com.kaikaku.stacks.dto.company.CompanyDto;
import com.kaikaku.stacks.dto.company.TechStackDto;
import com.kaikaku.stacks.dto.company.TechnologyDto;
import com.kaikaku.stacks.entity.company.Industries;
import com.kaikaku.stacks.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
@Slf4j
@Validated
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    public List<Industries> getAllIndustries() {
        return companyService.findAllIndustries();
    }
}
