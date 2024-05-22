package com.projetofinal.demo.repositorios;

import com.projetofinal.demo.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
