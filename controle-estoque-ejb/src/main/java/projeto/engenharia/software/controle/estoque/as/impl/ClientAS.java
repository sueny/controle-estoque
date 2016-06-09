package projeto.engenharia.software.controle.estoque.as.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IClientAS;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGenericDAO;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGeralDAO;

@Stateless
@Local(IClientAS.class)
public class ClientAS extends GenericsAS implements IClientAS {
    
    @EJB
    private IGeralDAO dao;

    @Override
    public IGenericDAO getDAO() throws Exception {
        return dao;
    }
    
    
    
}
