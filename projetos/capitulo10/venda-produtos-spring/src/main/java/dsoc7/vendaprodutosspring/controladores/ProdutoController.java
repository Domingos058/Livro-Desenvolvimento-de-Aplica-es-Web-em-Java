/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsoc7.vendaprodutosspring.controladores;

import dsoc7.vendaprodutosspring.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para cadastros de Produtos.
 * 
 * @author Prof. Dr. David Buzatto
 */
@Controller
@RequestMapping( "/produtos" )
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepo;
    
}
