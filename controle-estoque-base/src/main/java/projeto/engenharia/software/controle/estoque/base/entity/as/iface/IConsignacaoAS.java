package projeto.engenharia.software.controle.estoque.base.entity.as.iface;

import projeto.engenharia.software.controle.estoque.base.entity.StockMovement;

/**
 *
 * @author Sueny
 */
public interface IConsignacaoAS extends IGenericAS {
    
    StockMovement save(StockMovement stockMovement) throws Exception;
    
}
