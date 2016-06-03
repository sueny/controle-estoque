package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productSuperCategory")
public class ProductSuperCategory implements IEntityBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Necessário informar o nome")
    private String name;

    private String description;

    private String code;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "superCategory")
    private List<ProductSubCategory> listSubCategory;

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

    public List<ProductSubCategory> getListSubCategory() {
        return listSubCategory;
    }

    public void setListSubCategory(List<ProductSubCategory> listSubCategory) {
        this.listSubCategory = listSubCategory;
    }

}
