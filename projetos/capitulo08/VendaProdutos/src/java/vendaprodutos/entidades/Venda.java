package vendaprodutos.entidades;

import java.sql.Date;

/**
 * Entidade Venda.
 *
 * @author Prof. Dr. David Buzatto
 */
public class Venda {

    private int id;
    private boolean cancelada;
    private Date data;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada( boolean cancelada ) {
        this.cancelada = cancelada;
    }

    public Date getData() {
        return data;
    }

    public void setData( Date data ) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente( Cliente cliente ) {
        this.cliente = cliente;
    }

}
