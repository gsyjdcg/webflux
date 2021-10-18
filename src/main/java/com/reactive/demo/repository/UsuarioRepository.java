package com.reactive.demo.repository;

import com.reactive.demo.entity.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {


//    @Query("SELECT * FROM vehicle WHERE make = :make")
//    Flux<Vehicle> findByMake(String make);
//
//    @Query("SELECT * FROM vehicle WHERE model = :model")
//    Flux<Vehicle> findByModel(String model);
}