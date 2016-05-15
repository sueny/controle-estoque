/**
 *
 * @author Vitor
 */
package projeto.engenharia.software.controle.estoque.as.impl;

import java.util.List;
import projeto.engenharia.software.controle.estoque.base.entity.IEntityBase;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IGenericAS;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGenericDAO;

public abstract class GenericsAS<T> implements IGenericAS<T> {

    public abstract IGenericDAO<T> getDAO() throws Exception;

    @Override
    public T save(T entity) throws Exception {

        if (((IEntityBase) entity).getId() == null) {
            getDAO().insert(entity);
        } else {
            entity = getDAO().update(entity);
        }

        return entity;
    }

    @Override
    public void remove(T entity) throws Exception {
        getDAO().remove(entity);
    }

    @Override
    public T get(Class<T> clazz, Long id) throws Exception {
        return getDAO().get(clazz, id);
    }

    @Override
    public List<T> list(Class entityClass) throws Exception {
        return getDAO().list(entityClass);
    }

    @Override
    public int count(Class entityClass) throws Exception {
        return getDAO().count(entityClass);
    }

    @Override
    public List<T> list(String namedQuery, Object... params) throws Exception {
        return getDAO().list(namedQuery, params);
    }

}
