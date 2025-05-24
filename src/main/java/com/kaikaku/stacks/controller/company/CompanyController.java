package com.kaikaku.stacks.controller.company;

import com.kaikaku.stacks.dto.company.AddCompanyRequestDto;
import com.kaikaku.stacks.dto.company.GetCompanyResponseDto;
import com.kaikaku.stacks.entity.company.Company;
import com.kaikaku.stacks.entity.company.Stack;
import com.kaikaku.stacks.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/company")
@Slf4j
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyResponseDto> getCompany(@PathVariable Integer id){
        GetCompanyResponseDto company = companyService.getCompany(id);
        return ResponseEntity.ok(company);

    }



    @GetMapping("/add")
    public ResponseEntity<List<Stack>> getAllStacks() {
        List<Stack> allStacks = companyService.findAllStacks();
        return ResponseEntity.ok(allStacks);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestPart("basicInfo") AddCompanyRequestDto addCompanyRequestDto,
                                             @RequestPart("logo") MultipartFile logoFile) {
        String result = companyService.addCompany(addCompanyRequestDto, logoFile);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/list")
    public ResponseEntity<List<GetCompanyResponseDto>> getAllCompanies() {
        List<GetCompanyResponseDto> allCompanies = companyService.getAllCompanies();
        return ResponseEntity.ok(allCompanies);
    }
}
