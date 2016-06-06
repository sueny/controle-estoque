package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
//import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@DiscriminatorValue("P")
@Table(name = "product")
//@CascadeOnDelete
public class Product extends Item implements Serializable {

    @Enumerated(EnumType.STRING)
    private SizeEnum sizeEnum;

    @Size(max = 255)
    private String variation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "productModel",
            referencedColumnName = "ID",
            nullable = false)
    private ProductModel productModel;

    @OneToMany(fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "product",
            cascade = {CascadeType.ALL})
//    @CascadeOnDelete
    private List<ProductMaterial> listMaterial = new ArrayList<>();

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

    public SizeEnum getSizeEnum() {
        return sizeEnum;
    }

    public void setSizeEnum(SizeEnum sizeEnum) {
        this.sizeEnum = sizeEnum;
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

    public List<ProductMaterial> getListMaterial() {
        return listMaterial;
    }

    public void setListMaterial(List<ProductMaterial> listMaterial) {
        this.listMaterial = listMaterial;
    }

}
