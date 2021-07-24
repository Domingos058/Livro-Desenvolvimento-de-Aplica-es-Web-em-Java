package vendaprodutos.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vendaprodutos.dao.EstadoDAO;
import vendaprodutos.entidades.Estado;
import vendaprodutos.utils.Utils;

/**
 * Servlet para tratar Estados.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet( name = "EstadosServlet", 
             urlPatterns = { "/processaEstados" } )
public class EstadosServlet extends HttpServlet {

    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        EstadoDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new EstadoDAO();

            if ( acao.equals( "inserir" ) ) {

                String nome = request.getParameter( "nome" );
                String sigla = request.getParameter( "sigla" );

                Estado e = new Estado();
                e.setNome( nome );
                e.setSigla( sigla );

                String mensagemErro = Utils.<Estado>validarGerarMensagem( e, "id" );
                
                if ( mensagemErro != null ) {
                    disp = Utils.prepararDespachoErro( request, mensagemErro );
                } else {
                    dao.salvar( e );
                    disp = request.getRequestDispatcher(
                            "/formularios/estados/listagem.jsp" );
                }

            } else if ( acao.equals( "alterar" ) ) {

                Long id = Utils.getLong( request, "id" );
                String nome = request.getParameter( "nome" );
                String sigla = request.getParameter( "sigla" );

                Estado e = new Estado();
                e.setId( id );
                e.setNome( nome );
                e.setSigla( sigla );

                String mensagemErro = Utils.<Estado>validarGerarMensagem( e );
                
                if ( mensagemErro != null ) {
                    disp = Utils.prepararDespachoErro( request, mensagemErro );
                } else {
                    dao.atualizar( e );
                    disp = request.getRequestDispatcher(
                            "/formularios/estados/listagem.jsp" );
                }

            } else if ( acao.equals( "excluir" ) ) {

                Long id = Utils.getLong( request, "id" );

                Estado e = new Estado();
                e.setId( id );

                dao.excluir( e );

                disp = request.getRequestDispatcher(
                        "/formularios/estados/listagem.jsp" );

            } else {
                
                Long id = Utils.getLong( request, "id" );
                
                Estado e = dao.obterPorId( id );
                request.setAttribute( "estado", e );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/estados/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/estados/excluir.jsp" );
                }
                
            }

        } catch ( SQLException exc ) {
            disp = Utils.prepararDespachoErro( request, 
                    "<li>" + exc.getMessage() + "</li>" );
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    disp = Utils.prepararDespachoErro( request, 
                            "<li>" + exc.getMessage() + "</li>" );
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
        return "EstadosServlet";
    }

}
