package com.kaikaku.stacks.dto.company;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
public class GetCompanyResponseDto {
    private Integer id;
    private String name;
    private String nameEn;
    private String nameKana;
    private List<GetStackResponseDto> techStacks;
    private GetIndustryResponseDto industry;
    private String location;
    private String image;

}
