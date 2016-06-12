package projeto.engenharia.software.controle.estoque.base.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Sueny
 */
public class StockMovementAssociationId implements Serializable {

    private Integer stockMovement;

    private Integer product;

    @Override
    public int hashCode() {
        return (int) (stockMovement + product);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof StockMovementAssociationId) {
            StockMovementAssociationId otherId = (StockMovementAssociationId) object;
            return (Objects.equals(otherId.stockMovement, this.stockMovement)) && (Objects.equals(otherId.product, this.product));
        }
        return false;
    }

    public Integer getStockMovement() {
        return stockMovement;
    }

    public void setStockMovement(Integer stockMovement) {
        this.stockMovement = stockMovement;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }
    
}
