package projeto.engenharia.software.controle.estoque;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;

/**
 *
 * @author sueny
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    private final Logger log = Logger.getLogger("ApplicationConfig");
        
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 2.0 JSON provider:
        try {
            Class jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
            resources.add(jsonProvider);
        } catch (ClassNotFoundException ex) {
            log.log(Level.SEVERE, "ERRO", ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(projeto.engenharia.software.controle.estoque.AcertoConsignacaoResource.class);
        resources.add(projeto.engenharia.software.controle.estoque.ClientResource.class);
        resources.add(projeto.engenharia.software.controle.estoque.ConsignacaoResource.class);
        resources.add(projeto.engenharia.software.controle.estoque.MaterialResource.class);
        resources.add(projeto.engenharia.software.controle.estoque.ProductModelResource.class);
        resources.add(projeto.engenharia.software.controle.estoque.ProductResource.class);
        resources.add(projeto.engenharia.software.controle.estoque.ProductSubCategoryResource.class);
        resources.add(projeto.engenharia.software.controle.estoque.ProductSuperCategoryResource.class);
        resources.add(projeto.engenharia.software.controle.estoque.StockResource.class);
    }
    
}
