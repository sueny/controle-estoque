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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "stockMovement")
@NamedQueries({
    @NamedQuery(
            name = "StockMovement.buscarEmAbertoPorCliente",
            query = "select obj from StockMovement obj "
                    + " where obj.type = :p0 "
                    + " and obj.client.id = :p1 "
                    + " and obj.open = :p2 "
    )
})
public class StockMovement implements IEntityBase, Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /* Consignação ou Venda */
    @NotNull
    private char type;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
//    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date dataSaida;
    
    @Temporal(TemporalType.TIMESTAMP)
//    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date dataRetorno;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "client",
            referencedColumnName = "ID",
            nullable = false)
    private Client client;
    
    @NotNull
    @OneToMany(fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "stockMovement",
            cascade = {CascadeType.ALL})
    private List<StockMovementProduct> productList = new ArrayList<>();
    
    private Boolean open = true;
    
    private String obs;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
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

    public List<StockMovementProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<StockMovementProduct> productList) {
        this.productList = productList;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
