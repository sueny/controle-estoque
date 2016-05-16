package model.data;

public class Material extends Item {

	/**
	 * 
	 */
	private MaterialCategory materialCategory;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private MeasuringUnit measuringUnit;
	/**
	 * Getter of materialCategory
	 */
	public MaterialCategory getMaterialCategory() {
	 	 return materialCategory; 
	}
	/**
	 * Setter of materialCategory
	 */
	public void setMaterialCategory(MaterialCategory materialCategory) { 
		 this.materialCategory = materialCategory; 
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
	 * Getter of measuringUnit
	 */
	public MeasuringUnit getMeasuringUnit() {
	 	 return measuringUnit; 
	}
	/**
	 * Setter of measuringUnit
	 */
	public void setMeasuringUnit(MeasuringUnit measuringUnit) { 
		 this.measuringUnit = measuringUnit; 
	} 

}
