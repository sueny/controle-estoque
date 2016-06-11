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
@Table(name = "stockMovementProduct")
@IdClass(StockMovementAssociationId.class)
@JsonIgnoreProperties(value = {"stockMovement"})
public class StockMovementProduct implements Serializable {

    @NotNull(message = "Necessário informar a quantidade")
    private Integer quantity;
    
    @NotNull(message = "Necessário informar o preco")
    private Double price;
    
    @Id
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "stockMovement", referencedColumnName = "ID")
    private StockMovement stockMovement;
    
    @Id
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product", referencedColumnName = "ID")
    private Product product;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonIgnore
    public StockMovement getStockMovement() {
        return stockMovement;
    }

    @JsonProperty
    public void setStockMovement(StockMovement stockMovement) {
        this.stockMovement = stockMovement;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
