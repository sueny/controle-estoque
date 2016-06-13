package projeto.engenharia.software.controle.estoque.base.entity.as.iface;

import projeto.engenharia.software.controle.estoque.base.entity.StockMovementAdjust;

/**
 *
 * @author Sueny
 */
public interface IAcertoConsignacaoAS extends IGenericAS {
    
    StockMovementAdjust save(StockMovementAdjust entity) throws Exception;
    
}
