package projeto.engenharia.software.controle.estoque.as.impl;

import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGenericDAO;


public class MaterialAS<Material> extends GenericsAS<Material> {
    
    private IGenericDAO dao;

    @Override
    public IGenericDAO<Material> getDAO() throws Exception {
        return dao;
    }
    
    
    
}
