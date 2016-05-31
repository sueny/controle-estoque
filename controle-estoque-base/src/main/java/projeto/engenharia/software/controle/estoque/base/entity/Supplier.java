package projeto.engenharia.software.controle.estoque.base.entity;

import projeto.engenharia.software.controle.estoque.base.entity.util.RandomizerFone;
//import io.github.benas.randombeans.annotation.Randomizer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import projeto.engenharia.software.controle.estoque.base.entity.util.RandomizerZipCode;
import projeto.engenharia.software.controle.estoque.base.entity.util.RandomizerCnpj;
import projeto.engenharia.software.controle.estoque.base.entity.util.RandomizerEmail;
import projeto.engenharia.software.controle.estoque.base.entity.util.RandomizerIe;

public class Supplier {

    private Integer id;
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

//    @Pattern(regexp="\\(\\d{2}\\)\\d{4,5}-\\d{4}")
//    @Randomizer(RandomizerFone.class)
    private String phoneNumber;

//    @Pattern(regexp="\\(\\d{2}\\)\\d{4,5}-\\d{4}")
//    @Randomizer(RandomizerFone.class)
    private String cellNumber;

    @NotNull
//    @Pattern(regexp="\\d{14}")
//    @Randomizer(RandomizerCnpj.class)
    private String cnpj;

    @NotNull
//    @Pattern(regexp="\\d{8}")
//    @Randomizer(RandomizerIe.class)
    private String ie;

    @Size(min = 1, max = 50)
    private String address;
    
    @Size(min = 1, max = 10)
    private String number;

    @Size(min = 1, max = 50)
    private String neighborhood;

    @Size(min = 1, max = 50)
    private String city;

//    @Pattern(regexp="\\p{Upper}{2}")
    private String state;

//    @Pattern(regexp="\\d{5}-\\d{3}")
//    @Randomizer(RandomizerZipCode.class)
    private String cep;

//    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
//    @Randomizer(RandomizerEmail.class)
    private String email;

    @Size(min = 1, max = 255)
    private String obs;
    
    public Supplier() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the cellNumber
     */
    public String getCellNumber() {
        return cellNumber;
    }

    /**
     * @param cellNumber the cellNumber to set
     */
    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the ie
     */
    public String getIe() {
        return ie;
    }

    /**
     * @param ie the ie to set
     */
    public void setIe(String ie) {
        this.ie = ie;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

}
