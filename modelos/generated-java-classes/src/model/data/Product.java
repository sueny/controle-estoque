package model.data;

public class Product extends Item {

	/**
	 * 
	 */
	private ProductModel productModel;
	/**
	 * 
	 */
	private Size size;
	/**
	 * 
	 */
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
