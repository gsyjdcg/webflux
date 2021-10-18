package com.reactive.demo.controller;

import com.reactive.demo.entity.Usuario;
import com.reactive.demo.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/{id}")
    private Mono<Usuario> findById(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping
    private Flux<Usuario> findAll() {
        log.info("========================>  findAll ");
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Mono<Usuario> create(@RequestBody Usuario usuario) {
        usuario.setId(null);
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Mono<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return usuarioRepository.findById(id)
                .flatMap(p -> usuarioRepository.save(usuario));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return usuarioRepository.deleteById(id);
    }
}