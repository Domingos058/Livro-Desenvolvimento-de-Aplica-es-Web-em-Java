/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet( name = "ProcessaDadosProdutoServlet", urlPatterns = { "/processaDadosProduto" } )
public class ProcessaDadosProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        
        // obtém os dados do formulário
        int codigo = 0;
        int quantidade = 0;

        String descricao = request.getParameter( "descricao" );
        String unidadeMedida = request.getParameter( "unidade" );

        try {
            codigo = Integer.parseInt( request.getParameter( "codigo" ) );
        } catch ( NumberFormatException exc ) {
            System.out.println( "Erro ao converter o código." );
        }

        try {
            quantidade = Integer.parseInt( request.getParameter( "quantidade" ) );
        } catch ( NumberFormatException exc ) {
            System.out.println( "Erro ao converter a quantidade." );
        }

        // cria um novo produto e configura suas propriedades
        // usando os dados obtidos do formulário
        Produto prod = new Produto();
        prod.setCodigo( codigo );
        prod.setDescricao( descricao );
        prod.setUnidadeMedida( unidadeMedida );
        prod.setQuantidade( quantidade );

        // configura um atributo no request chamado "produtoObtido"
        // sendo que o valor do atributo é o objeto "prod"
        request.setAttribute( "produtoObtido", prod );

        // prepara um RequestDispatcher para direcionar para a págine
        // "exisbeDados.jsp" que está no mesmo diretório em relação
        // ao mapeamento deste Servlet
        RequestDispatcher disp = request.getRequestDispatcher( "exibeDados.jsp" );

        // faz o direcionamento, chamando o método forward.
        disp.forward( request, response );
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
