package projeto.engenharia.software.controle.estoque.base.entity;

//import io.github.benas.randombeans.annotation.Randomizer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "client")
@NamedQueries({
    @NamedQuery(
            name = "Client.buscarPorName",
            query = "select obj from Client obj  where LOWER(obj.name) like LOWER(:p0) "
    ),
    @NamedQuery(
            name = "Client.buscarPorNameComConsignacaoAberta",
            query = "select obj from Client obj INNER JOIN obj.listStockMovement lsm where LOWER(obj.name) like LOWER(:p0) AND LOWER(lsm.type) = LOWER(:p1) AND lsm.open = :p2 "
    )
})
@JsonIgnoreProperties(value = {"listStockMovement"})
public class Client implements IEntityBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private char type;

//    @Randomizer(RandomizerFone.class)
    private String phoneNumber;

//    @Randomizer(RandomizerFone.class)
    private String cellNumber;

    @Size(max = 11)
    private String cpf;

    @Size(max = 14)
    private String cnpj;

    @Size(max = 50)
    private String rg;

    @Size(max = 20)
//    @Randomizer(RandomizerIe.class)
    private String ie;

    @Size(max = 50)
    private String address;

    @Size(max = 10)
    private String number;

    @Size(max = 50)
    private String neighborhood;

    @Size(max = 50)
    private String city;

    private String state;

    @Size(max = 8)
//    @Randomizer(RandomizerZipCode.class)
    private String cep;

//    @Randomizer(RandomizerEmail.class)
    private String email;

    @Size(max = 255)
    private String obs;

    @OneToMany(fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "client",
            cascade = {CascadeType.ALL})
    private List<StockMovement> listStockMovement = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<StockMovement> getListStockMovement() {
        return listStockMovement;
    }

    public void setListStockMovement(List<StockMovement> listStockMovement) {
        this.listStockMovement = listStockMovement;
    }

}
