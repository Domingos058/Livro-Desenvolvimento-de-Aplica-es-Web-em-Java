package dsoc7.vendaprodutosspring.controladores;

import dsoc7.vendaprodutosspring.repositorios.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para cadastros de Vendas.
 * 
 * @author Prof. Dr. David Buzatto
 */
@Controller
@RequestMapping( "/vendas" )
public class VendaController {
    
    @Autowired
    private VendaRepository vendaRepo;
    
}
