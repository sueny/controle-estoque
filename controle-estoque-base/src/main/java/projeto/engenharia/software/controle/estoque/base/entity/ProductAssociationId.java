/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.engenharia.software.controle.estoque.base.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author House
 */
public class ProductAssociationId implements Serializable {

    private Integer productId;

    private Integer materialId;

    @Override
    public int hashCode() {
        return (int) (productId + materialId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ProductAssociationId) {
            ProductAssociationId otherId = (ProductAssociationId) object;
            return (Objects.equals(otherId.productId, this.productId)) && (Objects.equals(otherId.materialId, this.materialId));
        }
        return false;
    }

}
