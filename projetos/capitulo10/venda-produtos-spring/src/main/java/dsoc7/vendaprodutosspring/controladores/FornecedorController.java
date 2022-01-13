/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsoc7.vendaprodutosspring.controladores;

import dsoc7.vendaprodutosspring.repositorios.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para cadastros de Fornecedores.
 * 
 * @author Prof. Dr. David Buzatto
 */
@Controller
@RequestMapping( "/fornecedores" )
public class FornecedorController {
    
    @Autowired
    private FornecedorRepository fornecedorRepo;
    
}
