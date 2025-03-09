package com.kaikaku.stacks.dto.company;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TechnologyDto {
    @NotNull
    private int id;
    private String name;
    private String category;
}
