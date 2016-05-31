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
@Table(name = "ProductSuperCategory")
public class ProductSuperCategory implements IEntityBase {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Necessário informar o nome")
        private String name;
	@NotNull(message = "Necessário informar a descrição")
        private String description;
	@NotNull(message = "Necessário informar o código")
        private String code;

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
	public String getDescription() {
	 	 return description; 
	}
	public void setDescription(String description) { 
		 this.description = description; 
	}
	public String getCode() {
	 	 return code; 
	}
	public void setCode(String code) { 
		 this.code = code; 
	} 

}
