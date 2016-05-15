package projeto.engenharia.software.controle.estoque.base.entity.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGenericDAO;

/**
 *
 * @author sueny
 */
public abstract class GenericDAO<T> implements IGenericDAO<T> {

    protected static Logger log = Logger.getLogger(GenericDAO.class.getName());

    private static final long serialVersionUID = 1816981188404559265L;

    protected EntityManager entityManager;

    protected abstract void setEntityManager(EntityManager entityManager);

    /**
     * Return entityManager.
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public T insert(T entity) throws Exception {
        try {
            getEntityManager().persist(entity);
            return entity;
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERRO", e.getCause());
            throw e;
        }
    }

    @Override
    public T update(T entity) throws Exception {
        try {
            return getEntityManager().merge(entity);
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERRO", e.getCause());
            throw e;
        }
    }

    @Override
    public void remove(T entity) throws Exception {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERRO", e.getCause());
            throw e;
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public T get(Class<T> clazz, Long id) throws Exception {
        try {
            return getEntityManager().find(clazz, id);
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERRO", e.getCause());
            throw e;
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<T> list(String namedQuery, Object... params) throws Exception {
        try {
            Query query = getEntityManager().createNamedQuery(namedQuery);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    if (params[i] != null) {
                        query.setParameter("p" + i, params[i]);
                    }
                }
            }
            return (List<T>) query.getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERRO", e.getCause());
            throw e;
        }
    }

}