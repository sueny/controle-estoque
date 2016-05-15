/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.engenharia.software.controle.estoque.base.entity.dao.iface;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sueny
 */
public interface IGenericDAO<T> extends Serializable {

    T insert(T entity) throws Exception;

    T update(T entity) throws Exception;

    void remove(T entity) throws Exception;

    T get(Class<T> clazz, Long id) throws Exception;

    List<T> list(String namedQuery, Object... params) throws Exception;
}
