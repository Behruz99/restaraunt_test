package com.restaurant.restaurant.model;

import com.restaurant.restaurant.DTO.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    public UserDTO userTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(getId());
        userDTO.setName(getName());
        userDTO.setPosition(getPosition());
        return userDTO;

    }
}
