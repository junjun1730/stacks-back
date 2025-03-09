package com.kaikaku.stacks.controller;

import com.kaikaku.stacks.dto.company.CompanyDto;
import com.kaikaku.stacks.dto.company.TechStackDto;
import com.kaikaku.stacks.dto.company.TechnologyDto;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping
    @ResponseBody
    public ArrayList<CompanyDto> getMain() {
        log.info("execute!");
        return createData();
    }

    //@todo Data Sample
    static ArrayList<CompanyDto> createData() {
        ArrayList<CompanyDto> companyDtos = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ArrayList<TechStackDto> techStackDtos = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                ArrayList<TechnologyDto> technologyDtos = new ArrayList<>();
                for (int k = 0; k < 2; k++) {
                    TechnologyDto technologyDto = new TechnologyDto(k, "technologyDto" + k, "category" + k);
                    technologyDtos.add(technologyDto);
                }
                TechStackDto techStackDto = new TechStackDto(j, "techStackDto" + j, technologyDtos);
                techStackDtos.add(techStackDto);
            }
            CompanyDto companyDto = new CompanyDto(i, "companyDto" + i, "industry", "companyUrl", "careerUrl", techStackDtos);
            companyDtos.add(companyDto);
        }
        return companyDtos;
    }
}
