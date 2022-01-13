/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsoc7.vendaprodutosspring.repositorios;

import dsoc7.vendaprodutosspring.entidades.Venda;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório para objetos do tipo Venda.
 * 
 * @author Prof. Dr. David Buzatto
 */
public interface VendaRepository extends CrudRepository<Venda, Long>{
    
}
