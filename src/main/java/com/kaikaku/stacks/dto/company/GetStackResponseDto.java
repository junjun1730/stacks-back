package com.kaikaku.stacks.dto.company;

import lombok.Data;

@Data
public class GetStackResponseDto {
    private Integer id;
    private String name;
    private String imageUrl;
    private Integer categoryId;
}
