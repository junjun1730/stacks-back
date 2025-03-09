package com.kaikaku.stacks.dto.company;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class TechStackDto {
    @NotNull
    private int id;
    private String name; // 開発区分
    private ArrayList<TechnologyDto> stacks;
}
