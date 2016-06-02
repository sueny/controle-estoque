package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product extends Item implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productModel",
            referencedColumnName = "ID",
            nullable = false)
    private ProductModel productModel;

    @OneToMany(mappedBy = "material")
    private List<ProductMaterial> materials;

    @Enumerated(EnumType.STRING)
    private SizeEnum size;

    @Size(max = 255)
    private String variation;

    /**
     * Getter of productModel
     */
    public ProductModel getProductModel() {
        return productModel;
    }

    /**
     * Setter of productModel
     */
    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    /**
     * Getter of size
     */
    public SizeEnum getSize() {
        return size;
    }

    /**
     * Setter of size
     */
    public void setSize(SizeEnum size) {
        this.size = size;
    }

    /**
     * Getter of variation
     */
    public String getVariation() {
        return variation;
    }

    /**
     * Setter of variation
     */
    public void setVariation(String variation) {
        this.variation = variation;
    }

    public List<ProductMaterial> getMaterials() {
        return materials;
    }

    public void setMaterials(List<ProductMaterial> materials) {
        this.materials = materials;
    }
    
}
