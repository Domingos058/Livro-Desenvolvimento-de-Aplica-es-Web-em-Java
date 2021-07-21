package vendaprodutos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vendaprodutos.entidades.ItemVenda;
import vendaprodutos.entidades.Produto;
import vendaprodutos.entidades.Venda;

/**
 * DAO para a entidade ItemVenda.
 *
 * @author Prof. Dr. David Buzatto
 */
public class ItemVendaDAO extends DAO<ItemVenda> {

    public ItemVendaDAO() throws SQLException {
    }

    @Override
    public void salvar( ItemVenda obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "item_venda( venda_id, cliente_id, valor, quantidade ) " + 
                "VALUES( ?, ?, ?, ? );" );

        stmt.setInt( 1, obj.getVenda().getId() );
        stmt.setInt( 2, obj.getProduto().getId() );
        stmt.setBigDecimal( 3, obj.getValor() );
        stmt.setBigDecimal( 4, obj.getQuantidade() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar( ItemVenda obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE item_venda " + 
                "SET" + 
                "    valor = ?," + 
                "    quantidade = ? " + 
                "WHERE" + 
                "    venda_id = ? AND " +
                "    produto_id = ?;" );

        stmt.setBigDecimal( 1, obj.getValor() );
        stmt.setBigDecimal( 2, obj.getQuantidade() );
        stmt.setInt( 3, obj.getVenda().getId() );
        stmt.setInt( 4, obj.getProduto().getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir( ItemVenda obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM item_venda " + 
                "WHERE" + 
                "    venda_id = ? AND " +
                "    produto_id = ?;" );

        stmt.setInt( 1, obj.getVenda().getId() );
        stmt.setInt( 2, obj.getProduto().getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<ItemVenda> listarTodos() throws SQLException {
        
        // nesse caso, não há sentido haver uma listagem por todos
        // os itens de venda, visto que essa entidade é uma entidade
        // de ligação.
        List<ItemVenda> lista = new ArrayList<>();
        return lista;

    }

    @Override
    public ItemVenda obterPorId( int id ) throws SQLException {

        // o identificador dessa entidade é composto!
        // precisamos ter um método especializado...
        return null;

    }
    
    public ItemVenda obterPorId( int idVenda, int idProduto ) throws SQLException {

        ItemVenda itemVenda = null;

        // não serão feitas as junções nesse caso
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * FROM item_venda " + 
                "WHERE venda_id = ? AND " +
                "      produto_id = ?;" );

        stmt.setInt( 1, idVenda );
        stmt.setInt( 2, idProduto );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            itemVenda = new ItemVenda();
            Venda v = new Venda();
            Produto p = new Produto();
            
            itemVenda.setValor( rs.getBigDecimal( "valor" ) );
            itemVenda.setQuantidade( rs.getBigDecimal( "quantidade" ) );
            itemVenda.setVenda( v );
            itemVenda.setProduto( p );
            
            v.setId( rs.getInt( "venda_id" ) );
            p.setId( rs.getInt( "produto_id" ) );

        }

        rs.close();
        stmt.close();

        return itemVenda;

    }

}
