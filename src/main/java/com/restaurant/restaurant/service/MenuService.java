package com.restaurant.restaurant.service;


import com.restaurant.restaurant.DTO.MenuDTO;
import com.restaurant.restaurant.model.Menu;
import com.restaurant.restaurant.repository.MenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public MenuDTO save(MenuDTO menuDTO){
        Menu menu = menuDTO.getId() != null ? menuRepository.getReferenceById(menuDTO.getId()): null;
        if (menu == null){
            menu = new Menu();
        }
        menu.setName(menuDTO.getName());
        menu.setPrice(menuDTO.getPrice());
        menuRepository.save(menu);
        return menu.menuTO();
    }
    public List<MenuDTO> findAll(){
        List<MenuDTO> result = new ArrayList<>();
        List<Menu> menu = menuRepository.findAll();
        if (!CollectionUtils.isEmpty(menu)){
            for (Menu menu1:menu){
                result.add(menu1.menuTO());
            }
        }
        return result;
    }
    public void delete(Long id){
        menuRepository.deleteById(id);
    }
    public MenuDTO getMenuDetail(Long id){
        Menu menu = menuRepository.getReferenceById(id);
        return menu.menuTO();
    }
}
