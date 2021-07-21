package vendaprodutos.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vendaprodutos.dao.ProdutoDAO;
import vendaprodutos.entidades.Fornecedor;
import vendaprodutos.entidades.Produto;
import vendaprodutos.entidades.UnidadeMedida;

/**
 * Servlet para tratar Produtos.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet( name = "ProdutosServlet", 
             urlPatterns = { "/processaProdutos" } )
public class ProdutosServlet extends HttpServlet {

    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        
        ProdutoDAO dao = null;
        RequestDispatcher disp = null;
        
        try {

            dao = new ProdutoDAO();

            if ( acao.equals( "inserir" ) ) {

                String descricao = request.getParameter( "descricao" );
                String codigoBarras = request.getParameter( "codigoBarras" );
                BigDecimal valorVenda = new BigDecimal( 
                        request.getParameter( "valorVenda" ) );
                BigDecimal estoque = new BigDecimal( 
                        request.getParameter( "estoque" ) );
                int idFornecedor = Integer.parseInt( 
                        request.getParameter( "idFornecedor" ) );
                int idUnidadeMedida = Integer.parseInt( 
                        request.getParameter( "idUnidadeMedida" ) );

                Fornecedor f = new Fornecedor();
                f.setId( idFornecedor );
                
                UnidadeMedida u = new UnidadeMedida();
                u.setId( idUnidadeMedida );

                Produto p = new Produto();
                p.setDescricao( descricao );
                p.setCodigoBarras( codigoBarras );
                p.setValorVenda( valorVenda );
                p.setEstoque( estoque );
                p.setFornecedor( f );
                p.setUnidadeMedida( u );

                dao.salvar( p );

                disp = request.getRequestDispatcher(
                        "/formularios/produtos/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String descricao = request.getParameter( "descricao" );
                String codigoBarras = request.getParameter( "codigoBarras" );
                BigDecimal valorVenda = new BigDecimal( 
                        request.getParameter( "valorVenda" ) );
                BigDecimal estoque = new BigDecimal( 
                        request.getParameter( "estoque" ) );
                int idFornecedor = Integer.parseInt( 
                        request.getParameter( "idFornecedor" ) );
                int idUnidadeMedida = Integer.parseInt( 
                        request.getParameter( "idUnidadeMedida" ) );

                Fornecedor f = new Fornecedor();
                f.setId( idFornecedor );
                
                UnidadeMedida u = new UnidadeMedida();
                u.setId( idUnidadeMedida );

                Produto p = new Produto();
                p.setId( id );
                p.setDescricao( descricao );
                p.setCodigoBarras( codigoBarras );
                p.setValorVenda( valorVenda );
                p.setEstoque( estoque );
                p.setFornecedor( f );
                p.setUnidadeMedida( u );

                dao.atualizar( p );

                disp = request.getRequestDispatcher(
                        "/formularios/produtos/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                Produto p = new Produto();
                p.setId( id );

                dao.excluir( p );

                disp = request.getRequestDispatcher(
                        "/formularios/produtos/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Produto p = dao.obterPorId( id );
                request.setAttribute( "produto", p );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/produtos/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/produtos/excluir.jsp" );
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
        return "ProdutosServlet";
    }

}
