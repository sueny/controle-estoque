package projeto.engenharia.software.controle.estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import projeto.engenharia.software.controle.estoque.base.entity.Client;
import projeto.engenharia.software.controle.estoque.base.entity.ModelData;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovement;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovementProduct;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IConsignacaoAS;

/**
 * REST Web Service
 *
 * @author sueny
 */
@Path("consignacao")
@RequestScoped
public class ConsignacaoResource {

    @Inject
    IConsignacaoAS as;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastrar/")
    public Response cadastrar(StockMovement stockMovement) {
        try {
            for (StockMovementProduct smp : stockMovement.getProductList()) {
                smp.setStockMovement(stockMovement);
            }
            
            as.save(stockMovement);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ConsignacaoResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    /**
     * Listar consignação em aberto por cliente.
     * @param client
     * @return 
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("listarporcliente/")
    public Response listar(Client client) {
        List<StockMovement> list = new ArrayList<>();
        try {
            list = as.list("StockMovement.buscarEmAbertoPorCliente", 'C', client.getId(), Boolean.TRUE);
            return Response.ok(
                    new ModelData<>(true, list)
            ).build();
        } catch (Exception ex) {
            Logger.getLogger(ConsignacaoResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

}
