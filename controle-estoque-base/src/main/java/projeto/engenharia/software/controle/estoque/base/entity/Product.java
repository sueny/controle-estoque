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
@Table(name = "Product")
public class Product extends Item {

	private ProductModel productModel;
        private Size size;
	@Size(max = 255)
        private String variation;

        /**
	 * Getter of productModel
	 */
	public ProductModel getProductModel() {
	 	 return productModel; 
	}
	/**
	 * Setter of productModel
	 */
	public void setProductModel(ProductModel productModel) { 
		 this.productModel = productModel; 
	}
	/**
	 * Getter of size
	 */
	public Size getSize() {
	 	 return size; 
	}
	/**
	 * Setter of size
	 */
	public void setSize(Size size) { 
		 this.size = size; 
	}
	/**
	 * Getter of variation
	 */
	public String getVariation() {
	 	 return variation; 
	}
	/**
	 * Setter of variation
	 */
	public void setVariation(String variation) { 
		 this.variation = variation; 
	} 

}
