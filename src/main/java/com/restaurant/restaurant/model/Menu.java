package com.restaurant.restaurant.model;

import com.restaurant.restaurant.DTO.MenuDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu")
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    public MenuDTO menuTO(){
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(getId());
        menuDTO.setName(getName());
        menuDTO.setPrice(getPrice());
        return menuDTO;

    }

}
