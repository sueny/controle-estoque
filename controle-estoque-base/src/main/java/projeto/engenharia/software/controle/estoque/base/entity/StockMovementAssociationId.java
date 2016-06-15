package projeto.engenharia.software.controle.estoque.base.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Sueny
 */
public class StockMovementAssociationId implements Serializable {

    private Integer stockMovement;

    private Integer stock;

    @Override
    public int hashCode() {
        return (int) (stockMovement + stock);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof StockMovementAssociationId) {
            StockMovementAssociationId otherId = (StockMovementAssociationId) object;
            return (Objects.equals(otherId.stockMovement, this.stockMovement)) && (Objects.equals(otherId.stock, this.stock));
        }
        return false;
    }

    public Integer getStockMovement() {
        return stockMovement;
    }

    public void setStockMovement(Integer stockMovement) {
        this.stockMovement = stockMovement;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
}
