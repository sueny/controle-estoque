package model.data.s2;

public class Item {

	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private String skuCode;
	/**
	 * 
	 */
	private String name;
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
	 * Getter of skuCode
	 */
	public String getSkuCode() {
	 	 return skuCode; 
	}
	/**
	 * Setter of skuCode
	 */
	public void setSkuCode(EString skuCode) { 
		 this.skuCode = skuCode; 
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

}
