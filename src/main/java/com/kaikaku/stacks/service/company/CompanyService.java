package com.kaikaku.stacks.service.company;

import com.kaikaku.stacks.dto.company.AddCompanyRequestDto;
import com.kaikaku.stacks.dto.company.GetCompanyResponseDto;
import com.kaikaku.stacks.entity.company.Company;
import com.kaikaku.stacks.entity.company.CompanyStack;
import com.kaikaku.stacks.entity.company.Industry;
import com.kaikaku.stacks.entity.company.Stack;
import com.kaikaku.stacks.exception.company.StacksNotFoundException;
import com.kaikaku.stacks.mapper.company.CompanyMapper;
import com.kaikaku.stacks.repository.company.CompanyRepository;
import com.kaikaku.stacks.repository.company.IndustryRepository;
import com.kaikaku.stacks.repository.company.StacksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final IndustryRepository industryRepository;
    private final StacksRepository stacksRepository;
    private final CompanyRepository companyRepository;

    public List<Industry> findAllIndustries() {
        return industryRepository.findAll();
    }

    public List<Stack> findAllStacks() {
        List<Stack> allStacks = stacksRepository.findAll();
        if (allStacks.isEmpty()) {
            throw new StacksNotFoundException("Database Loading Error");
        }
        return allStacks;
    }

    public String addCompany(AddCompanyRequestDto dto, MultipartFile logoFile) {
        Company company = new Company();
        company.setName(dto.getCompanyName());
        company.setNameEn(dto.getCompanyNameEn());
        company.setNameKana(dto.getCompanyNameYomi());
        company.setLocation(dto.getLocation());
        company.setUrl(dto.getHomepage());

        Industry industry = industryRepository.findById(dto.getIndustry())
                .orElse(null);
        company.setIndustry(industry);

        String fileName = dto.getCompanyNameEn().toLowerCase() + ".png";

        Path filePath = Paths.get(uploadDir, fileName);
        try {
            logoFile.transferTo(filePath.toFile());
            company.setImage(fileName);
        } catch (IOException e) {
            throw new RuntimeException("ファイルの保存に失敗しました。", e);
        }

        List<CompanyStack> addedStack = dto.getSelectedStacks().stream().map(id -> {
            Stack stack = stacksRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("invalid stack id"));
            CompanyStack cs = new CompanyStack();
            cs.setCompany(company);
            cs.setTechstack(stack);
            return cs;
        }).collect(Collectors.toList());
        System.out.println("company = " + company);
        company.setCompanyStacks(addedStack);
        companyRepository.save(company);
        return "OK";
    }

    public List<GetCompanyResponseDto> getAllCompanies() {
        List<Company> allCompany = companyRepository.findAllWithStacksAndIndustry();
        List<GetCompanyResponseDto> getCompanyResponseDtos = new ArrayList<>();
        for (Company company : allCompany) {
            GetCompanyResponseDto getCompanyResponseDto = CompanyMapper.toDto(company);
            getCompanyResponseDtos.add(getCompanyResponseDto);
        }
        return getCompanyResponseDtos;
    }

}
