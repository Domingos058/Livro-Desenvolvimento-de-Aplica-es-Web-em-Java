package dsoc7.vendaprodutosspring.controladores;

import dsoc7.vendaprodutosspring.entidades.Cliente;
import dsoc7.vendaprodutosspring.entidades.Venda;
import dsoc7.vendaprodutosspring.repositorios.ClienteRepository;
import dsoc7.vendaprodutosspring.repositorios.ProdutoRepository;
import dsoc7.vendaprodutosspring.repositorios.VendaRepository;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @Autowired
    private ClienteRepository clienteRepo;
    
    @Autowired
    private ProdutoRepository produtoRepo;
    
    @GetMapping( "/listar" )
    public String listar( Model model ) {
        model.addAttribute( "vendas", vendaRepo.findAll() );
        return "/formularios/vendas/listagem";
    }
    
    @GetMapping( "/cancelar/{id}" )
    public String cancelar( @PathVariable( "id" ) Long id ) {
        
        Venda venda = vendaRepo.findById( id )
                .orElseThrow( () -> 
                        new IllegalArgumentException( "Id inválido:" + id ) );
        
        venda.setCancelada( Boolean.TRUE );
        vendaRepo.save( venda );
        
        return "redirect:/vendas/listar";
        
    }
    
    @GetMapping( "/prepararInsercao" )
    public String prepararInsercao( Venda venda, Model model ) {
        model.addAttribute( "clientes", clienteRepo.findAll() );
        model.addAttribute( "produtos", produtoRepo.findAll() );
        return "/formularios/vendas/inserir";
    }
    
    @PostMapping( "/inserir" )
    public String inserir( @Valid Venda venda,
                           BindingResult result, 
                           Model model ) {
        
        if ( result.hasErrors() ) {
            model.addAttribute( "clientes", clienteRepo.findAll() );
            model.addAttribute( "produtos", produtoRepo.findAll() );
            return "/formularios/vendas/inserir";
        }
        
        venda.setData( LocalDate.now() );
        vendaRepo.save( venda );
        
        return "redirect:/vendas/listar";
        
    }
    
}
