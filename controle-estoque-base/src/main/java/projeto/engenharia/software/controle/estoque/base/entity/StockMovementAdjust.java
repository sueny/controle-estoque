package projeto.engenharia.software.controle.estoque.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "stockMovementAdjust")
public class StockMovementAdjust implements IEntityBase, Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
//    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date dataSaida;
    
    @Temporal(TemporalType.TIMESTAMP)
//    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date dataRetorno;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "consignment",
            referencedColumnName = "ID",
            nullable = false)
    private StockMovement consignment;
    
    @NotNull(message = "Necessário informar o cliente")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "client",
            referencedColumnName = "ID",
            nullable = false)
    private Client client;
    
    @NotNull(message = "Necessário informar o(s) produto(s)")
    @OneToMany(fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "stockMovementAdjust",
            cascade = {CascadeType.ALL})
    private List<StockMovementAdjustProduct> productList = new ArrayList<>();
    
    private String obs;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public StockMovement getConsignment() {
        return consignment;
    }

    public void setConsignment(StockMovement consignment) {
        this.consignment = consignment;
    }
    
    public List<StockMovementAdjustProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<StockMovementAdjustProduct> productList) {
        this.productList = productList;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
