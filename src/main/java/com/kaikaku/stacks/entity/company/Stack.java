package com.kaikaku.stacks.entity.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "stacks")
public class Stack {

    @Id
    private Integer id;
    private String name;
    private String imageUrl;
    private Integer categoryId;

    public Stack() {
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
