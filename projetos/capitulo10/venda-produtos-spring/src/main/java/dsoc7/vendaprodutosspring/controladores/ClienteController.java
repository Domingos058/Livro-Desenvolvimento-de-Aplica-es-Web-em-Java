/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsoc7.vendaprodutosspring.controladores;

import dsoc7.vendaprodutosspring.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para cadastros de Clientes.
 * 
 * @author Prof. Dr. David Buzatto
 */
@Controller
@RequestMapping( "/clientes" )
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepo;
    
}
