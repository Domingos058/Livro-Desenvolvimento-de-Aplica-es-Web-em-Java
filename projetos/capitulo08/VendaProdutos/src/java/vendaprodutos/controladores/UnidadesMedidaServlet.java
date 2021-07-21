package vendaprodutos.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vendaprodutos.dao.UnidadeMedidaDAO;
import vendaprodutos.entidades.UnidadeMedida;

/**
 * Servlet para tratar Unidades de Medida.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet( name = "UnidadesMedidaServlet", 
             urlPatterns = { "/processaUnidadesMedida" } )
public class UnidadesMedidaServlet extends HttpServlet {

    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        UnidadeMedidaDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new UnidadeMedidaDAO();

            if ( acao.equals( "inserir" ) ) {

                String descricao = request.getParameter( "descricao" );
                String sigla = request.getParameter( "sigla" );

                UnidadeMedida u = new UnidadeMedida();
                u.setDescricao( descricao );
                u.setSigla( sigla );

                dao.salvar( u );

                disp = request.getRequestDispatcher(
                        "/formularios/unidadesMedida/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String descricao = request.getParameter( "descricao" );
                String sigla = request.getParameter( "sigla" );

                UnidadeMedida u = new UnidadeMedida();
                u.setId( id );
                u.setDescricao( descricao );
                u.setSigla( sigla );

                dao.atualizar( u );

                disp = request.getRequestDispatcher(
                        "/formularios/unidadesMedida/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                UnidadeMedida u = new UnidadeMedida();
                u.setId( id );

                dao.excluir( u );

                disp = request.getRequestDispatcher(
                        "/formularios/unidadesMedida/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                UnidadeMedida u = dao.obterPorId( id );
                request.setAttribute( "un", u );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/unidadesMedida/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/unidadesMedida/excluir.jsp" );
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
        return "UnidadesMedidaServlet";
    }

}
