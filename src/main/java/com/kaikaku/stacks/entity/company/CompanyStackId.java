package com.kaikaku.stacks.entity.company;

import jakarta.persistence.*;
import lombok.*;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyStackId {
    private Integer company;
    private Integer techstack;
}
