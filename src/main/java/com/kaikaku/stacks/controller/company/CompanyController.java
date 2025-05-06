package com.kaikaku.stacks.controller.company;

import com.kaikaku.stacks.dto.company.BasicInfoForm;
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
    @GetMapping("/add")
    public ResponseEntity<List<Stack>> getAllStacks(){
        List<Stack> allStacks = companyService.findAllStacks();
        return ResponseEntity.ok(allStacks);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestPart("basicInfo") BasicInfoForm basicInfo,
                                                  @RequestPart("stacks") List<Integer> stacks,
                                                  @RequestPart("logo") MultipartFile logoFile){
        String result = companyService.addCompany(basicInfo,stacks,logoFile);
        return ResponseEntity.ok(result);
    }
}
