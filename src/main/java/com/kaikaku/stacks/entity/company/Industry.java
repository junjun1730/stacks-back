package com.kaikaku.stacks.entity.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "industries")
public class Industry {

    @Id
    private Integer id;
    private String name;

    public Industry() {
    }

    @Override
    public String toString() {
        return "Industry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
