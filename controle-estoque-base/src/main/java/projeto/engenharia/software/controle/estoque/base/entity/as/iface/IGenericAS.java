/**
 *
 * @author Vitor
 */
package projeto.engenharia.software.controle.estoque.base.entity.as.iface;

import java.util.List;

public interface IGenericAS<T> {

    T save(T entity) throws Exception;

    void remove(T entity) throws Exception;

    T get(Class<T> clazz, Object id) throws Exception;

    List<T> list(Class entityClass) throws Exception;

    int count(Class entityClass) throws Exception;

    List<T> list(String namedQuery, Object... params) throws Exception;
    
    List listNativeQuery(String nativeQuery, Object... params) throws Exception;
}
