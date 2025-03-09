package com.kaikaku.stacks.dto.company;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class CompanyDto {
    @NotNull
    private int id;
    @NotNull
    private String name; // 企業名
    private String industry; //　業界
    private String companyUrl; // 企業ページ
    private String careerUrl; //　採用ページ
    private ArrayList<TechStackDto> techStacks;
}
