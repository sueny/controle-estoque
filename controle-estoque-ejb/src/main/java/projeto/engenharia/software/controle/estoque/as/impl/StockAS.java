package projeto.engenharia.software.controle.estoque.as.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IStockAS;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGenericDAO;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGeralDAO;

@Stateless
@Local(IStockAS.class)
public class StockAS extends GenericsAS implements IStockAS {
    
    @EJB
    private IGeralDAO dao;

    @Override
    public IGenericDAO getDAO() throws Exception {
        return dao;
    }
    
}
