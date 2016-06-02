
package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@Entity
@Table(name = "productSubCategory")
@NamedQueries({
        @NamedQuery(
                name = "ProductSubCategory.listarPorCategoria",
                query = "select obj from ProductSubCategory AS obj WHERE obj.superCategory = :p0"
        )
})
public class ProductSubCategory implements IEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Necessário informar o nome.")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "superCategory",
            referencedColumnName = "ID",
            nullable = false)
    //@JsonManagedReference
    private ProductSuperCategory superCategory;

    @NotNull(message = "Necessário informar a descrição")
    private String description;

    @NotNull(message = "Necessário informar o código.")
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductSuperCategory getSuperCategory() {
        return superCategory;
    }

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
