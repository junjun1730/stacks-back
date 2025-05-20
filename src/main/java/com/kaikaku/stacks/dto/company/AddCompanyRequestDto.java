package com.kaikaku.stacks.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddCompanyRequestDto {
    private String companyName;
    private String companyNameEn;
    private String companyNameYomi;
    private String location;
    private Integer industry;
    private String homepage;
    private List<Integer> selectedStacks;
}
