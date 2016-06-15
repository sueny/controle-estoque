package projeto.engenharia.software.controle.estoque.as.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import projeto.engenharia.software.controle.estoque.base.entity.Stock;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovement;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovementAdjust;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovementAdjustProduct;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IAcertoConsignacaoAS;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGenericDAO;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGeralDAO;

@Stateless
@Local(IAcertoConsignacaoAS.class)
public class AcertoConsignacaoAS extends GenericsAS implements IAcertoConsignacaoAS {

    @EJB
    private IGeralDAO dao;

    @Override
    public IGenericDAO getDAO() throws Exception {
        return dao;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public StockMovementAdjust save(StockMovementAdjust entity) throws Exception {

        for (StockMovementAdjustProduct smap : entity.getProductList()) {
            /* setar relacionamento de entidade */
            smap.setStockMovementAdjust(entity);

            /**
             * Incrementar quantidade de produto que retornou ao estoque
             */
            if (smap.getQuantityRetorno() > 0) {

                Stock stock = (Stock) super.get(Stock.class, smap.getStock().getId());
                //quantidadeRestante = quantidade em estoque + mais a quantidade retornada;
                int quantidadeTotal = stock.getQuantity() + smap.getQuantityRetorno();
                stock.setQuantity(quantidadeTotal);
                super.save(stock);

            }
        }

        // Após o acerto de consignação a consignação é fechada
        StockMovement consignment = (StockMovement) super.get(StockMovement.class, entity.getConsignment().getId());
        consignment.setOpen(Boolean.FALSE);
        super.save(consignment);

        //cadastrar acerto de consignação
        return (StockMovementAdjust) super.save(entity);
    }

}
