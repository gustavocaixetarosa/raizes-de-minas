package com.projetofinal.demo.repositorios;

import com.projetofinal.demo.modelos.Cliente;
import com.projetofinal.demo.modelos.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {

}
