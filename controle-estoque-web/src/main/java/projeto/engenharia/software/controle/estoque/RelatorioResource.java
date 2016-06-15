package projeto.engenharia.software.controle.estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import projeto.engenharia.software.controle.estoque.base.entity.ModelData;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IRelatorioAS;

/**
 * REST Web Service
 *
 * @author sueny
 */
@Path("relatorio")
@RequestScoped
public class RelatorioResource {

    @Inject
    IRelatorioAS as;

 

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("produtotop10/")
    public Response listar() {
        List list = new ArrayList<>();
        try {
            list = as.listProdutoTop10();
            return Response.ok(
                    new ModelData<>(true, list)
            ).build();
        } catch (Exception ex) {
            Logger.getLogger(ClientResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }

    }

}
