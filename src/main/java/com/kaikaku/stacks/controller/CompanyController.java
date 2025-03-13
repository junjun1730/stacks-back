package com.kaikaku.stacks.controller;

import com.kaikaku.stacks.dto.company.CompanyDto;
import com.kaikaku.stacks.dto.company.TechStackDto;
import com.kaikaku.stacks.dto.company.TechnologyDto;
import com.kaikaku.stacks.service.company.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/company")
@Slf4j
@Validated
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    @ResponseBody
    public ArrayList<CompanyDto> getMain() {
        ArrayList<CompanyDto> company = companyService.getCompany();
        return company;
    }

}
