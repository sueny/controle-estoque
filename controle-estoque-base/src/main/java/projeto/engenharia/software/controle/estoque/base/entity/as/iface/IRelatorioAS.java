package projeto.engenharia.software.controle.estoque.base.entity.as.iface;

import java.util.List;

/**
 *
 * @author Sueny
 */
public interface IRelatorioAS extends IGenericAS {
    
    List listProdutoTop10() throws Exception;
    
}
