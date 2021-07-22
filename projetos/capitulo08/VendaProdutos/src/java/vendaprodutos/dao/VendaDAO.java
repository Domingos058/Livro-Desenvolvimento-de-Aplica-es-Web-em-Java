package vendaprodutos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vendaprodutos.entidades.Cidade;
import vendaprodutos.entidades.Cliente;
import vendaprodutos.entidades.Estado;
import vendaprodutos.entidades.Venda;

/**
 * DAO para a entidade Venda.
 *
 * @author Prof. Dr. David Buzatto
 */
public class VendaDAO extends DAO<Venda> {

    public VendaDAO() throws SQLException {
    }

    @Override
    public void salvar( Venda obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "venda(" + 
                "    data, " + 
                "    cliente_id ) " + 
                "VALUES( ?, ? );",
                new String[]{ "id" } );

        stmt.setDate( 1, obj.getData() );
        stmt.setInt( 2, obj.getCliente().getId() );

        stmt.executeUpdate();
        
        ResultSet rsPK = stmt.getGeneratedKeys();
        if ( rsPK.next() ) {
            obj.setId( rsPK.getInt( "id" ) );
        }
        
        rsPK.close();
        stmt.close();

    }

    @Override
    public void atualizar( Venda obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE venda " + 
                "SET" + 
                "    data = ?, " + 
                "    cliente_id = ? " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setDate( 1, obj.getData() );
        stmt.setInt( 2, obj.getCliente().getId() );
        stmt.setInt( 3, obj.getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir( Venda obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM venda " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<Venda> listarTodos() throws SQLException {

        List<Venda> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    v.id idVenda, " + 
                "    v.data dataVenda, " +
                "    c.id idCliente, " + 
                "    c.nome nomeCliente, " + 
                "    c.sobreNome sobrenomeCliente, " + 
                "    c.dataNascimento dataNascimentoCliente, " + 
                "    c.cpf cpfCliente, " + 
                "    c.email emailCliente, " + 
                "    c.logradouro logradouroCliente, " + 
                "    c.numero numeroCliente, " + 
                "    c.bairro bairroCliente, " + 
                "    c.cep cepCliente, " +
                "    ci.id idCidade, " + 
                "    ci.nome nomeCidade, " + 
                "    e.id idEstado, " + 
                "    e.nome nomeEstado, " + 
                "    e.sigla siglaEstado " + 
                "FROM" + 
                "    venda v, " + 
                "    cliente c, " +
                "    cidade ci, " + 
                "    estado e " + 
                "WHERE" + 
                "    v.cliente_id = c.id AND " + 
                "    c.cidade_id = ci.id AND " + 
                "    ci.estado_id = e.id " +
                "ORDER BY p.data DESC, c.nome;" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Venda v = new Venda();
            Cliente c = new Cliente();
            Cidade ci = new Cidade();
            Estado e = new Estado();

            v.setId( rs.getInt( "idVenda" ) );
            v.setData( rs.getDate( "dataVenda" ) );
            v.setCliente( c );

            c.setId( rs.getInt( "idCliente" ) );
            c.setNome( rs.getString( "nomeCliente" ) );
            c.setSobrenome( rs.getString( "sobrenomeCliente" ) );
            c.setDataNascimento( rs.getDate( "dataNascimentoCliente" ) );
            c.setCpf( rs.getString( "cpfCliente" ) );
            c.setEmail( rs.getString( "emailCliente" ) );
            c.setLogradouro( rs.getString( "logradouroCliente" ) );
            c.setNumero( rs.getString( "numeroCliente" ) );
            c.setBairro( rs.getString( "bairroCliente" ) );
            c.setCep( rs.getString( "cepCliente" ) );
            c.setCidade( ci );
            
            ci.setId( rs.getInt( "idCidade" ) );
            ci.setNome( rs.getString( "nomeCidade" ) );
            ci.setEstado( e );

            e.setId( rs.getInt( "idEstado" ) );
            e.setNome( rs.getString( "nomeEstado" ) );
            e.setSigla( rs.getString( "siglaEstado" ) );

            lista.add( v );

        }

        rs.close();
        stmt.close();

        return lista;

    }

    @Override
    public Venda obterPorId( int id ) throws SQLException {

        Venda venda = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    v.id idVenda, " + 
                "    v.data dataVenda, " +
                "    c.id idCliente, " + 
                "    c.nome nomeCliente, " + 
                "    c.sobreNome sobrenomeCliente, " + 
                "    c.dataNascimento dataNascimentoCliente, " + 
                "    c.cpf cpfCliente, " + 
                "    c.email emailCliente, " + 
                "    c.logradouro logradouroCliente, " + 
                "    c.numero numeroCliente, " + 
                "    c.bairro bairroCliente, " + 
                "    c.cep cepCliente, " +
                "    ci.id idCidade, " + 
                "    ci.nome nomeCidade, " + 
                "    e.id idEstado, " + 
                "    e.nome nomeEstado, " + 
                "    e.sigla siglaEstado " + 
                "FROM" + 
                "    venda v, " + 
                "    cliente c, " +
                "    cidade ci, " + 
                "    estado e " + 
                "WHERE" + 
                "    v.id = ? AND " + 
                "    v.cliente_id = c.id AND " + 
                "    c.cidade_id = ci.id AND " + 
                "    ci.estado_id = e.id;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            venda = new Venda();
            Cliente c = new Cliente();
            Cidade ci = new Cidade();
            Estado e = new Estado();

            venda.setId( rs.getInt( "idVenda" ) );
            venda.setData( rs.getDate( "dataVenda" ) );
            venda.setCliente( c );

            c.setId( rs.getInt( "idCliente" ) );
            c.setNome( rs.getString( "nomeCliente" ) );
            c.setSobrenome( rs.getString( "sobrenomeCliente" ) );
            c.setDataNascimento( rs.getDate( "dataNascimentoCliente" ) );
            c.setCpf( rs.getString( "cpfCliente" ) );
            c.setEmail( rs.getString( "emailCliente" ) );
            c.setLogradouro( rs.getString( "logradouroCliente" ) );
            c.setNumero( rs.getString( "numeroCliente" ) );
            c.setBairro( rs.getString( "bairroCliente" ) );
            c.setCep( rs.getString( "cepCliente" ) );
            c.setCidade( ci );
            
            ci.setId( rs.getInt( "idCidade" ) );
            ci.setNome( rs.getString( "nomeCidade" ) );
            ci.setEstado( e );

            e.setId( rs.getInt( "idEstado" ) );
            e.setNome( rs.getString( "nomeEstado" ) );
            e.setSigla( rs.getString( "siglaEstado" ) );

        }

        rs.close();
        stmt.close();

        return venda;

    }

}
