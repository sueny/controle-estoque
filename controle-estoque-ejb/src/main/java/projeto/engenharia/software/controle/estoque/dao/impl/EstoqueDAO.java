package projeto.engenharia.software.controle.estoque.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import projeto.engenharia.software.controle.estoque.base.entity.dao.GenericDAO;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IEstoqueDAO;

/**
 *
 * @author house
 */
@Stateless
@Local(IEstoqueDAO.class)
public class EstoqueDAO extends GenericDAO implements IEstoqueDAO {
    
    @SuppressWarnings("unchecked")
    @PersistenceContext(unitName = "estoque-pu")
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
}
