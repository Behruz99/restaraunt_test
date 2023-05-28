package com.restaurant.restaurant.service;

import com.restaurant.restaurant.DTO.UserDTO;
import com.restaurant.restaurant.model.Users;
import com.restaurant.restaurant.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public UserDTO save(UserDTO userDTO){
        Users users = userDTO.getId() != null ? usersRepository.getReferenceById(userDTO.getId()) :null;
        if (users == null){
            users = new Users();
        }
        users.setName(userDTO.getName());
        users.setPosition(userDTO.getPosition());
        usersRepository.save(users);
        return users.userTO();
    }
    public List<UserDTO> findAll(){
        List<UserDTO> result = new ArrayList<>();
        List<Users> users = usersRepository.findAll();
        if (!CollectionUtils.isEmpty(users)){
            for (Users user:users){
                result.add(user.userTO());
            }
        }
        return result;
    }
    public void delete(Long id){
        usersRepository.deleteById(id);
    }
    public UserDTO getUserDetail(Long id){
        Users users = usersRepository.getReferenceById(id);
        return users.userTO();
    }
}
