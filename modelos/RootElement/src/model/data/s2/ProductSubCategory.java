package model.data.s2;

public class ProductSubCategory {

	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private ProductSuperCategory productSuperCategory;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String code;
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
	 * Getter of name
	 */
	public String getName() {
	 	 return name; 
	}
	/**
	 * Setter of name
	 */
	public void setName(EString name) { 
		 this.name = name; 
	}
	/**
	 * Getter of productSuperCategory
	 */
	public ProductSuperCategory getProductSuperCategory() {
	 	 return productSuperCategory; 
	}
	/**
	 * Setter of productSuperCategory
	 */
	public void setProductSuperCategory(ProductSuperCategory productSuperCategory) { 
		 this.productSuperCategory = productSuperCategory; 
	}
	/**
	 * Getter of description
	 */
	public String getDescription() {
	 	 return description; 
	}
	/**
	 * Setter of description
	 */
	public void setDescription(EString description) { 
		 this.description = description; 
	}
	/**
	 * Getter of code
	 */
	public String getCode() {
	 	 return code; 
	}
	/**
	 * Setter of code
	 */
	public void setCode(EString code) { 
		 this.code = code; 
	} 

}
