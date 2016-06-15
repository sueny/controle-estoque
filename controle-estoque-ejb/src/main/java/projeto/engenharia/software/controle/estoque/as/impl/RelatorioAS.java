package projeto.engenharia.software.controle.estoque.as.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IRelatorioAS;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGenericDAO;
import projeto.engenharia.software.controle.estoque.base.entity.dao.iface.IGeralDAO;
import projeto.engenharia.software.controle.estoque.base.entity.util.Querys;

@Stateless
@Local(IRelatorioAS.class)
public class RelatorioAS extends GenericsAS implements IRelatorioAS {

    @EJB
    private IGeralDAO dao;

    @Override
    public IGenericDAO getDAO() throws Exception {
        return dao;
    }

    @Override
    public List listProdutoTop10() throws Exception {
        return super.listNativeQuery(Querys.SQL_PRODUTO_TOP_10);
    }

}
