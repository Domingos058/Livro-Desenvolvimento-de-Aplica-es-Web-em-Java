/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsoc7.vendaprodutosspring.controladores;

import dsoc7.vendaprodutosspring.repositorios.UnidadeMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para cadastros de Unidades de Medida.
 * 
 * @author Prof. Dr. David Buzatto
 */
@Controller
@RequestMapping( "/unidadesMedida" )
public class UnidadeMedidaController {
    
    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepo;
    
}
