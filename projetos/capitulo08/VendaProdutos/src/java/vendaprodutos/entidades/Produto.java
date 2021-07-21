package vendaprodutos.entidades;

import java.math.BigDecimal;

/**
 * Entidade Produto.
 *
 * @author Prof. Dr. David Buzatto
 */
public class Produto {

    private int id;
    private String descricao;
    private String codigoBarras;
    private BigDecimal valorVenda;
    private BigDecimal estoque;
    private Fornecedor fornecedor;
    private UnidadeMedida unidadeMedida;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras( String codigoBarras ) {
        this.codigoBarras = codigoBarras;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda( BigDecimal valorVenda ) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque( BigDecimal estoque ) {
        this.estoque = estoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor( Fornecedor fornecedor ) {
        this.fornecedor = fornecedor;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida( UnidadeMedida unidadeMedida ) {
        this.unidadeMedida = unidadeMedida;
    }

}
