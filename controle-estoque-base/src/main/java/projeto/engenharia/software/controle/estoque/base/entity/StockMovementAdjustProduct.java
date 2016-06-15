package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Sueny
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stockMovementAdjustProduct")
@IdClass(StockMovementAdjustAssociationId.class)
@JsonIgnoreProperties(value = {"stockMovementAdjust"})
public class StockMovementAdjustProduct implements Serializable {

    @NotNull(message = "Necessário informar a quantidade")
    private Integer quantity;

    @NotNull(message = "Necessário informar a quantidade acerto")
    private Integer quantityAcerto;

    @NotNull(message = "Necessário informar a quantidade retorno")
    private Integer quantityRetorno;

    @Id
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "stockMovementAdjust", referencedColumnName = "ID")
    private StockMovementAdjust stockMovementAdjust;

    @Id
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "stock", referencedColumnName = "ID")
    private Stock stock;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityAcerto() {
        return quantityAcerto;
    }

    public void setQuantityAcerto(Integer quantityAcerto) {
        this.quantityAcerto = quantityAcerto;
    }

    public Integer getQuantityRetorno() {
        return quantityRetorno;
    }

    public void setQuantityRetorno(Integer quantityRetorno) {
        this.quantityRetorno = quantityRetorno;
    }

    @JsonIgnore
    public StockMovementAdjust getStockMovementAdjust() {
        return stockMovementAdjust;
    }

    @JsonProperty
    public void setStockMovementAdjust(StockMovementAdjust stockMovementAdjust) {
        this.stockMovementAdjust = stockMovementAdjust;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

}
