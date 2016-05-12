package projeto.engenharia.software.controle.estoque.as.impl;

import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import projeto.engenharia.software.controle.estoque.base.entity.EntityExample;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IEstoqueAS;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IEstoqueDAO;

/**
 *
 * @author martin
 */
@Stateless
@Local(IEstoqueAS.class)
public class EstoqueAS implements IEstoqueAS {

    private static final Logger log = Logger.getLogger(EstoqueAS.class.getName());
    @Inject
    private IEstoqueDAO dao;

    //businessMethod
    @Override
    public EntityExample findEntityExampleById(Integer id) throws Exception {
        return (EntityExample) dao.get(EntityExample.class, id.longValue());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
