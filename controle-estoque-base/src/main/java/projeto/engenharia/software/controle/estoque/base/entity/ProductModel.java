package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productModel")
public class ProductModel implements IEntityBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Necessário informar o nome")
    private String name;

    @NotNull(message = "Necessário informar a categoria")
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productSubCategory", nullable = false)
    private ProductSubCategory productSubCategory;

    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Season season;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductSubCategory getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(ProductSubCategory productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

}
