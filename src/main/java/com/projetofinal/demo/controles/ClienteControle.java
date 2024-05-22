package com.projetofinal.demo.controles;

import com.projetofinal.demo.modelos.Cliente;
import com.projetofinal.demo.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ClienteControle {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @GetMapping("/cadastroCliente")
    public ModelAndView cadastrar(Cliente cliente) {
        ModelAndView mv = new ModelAndView("home/clientes/cadastro");
        mv.addObject("cliente", cliente);
        return mv;
    }


    @PostMapping("/salvarCliente")
    public ModelAndView salvar (Cliente cliente, BindingResult result) {
        if(result.hasErrors())
            return cadastrar(cliente);
        else {
            clienteRepositorio.saveAndFlush(cliente);
        }
        return cadastrar(new Cliente());
    }

    @GetMapping("/listarClientes")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/home/clientes/listar");
        mv.addObject("listarClientes", clienteRepositorio.findAll());
        return mv;
    }

    @GetMapping("/editarCliente/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
        return cadastrar(clienteOptional.get());
    }

    @GetMapping("/removerCliente/{id}")
    public ModelAndView remover(@PathVariable("id") Long id){
        Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
        clienteRepositorio.delete(clienteOptional.get());
        return listar();
    }  
}
