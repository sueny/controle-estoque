package model.data.s2;

public class ProductMaterial {

	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private EDouble quantity;
	/**
	 * 
	 */
	private Product product;
	/**
	 * 
	 */
	private Material material;
	/**
	 * Getter of id
	 */
	public Long getId() {
	 	 return id; 
	}
	/**
	 * Setter of id
	 */
	public void setId(ELong id) { 
		 this.id = id; 
	}
	/**
	 * Getter of quantity
	 */
	public EDouble getQuantity() {
	 	 return quantity; 
	}
	/**
	 * Setter of quantity
	 */
	public void setQuantity(EDouble quantity) { 
		 this.quantity = quantity; 
	}
	/**
	 * Getter of product
	 */
	public Product getProduct() {
	 	 return product; 
	}
	/**
	 * Setter of product
	 */
	public void setProduct(Product product) { 
		 this.product = product; 
	}
	/**
	 * Getter of material
	 */
	public Material getMaterial() {
	 	 return material; 
	}
	/**
	 * Setter of material
	 */
	public void setMaterial(Material material) { 
		 this.material = material; 
	} 

}
