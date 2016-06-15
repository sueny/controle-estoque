package projeto.engenharia.software.controle.estoque.as.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.validation.ValidationException;
import projeto.engenharia.software.controle.estoque.base.entity.Stock;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovement;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovementProduct;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IVendaAS;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGenericDAO;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGeralDAO;

@Stateless
@Local(IVendaAS.class)
public class VendaAS extends GenericsAS implements IVendaAS {

    @EJB
    private IGeralDAO dao;

    @Override
    public IGenericDAO getDAO() throws Exception {
        return dao;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public StockMovement save(StockMovement stockMovement) throws Exception {

        for (StockMovementProduct smp : stockMovement.getProductList()) {
            /**
             * Vincular objeto a lista many to many
             */
            smp.setStockMovement(stockMovement);

            /**
             * Decrementar quantidade de produto no estoque
             */
            Stock stock = (Stock) super.get(Stock.class, smp.getStock().getId());
            //quantidadeRestante = quantidade em estoque - menos quantidade vendida;
            int quantidadeRestante = stock.getQuantity() - smp.getQuantity();

            /*
              quantidade vendida é válida, quando é encontrada quantidade maior
              ou igual a requerida em estoque 
              não pode haver quantidade negativa
             */
            if (quantidadeRestante >= 0) {
                stock.setQuantity(quantidadeRestante);
                super.save(stock);
            } else {
                String msg = "Quantidade requerida maior que a quantidade em estoque!";
                throw new Exception(msg, new ValidationException(msg));
            }

        }

        /**
         * Cadatrar StockMovement (Venda).
         */
        return (StockMovement) super.save(stockMovement);

    }

}
