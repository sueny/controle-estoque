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
@Table(name = "ProductModel")
public class ProductModel implements IEntityBase {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        
        @NotNull(message = "Necessário informar o nome")
        private String name;
	
        private ProductSubCategory productSubCategory;
	
        @NotNull(message = "Necessário informar a descrição")
        private String description;
	
        private Season season;

        
        public Integer getId() {
	 	 return id; 
	}
	public void setId(Integer id) { 
		 this.id = id; 
	}
	public String getName() {
	 	 return name; 
	}
	public void setName(String name) { 
		 this.name = name; 
	}
	public ProductSubCategory getProductSubCategory() {
	 	 return productSubCategory; 
	}
	public void setProductSubCategory(ProductSubCategory productSubCategory) { 
		 this.productSubCategory = productSubCategory; 
	}
	public String getDescription() {
	 	 return description; 
	}
	public void setDescription(String description) { 
		 this.description = description; 
	}

        public Season getSeason() {
	 	 return season; 
	}
	public void setSeason(Season season) { 
		 this.season = season; 
	} 

}
