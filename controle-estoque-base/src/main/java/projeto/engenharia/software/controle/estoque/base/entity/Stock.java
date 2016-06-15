package projeto.engenharia.software.controle.estoque.base.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import projeto.engenharia.software.controle.estoque.base.entity.util.serializer.CustomDateSerializer;

/**
 *
 * @author Sueny
 */
@Entity
@Table(name = "stock")
@NamedQueries({
    @NamedQuery(
            name = "Stock.buscarPorProductName",
            query = "select obj from Stock obj  where LOWER(obj.product.name) like LOWER(:p0) and obj.quantity > 0 "
    ),
    @NamedQuery(
            name = "Stock.buscarPorProductSkuCode",
            query = "select obj from Stock obj  where LOWER(obj.product.skuCode) like LOWER(:p0) and obj.quantity > 0 "
    ),
})
public class Stock implements IEntityBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Necessário informar a data")
    @Temporal(TemporalType.TIMESTAMP)
//    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date data;
    
    @NotNull(message = "Necessário informar o produto")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "product",
            referencedColumnName = "ID",
            nullable = false)
    private Product product;
    
    @NotNull(message = "Necessário informar a quantidade")
    private Integer quantity;
    
    @NotNull(message = "Necessário informar o preço")
    private Double price;
    
    private String obs;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}
