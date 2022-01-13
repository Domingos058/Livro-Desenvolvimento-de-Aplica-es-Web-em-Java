/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsoc7.vendaprodutosspring.repositorios;

import dsoc7.vendaprodutosspring.entidades.UnidadeMedida;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório para objetos do tipo UnidadeMedida.
 * 
 * @author Prof. Dr. David Buzatto
 */
public interface UnidadeMedidaRepository extends CrudRepository<UnidadeMedida, Long>{
    
}
