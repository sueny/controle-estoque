/**
 *
 * @author Vitor
 */

package projeto.engenharia.software.controle.estoque.base.entity.as.iface;

import java.util.List;

public interface IGenericAS<T> {

    T save(T entity) throws Exception;
    
    void remove(T entity) throws Exception;

    T get(Class<T> clazz, Long id) throws Exception;
    
    List<T> list(String namedQuery, Object... params) throws Exception;
}
