package com.kaikaku.stacks.entity.company;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    private String nameKana;
    private String nameShort;
    private String nameEn;
    private String location;
    private Integer employeeCount;
    private String image;
    private String url;

    @ManyToOne
    @JoinColumn(name = "industry_id", foreignKey = @ForeignKey(name = "fk_industry"))
    private Industry industry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyStack> companyStacks = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameKana='" + nameKana + '\'' +
                ", nameShort='" + nameShort + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", location='" + location + '\'' +
                ", employeeCount=" + employeeCount +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", industry=" + industry +
                ", companyStacks=" + companyStacks +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
