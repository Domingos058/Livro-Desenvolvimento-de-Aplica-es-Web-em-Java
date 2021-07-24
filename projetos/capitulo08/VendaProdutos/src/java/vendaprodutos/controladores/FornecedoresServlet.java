package vendaprodutos.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vendaprodutos.dao.FornecedorDAO;
import vendaprodutos.entidades.Cidade;
import vendaprodutos.entidades.Fornecedor;
import vendaprodutos.utils.Utils;

/**
 * Servlet para tratar Fornecedores.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet( name = "FornecedoresServlet", 
             urlPatterns = { "/processaFornecedores" } )
public class FornecedoresServlet extends HttpServlet {

    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        
        FornecedorDAO dao = null;
        RequestDispatcher disp = null;
        
        try {

            dao = new FornecedorDAO();

            if ( acao.equals( "inserir" ) ) {

                String razaoSocial = request.getParameter( "razaoSocial" );
                String cnpj = request.getParameter( "cnpj" );
                String email = request.getParameter( "email" );
                String logradouro = request.getParameter( "logradouro" );
                String numero = request.getParameter( "numero" );
                String bairro = request.getParameter( "bairro" );
                String cep = request.getParameter( "cep" );
                Long idCidade = Utils.getLong( request, "idCidade" );

                Cidade ci = new Cidade();
                ci.setId( idCidade );

                Fornecedor f = new Fornecedor();
                f.setRazaoSocial( razaoSocial );
                f.setCnpj( cnpj );
                f.setEmail( email );
                f.setLogradouro( logradouro );
                f.setNumero( numero );
                f.setBairro( bairro );
                f.setCep( cep );
                f.setCidade( ci );

                dao.salvar( f );

                disp = request.getRequestDispatcher(
                        "/formularios/fornecedores/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                Long id = Utils.getLong( request, "id" );
                String razaoSocial = request.getParameter( "razaoSocial" );
                String cnpj = request.getParameter( "cnpj" );
                String email = request.getParameter( "email" );
                String logradouro = request.getParameter( "logradouro" );
                String numero = request.getParameter( "numero" );
                String bairro = request.getParameter( "bairro" );
                String cep = request.getParameter( "cep" );
                Long idCidade = Utils.getLong( request, "idCidade" );

                Cidade ci = new Cidade();
                ci.setId( idCidade );

                Fornecedor f = new Fornecedor();
                f.setId( id );
                f.setRazaoSocial( razaoSocial );
                f.setCnpj( cnpj );
                f.setEmail( email );
                f.setLogradouro( logradouro );
                f.setNumero( numero );
                f.setBairro( bairro );
                f.setCep( cep );
                f.setCidade( ci );

                dao.atualizar( f );

                disp = request.getRequestDispatcher(
                        "/formularios/fornecedores/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                Long id = Utils.getLong( request, "id" );

                Fornecedor f = new Fornecedor();
                f.setId( id );

                dao.excluir( f );

                disp = request.getRequestDispatcher(
                        "/formularios/fornecedores/listagem.jsp" );

            } else {
                
                Long id = Utils.getLong( request, "id" );
                
                Fornecedor f = dao.obterPorId( id );
                request.setAttribute( "fornecedor", f );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/fornecedores/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/fornecedores/excluir.jsp" );
                }
                
            }

        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        if ( disp != null ) {
            disp.forward( request, response );
        }
        
    }

    @Override
    protected void doGet( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    protected void doPost( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    public String getServletInfo() {
        return "FornecedoresServlet";
    }

}
