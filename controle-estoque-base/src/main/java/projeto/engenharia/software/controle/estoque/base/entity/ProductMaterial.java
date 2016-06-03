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
    private Integer quantity;

//    @PrimaryKeyJoinColumn(name = "productId", referencedColumnName = "ID")
    /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(name = "employeeId", updatable = false, insertable = false)
  * or @JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "id")
     */
    @Id
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "product", referencedColumnName = "ID")
    private Product product;

//    @PrimaryKeyJoinColumn(name = "materialId", referencedColumnName = "ID")
    /* the same goes here:
  *  if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(name = "projectId", updatable = false, insertable = false)
  * or @JoinColumn(name = "projectId", updatable = false, insertable = false, referencedColumnName = "id")
     */
    @Id
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "material", referencedColumnName = "ID")
    private Material material;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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
