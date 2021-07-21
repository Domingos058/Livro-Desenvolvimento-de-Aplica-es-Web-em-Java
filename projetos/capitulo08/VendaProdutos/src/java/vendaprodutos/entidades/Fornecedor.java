package vendaprodutos.entidades;

/**
 * Entidade Fornecedor.
 *
 * @author Prof. Dr. David Buzatto
 */
public class Fornecedor {

    private int id;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private Cidade cidade;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial( String razaoSocial ) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj( String cnpj ) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro( String logradouro ) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero( String numero ) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro( String bairro ) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep( String cep ) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade( Cidade cidade ) {
        this.cidade = cidade;
    }

}
