package projeto.engenharia.software.controle.estoque.base.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Sueny
 */
public class StockMovementAdjustAssociationId implements Serializable {

    private Integer stockMovementAdjust;

    private Integer stock;

    @Override
    public int hashCode() {
        return (int) (stockMovementAdjust + stock);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof StockMovementAdjustAssociationId) {
            StockMovementAdjustAssociationId otherId = (StockMovementAdjustAssociationId) object;
            return (Objects.equals(otherId.stockMovementAdjust, this.stockMovementAdjust)) && (Objects.equals(otherId.stock, this.stock));
        }
        return false;
    }

    public Integer getStockMovementAdjust() {
        return stockMovementAdjust;
    }

    public void setStockMovementAdjust(Integer stockMovementAdjust) {
        this.stockMovementAdjust = stockMovementAdjust;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
}
