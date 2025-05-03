package com.kaikaku.stacks.controller.company;

import com.kaikaku.stacks.dto.company.CompanyDto;
import com.kaikaku.stacks.dto.company.TechStackDto;
import com.kaikaku.stacks.dto.company.TechnologyDto;
import com.kaikaku.stacks.entity.company.Industries;
import com.kaikaku.stacks.entity.company.Stacks;
import com.kaikaku.stacks.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    @RequestMapping("/add")
    public ResponseEntity<List<Stacks>> getAllStacks(){
        List<Stacks> allStacks = companyService.findAllStacks();
        return ResponseEntity.ok(allStacks);
    }
}
