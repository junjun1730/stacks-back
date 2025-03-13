package com.kaikaku.stacks.service.company;

import com.kaikaku.stacks.dto.company.CompanyDto;
import com.kaikaku.stacks.dto.company.TechStackDto;
import com.kaikaku.stacks.dto.company.TechnologyDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompanyService {

    //@todo Data Sample
    public ArrayList<CompanyDto> getCompany() {
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
