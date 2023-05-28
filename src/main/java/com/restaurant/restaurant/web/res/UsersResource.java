package com.restaurant.restaurant.web.res;

import com.restaurant.restaurant.DTO.UserDTO;
import com.restaurant.restaurant.repository.UsersRepository;
import com.restaurant.restaurant.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersResource {
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    public UsersResource(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    @PostMapping()
    @Secured("ADMIN")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        UserDTO user = usersService.save(userDTO);
        return ResponseEntity.ok(user);
    }

    @PutMapping()
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user) {
        UserDTO user1 = usersService.save(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> usersList = usersService.findAll();
        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable Long id) {
        if (!usersRepository.existsById(id)) {
            throw new RuntimeException("user not found!");
        }
        UserDTO userDTO = usersService.getUserDetail(id);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!usersRepository.existsById(id)) {
            throw new RuntimeException("user not found!");
        }
        usersService.delete(id);
        return ResponseEntity.ok("user deleted!");
    }
}
