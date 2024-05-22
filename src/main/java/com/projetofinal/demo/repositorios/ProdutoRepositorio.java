package com.projetofinal.demo.repositorios;

import com.projetofinal.demo.modelos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
