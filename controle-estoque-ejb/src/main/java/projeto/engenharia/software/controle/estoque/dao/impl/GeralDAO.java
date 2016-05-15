package projeto.engenharia.software.controle.estoque.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import projeto.engenharia.software.controle.estoque.base.entity.dao.GenericDAO;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGeralDAO;

/**
 *
 * @author sueny
 */
@Stateless
@Local(IGeralDAO.class)
public class GeralDAO extends GenericDAO implements IGeralDAO {

    @PersistenceContext(unitName = "estoque-pu")
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
