package com.projetofinal.demo.repositorios;

import com.projetofinal.demo.modelos.ItemVenda;
import com.projetofinal.demo.modelos.Venda;
import jakarta.mail.FetchProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemVendaRepositorio extends JpaRepository<ItemVenda, Long> {

    @Query("SELECT e FROM ItemVenda e WHERE e.venda.id = ?1")
    List<ItemVenda>buscarPorVenda(Long id);

}
