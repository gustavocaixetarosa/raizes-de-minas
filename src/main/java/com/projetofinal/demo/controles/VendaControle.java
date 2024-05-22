package com.projetofinal.demo.controles;

import com.projetofinal.demo.modelos.ItemVenda;
import com.projetofinal.demo.modelos.Produto;
import com.projetofinal.demo.modelos.Venda;
import com.projetofinal.demo.repositorios.ClienteRepositorio;
import com.projetofinal.demo.repositorios.ItemVendaRepositorio;
import com.projetofinal.demo.repositorios.ProdutoRepositorio;
import com.projetofinal.demo.repositorios.VendaRepositorio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class VendaControle {

    @Autowired
    private ItemVendaRepositorio itemVendaRepositorio;
    @Autowired
    private VendaRepositorio vendaRepositorio;
    @Autowired
    private ProdutoRepositorio produtoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Getter
    @Setter
    private List<ItemVenda> listaItemVenda = new ArrayList<ItemVenda>();



    @GetMapping("/cadastroVenda")
    public ModelAndView cadastrar(Venda venda, ItemVenda itemVenda) {
        ModelAndView mv = new ModelAndView("home/vendas/cadastro");
        mv.addObject("venda", venda);
        mv.addObject("itemEntrada", itemVenda);
        mv.addObject("listaItemVenda", this.listaItemVenda);
        mv.addObject("listaClientes", clienteRepositorio.findAll());
        mv.addObject("listaProdutos", produtoRepositorio.findAll());
        return mv;
    }


    @PostMapping("/salvarVenda")
    public ModelAndView salvar (String acao,Venda venda, ItemVenda itemVenda,BindingResult result) {
        if(result.hasErrors())
            return cadastrar(venda, itemVenda);
        if(acao.equals("salvarItens")) {
            this.listaItemVenda.add(itemVenda);
            venda.setValorTotal(venda.getValorTotal() + itemVenda.getValor() * itemVenda.getQuantidade());
            venda.setQuantidadeTotal(venda.getQuantidadeTotal() + itemVenda.getQuantidade());
        } else if (acao.equals("salvar")) {
            vendaRepositorio.saveAndFlush(venda);

            for (ItemVenda it: listaItemVenda) {
                it.setVenda(venda);
                itemVendaRepositorio.saveAndFlush(it);

                Optional<Produto> prod = produtoRepositorio.findById(it.getProduto().getId());
                Produto produto = prod.get();
                produto.setEstoque((int) (produto.getEstoque() - it.getQuantidade()));
                produtoRepositorio.saveAndFlush(produto);

                this.listaItemVenda = new ArrayList<>();
            }
            return cadastrar(new Venda(), new ItemVenda());
        }
        return cadastrar(venda, new ItemVenda());
    }

    @GetMapping("/listarVendas")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/home/vendas/listar");
        mv.addObject("listarVendas", vendaRepositorio.findAll());
        return mv;
    }

    @GetMapping("/editarVenda/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<Venda> vendaOptional = vendaRepositorio.findById(id);
        this.listaItemVenda = itemVendaRepositorio.buscarPorVenda(vendaOptional.get().getId());
        return cadastrar(vendaOptional.get(), new ItemVenda());
    }

    @GetMapping("/removerItemVenda/{id}")
    public ModelAndView removerItem(@PathVariable("id") Long id, Venda venda) {
        Optional<ItemVenda> itemVenda = itemVendaRepositorio.findById(id);
        itemVendaRepositorio.delete(itemVenda.get());
        return cadastrar(venda, new ItemVenda());

    }

    @GetMapping("/removerVenda/{id}")
    public ModelAndView remover(@PathVariable("id") Long id){
        Optional<Venda> vendaOptional = vendaRepositorio.findById(id);
        vendaRepositorio.delete(vendaOptional.get());
        return listar();
    }
}
