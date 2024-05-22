package com.projetofinal.demo.controles;

import com.projetofinal.demo.repositorios.ClienteRepositorio;
import com.projetofinal.demo.repositorios.VendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalControle {

    @Autowired
    public VendaRepositorio vendaRepositorio;

    @Autowired
    public ClienteRepositorio clienteRepositorio;

    @GetMapping("/")
    public ModelAndView acessarPrincipal () {
        ModelAndView mv = new ModelAndView("/home/principal");
        mv.addObject("listarVendas", vendaRepositorio.findAll());
        mv.addObject("listarClientes", clienteRepositorio.findAll());
        return mv;
    }
}
