package com.projetofinal.demo.controles;

import com.projetofinal.demo.modelos.Cliente;
import com.projetofinal.demo.modelos.Produto;
import com.projetofinal.demo.repositorios.ClienteRepositorio;
import com.projetofinal.demo.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProdutoControle {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastrar(Produto produto) {
        ModelAndView mv = new ModelAndView("home/produtos/cadastro");
        mv.addObject("produto", produto);
        return mv;
    }


    @PostMapping("/salvarProduto")
    public ModelAndView salvar (Produto produto, BindingResult result) {
        if(result.hasErrors())
            return cadastrar(produto);
        else {
            produtoRepositorio.saveAndFlush(produto);
        }
        return cadastrar(new Produto());
    }

    @GetMapping("/listarProdutos")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/home/produtos/listar");
        mv.addObject("listarProdutos", produtoRepositorio.findAll());
        return mv;
    }

    @GetMapping("/editarProduto/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<Produto> produtoOptional = produtoRepositorio.findById(id);
        return cadastrar(produtoOptional.get());
    }

    @GetMapping("/removerProduto/{id}")
    public ModelAndView remover(@PathVariable("id") Long id){
        Optional<Produto> produtoOptional = produtoRepositorio.findById(id);
        produtoRepositorio.delete(produtoOptional.get());
        return listar();
    }  
}
