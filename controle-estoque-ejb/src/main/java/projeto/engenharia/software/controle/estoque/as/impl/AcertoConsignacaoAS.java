package projeto.engenharia.software.controle.estoque.as.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovement;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovementAdjust;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovementAdjustProduct;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovementProduct;
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
    public StockMovementAdjust save(StockMovementAdjust entity) throws Exception {
        boolean consignmentOpen = false;
        StockMovement consignment = (StockMovement) super.get(StockMovement.class, entity.getConsignment().getId());

        for (StockMovementAdjustProduct smap : entity.getProductList()) {
            /* setar relacionamento de entidade */
            smap.setStockMovementAdjust(entity);

            /* atualizar quantidade do produto na lista de consignação de acordo com o acerto de consignação realizado */
            for (StockMovementProduct smp : consignment.getProductList()) {
                if (smap.getProduct().getId().equals(smp.getProduct().getId())) {
                    smp.setQuantity(smap.getQuantity());
                }
            }

            /**
             * se a quantidade de todos os produtos da consignação for 0 então a
             * consignação estará fechada não haverá mais acertos
             * senão se algum ainda for maior que 0 então ainda está aberta
             */
            if (smap.getQuantity() > 0) {
                consignmentOpen = true;
            }
        }

        consignment.setOpen(consignmentOpen);
        
        //atualizar consignaçao
        super.save(consignment);
        
        //cadastrar acerto de consignação
        return (StockMovementAdjust) super.save(entity);
    }

}
