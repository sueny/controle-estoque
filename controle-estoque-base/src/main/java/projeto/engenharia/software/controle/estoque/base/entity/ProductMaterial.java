package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productMaterial")
@IdClass(ProductAssociationId.class)
@JsonIgnoreProperties(value = {"product"})
public class ProductMaterial implements Serializable {

    @NotNull(message = "Necessário informar a quantidade")
    private Double quantity;

    @Id
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product", referencedColumnName = "ID")
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "material", referencedColumnName = "ID")
    private Material material;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    @JsonProperty
    public void setProduct(Product product) {
        this.product = product;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
