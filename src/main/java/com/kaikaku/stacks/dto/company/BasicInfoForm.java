package com.kaikaku.stacks.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BasicInfoForm {
    private String companyName;
    private String companyNameEn;
    private String companyNameYomi;
    private String location;
    private Integer industry;
    private String homepage;
}
