package projeto.engenharia.software.controle.estoque;

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
import projeto.engenharia.software.controle.estoque.base.entity.ModelData;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovement;
import projeto.engenharia.software.controle.estoque.base.entity.StockMovementProduct;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IVendaAS;

/**
 * REST Web Service
 *
 * @author sueny
 */
@Path("venda")
@RequestScoped
public class VendaResource {

    @Inject
    IVendaAS as;

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
            Logger.getLogger(VendaResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

}
