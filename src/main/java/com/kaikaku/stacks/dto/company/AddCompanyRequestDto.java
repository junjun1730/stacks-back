package com.kaikaku.stacks.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddCompanyRequestDto {
    private BasicInfoForm basicInfo;
    private List<Integer> stacks;
}
