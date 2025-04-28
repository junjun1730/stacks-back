package com.kaikaku.stacks.entity.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Industries {

    @Id
    private Integer id;
    private String name;

    public Industries() {
    }

    @Override
    public String toString() {
        return "Industries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
