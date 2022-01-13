/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsoc7.vendaprodutosspring.repositorios;

import dsoc7.vendaprodutosspring.entidades.Produto;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório para objetos do tipo Produto.
 * 
 * @author Prof. Dr. David Buzatto
 */
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
    
}
