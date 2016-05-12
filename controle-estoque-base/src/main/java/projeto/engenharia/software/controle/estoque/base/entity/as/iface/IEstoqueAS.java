/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.engenharia.software.controle.estoque.base.entity.as.iface;

import projeto.engenharia.software.controle.estoque.base.entity.EntityExample;

/**
 *
 * @author house
 */
public interface IEstoqueAS {
    
    EntityExample findEntityExampleById(Integer id) throws Exception;
    
}
