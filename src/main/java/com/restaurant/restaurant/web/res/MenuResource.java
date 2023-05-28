package com.restaurant.restaurant.web.res;

import com.restaurant.restaurant.DTO.MenuDTO;
import com.restaurant.restaurant.repository.MenuRepository;
import com.restaurant.restaurant.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuResource {
    private final MenuService menuService;
    private final MenuRepository menuRepository;

    public MenuResource(MenuService menuService, MenuRepository menuRepository) {
        this.menuService = menuService;
        this.menuRepository = menuRepository;
    }
    @PostMapping()
    public ResponseEntity<MenuDTO> create(@RequestBody MenuDTO menuDTO){
        MenuDTO menuDTO1 = menuService.save(menuDTO);
        return ResponseEntity.ok(menuDTO1);
    }

    @PutMapping()
    public ResponseEntity<MenuDTO> update(@RequestBody MenuDTO menuDTO){
        MenuDTO menuDTO1 = menuService.save(menuDTO);
        return ResponseEntity.ok(menuDTO1);
    }

    @GetMapping()
    public ResponseEntity<List<MenuDTO>> getAll(){
        List<MenuDTO> menuList = menuService.findAll();
        return ResponseEntity.ok(menuList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MenuDTO> getMenuDetails(@PathVariable Long id){
        if (!menuRepository.existsById(id)){
            throw new RuntimeException("no information found");
        }
        MenuDTO menuDTO = menuService.getMenuDetail(id);
        return ResponseEntity.ok(menuDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (!menuRepository.existsById(id)){
            throw new RuntimeException("data not found");
        }
        menuService.delete(id);
        return ResponseEntity.ok("data deleted");
    }
}
