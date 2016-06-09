package projeto.engenharia.software.controle.estoque.base.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Sueny
 */
public class ProductAssociationId implements Serializable {

    private Integer product;

    private Integer material;

    @Override
    public int hashCode() {
        return (int) (product + material);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ProductAssociationId) {
            ProductAssociationId otherId = (ProductAssociationId) object;
            return (Objects.equals(otherId.product, this.product)) && (Objects.equals(otherId.material, this.material));
        }
        return false;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getMaterial() {
        return material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }
    
}
