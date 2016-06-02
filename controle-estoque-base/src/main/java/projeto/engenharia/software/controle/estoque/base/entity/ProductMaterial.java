package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Vitor
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ProductMaterial")
public class ProductMaterial implements IEntityBase {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
        @NotNull(message = "Necessário informar a quantidade")
	private Double quantity;
	private Product product;
	private Material material;

        
        
        public Integer getId() {
	 	 return id;
	}
        public void setId(Integer id) {
		 this.id = id;
	}

        public Double getQuantity() {
	 	 return quantity;
	}

        public void setQuantity(Double quantity) {
		 this.quantity = quantity;
	}
	public Product getProduct() {
	 	 return product;
	}
	public void setProduct(Product product) {
		 this.product = product;
	}
	public Material getMaterial() {
	 	 return material;
	}
	public void setMaterial(Material material) {
		 this.material = material; 
	}

}
