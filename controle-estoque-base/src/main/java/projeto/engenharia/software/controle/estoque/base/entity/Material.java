package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("M")
@Table(name = "material")
@NamedQueries({
        @NamedQuery(
                name = "Material.listarTodos",
                query = "select obj from Material obj"
        )
})
public class Material extends Item implements Serializable {

//    @NotNull
//    private MaterialCategory materialCategory;

    @NotNull
    @Size(max = 50)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MeasuringUnit measuringUnit;

//    public MaterialCategory getMaterialCategory() {
//        return materialCategory;
//    }
//
//    public void setMaterialCategory(MaterialCategory materialCategory) {
//        this.materialCategory = materialCategory;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MeasuringUnit getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(MeasuringUnit measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

}
