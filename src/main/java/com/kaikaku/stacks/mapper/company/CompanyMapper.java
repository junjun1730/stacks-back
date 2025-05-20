package com.kaikaku.stacks.mapper.company;

import com.kaikaku.stacks.dto.company.GetCompanyResponseDto;
import com.kaikaku.stacks.dto.company.GetIndustryResponseDto;
import com.kaikaku.stacks.dto.company.GetStackResponseDto;
import com.kaikaku.stacks.entity.company.Company;
import com.kaikaku.stacks.entity.company.CompanyStack;

import java.util.ArrayList;
import java.util.List;

public class CompanyMapper {
    public static GetCompanyResponseDto toDto(Company companyEntity) {
        GetCompanyResponseDto getCompanyResponseDto = new GetCompanyResponseDto();
        getCompanyResponseDto.setId(companyEntity.getId());
        getCompanyResponseDto.setName(companyEntity.getName());
        getCompanyResponseDto.setIndustry(new GetIndustryResponseDto(companyEntity.getIndustry().getId(), companyEntity.getIndustry().getName()));
        getCompanyResponseDto.setLocation(companyEntity.getLocation());
        getCompanyResponseDto.setNameEn(companyEntity.getNameEn());
        getCompanyResponseDto.setNameKana(companyEntity.getNameKana());
        getCompanyResponseDto.setImage(companyEntity.getImage());
        List<GetStackResponseDto> getStackResponseDtos = new ArrayList<>();
        for (CompanyStack companyStack : companyEntity.getCompanyStacks()) {
            GetStackResponseDto getStackResponseDto = new GetStackResponseDto();
            getStackResponseDto.setId(companyStack.getTechstack().getId());
            getStackResponseDto.setImageUrl(companyStack.getTechstack().getImageUrl());
            getStackResponseDto.setCategoryId(companyStack.getTechstack().getCategoryId());
            getStackResponseDto.setName(companyStack.getTechstack().getName());
            getStackResponseDtos.add(getStackResponseDto);
        }
        getCompanyResponseDto.setTechStacks(getStackResponseDtos);
        return getCompanyResponseDto;

    }
}
