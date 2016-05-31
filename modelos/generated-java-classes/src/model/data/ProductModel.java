package model.data;

public class ProductModel {

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
	private ProductSubCategory productSubCategory;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private Season season;
	/**
	 * Getter of id
	 */
	public Long getId() {
	 	 return id; 
	}
	/**
	 * Setter of id
	 */
	public void setId(Long id) { 
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
	public void setName(String name) { 
		 this.name = name; 
	}
	/**
	 * Getter of productSubCategory
	 */
	public ProductSubCategory getProductSubCategory() {
	 	 return productSubCategory; 
	}
	/**
	 * Setter of productSubCategory
	 */
	public void setProductSubCategory(ProductSubCategory productSubCategory) { 
		 this.productSubCategory = productSubCategory; 
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
	public void setDescription(String description) { 
		 this.description = description; 
	}
	/**
	 * Getter of season
	 */
	public Season getSeason() {
	 	 return season; 
	}
	/**
	 * Setter of season
	 */
	public void setSeason(Season season) { 
		 this.season = season; 
	} 

}
