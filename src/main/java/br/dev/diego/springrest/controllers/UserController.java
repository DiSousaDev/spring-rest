package br.dev.diego.springrest.controllers;


import br.dev.diego.springrest.entities.dto.UserDto;
import br.dev.diego.springrest.entities.dto.UserInsertDto;
import br.dev.diego.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(userService.findAll(pageable));
    }

    @GetMapping(value = "find-by-name")
    public ResponseEntity<Page<UserDto>> findByName(@RequestParam String name, Pageable pageable) {
        return ResponseEntity.ok().body(userService.findByName(name, pageable));
    }

    @PostMapping
    public ResponseEntity<UserDto> insert(@RequestBody UserInsertDto userInsertDto) {
        UserDto user = userService.save(userInsertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
