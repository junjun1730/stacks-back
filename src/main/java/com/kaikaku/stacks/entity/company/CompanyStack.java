package com.kaikaku.stacks.entity.company;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "company_stacks")
@Getter @Setter
@IdClass(CompanyStackId.class)
public class CompanyStack {
    @Id
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false, foreignKey = @ForeignKey(name = "fk_company"))
    private Company company;

    @Id
    @ManyToOne
    @JoinColumn(name = "techstack_id", nullable = false, foreignKey = @ForeignKey(name = "fk_techstack"))
    private Stack techstack;

    @Override
    public String toString() {
        return "CompanyStack{" +
                "company=" + company +
                ", techstack=" + techstack +
                '}';
    }
}
