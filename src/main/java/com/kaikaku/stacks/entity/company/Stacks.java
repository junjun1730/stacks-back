package com.kaikaku.stacks.entity.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stacks {

    @Id
    private Integer id;
    private String name;
    private String imageUrl;
    private Integer categoryId;

    public Stacks() {
    }

    @Override
    public String toString() {
        return "Stacks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
