package projeto.engenharia.software.controle.estoque.base.entity.as.iface;

import projeto.engenharia.software.controle.estoque.base.entity.StockMovement;

/**
 *
 * @author Sueny
 */
public interface IVendaAS extends IGenericAS {
    
    StockMovement save(StockMovement stockMovement) throws Exception;
    
}
