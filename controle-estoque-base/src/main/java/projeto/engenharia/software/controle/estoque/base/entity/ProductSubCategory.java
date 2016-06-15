
package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name = "productSubCategory")
@NamedQueries({
        @NamedQuery(
                name = "ProductSubCategory.listarPorCategoria",
                query = "select obj from ProductSubCategory AS obj WHERE obj.superCategory = :p0"
        )
})
public class ProductSubCategory implements IEntityBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Necessário informar o nome.")
    private String name;

    private String description;

    private String code;

    @NotNull(message = "Necessário informar a categoria.")
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "superCategory",
            referencedColumnName = "ID",
            nullable = false)
    private ProductSuperCategory superCategory;
    
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

    @JsonIgnore
    public ProductSuperCategory getSuperCategory() {
        return superCategory;
    }

    @JsonProperty
    public void setSuperCategory(ProductSuperCategory superCategory) {
        this.superCategory = superCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
