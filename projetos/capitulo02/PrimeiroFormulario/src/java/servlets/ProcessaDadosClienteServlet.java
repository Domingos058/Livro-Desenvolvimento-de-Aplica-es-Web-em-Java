/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet( name = "ProcessaDadosClienteServlet", urlPatterns = { "/processaDadosCliente" } )
public class ProcessaDadosClienteServlet extends HttpServlet {

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
        
        /* Obtém os dados do request.
         * O método getParameter de request obtém
         * um parâmetro enviado pelo formulário
         * que acessou o Servlet.
         *
         * O parâmetro tem SEMPRE o mesmo nome configurado
         * na propriedade "name" do componente do formulário.
         */
        String nome = request.getParameter( "nome" );
        String sobrenome = request.getParameter( "sobrenome" );
        String CPF = request.getParameter( "cpf" );
        String dataNascimento = request.getParameter( "dataNasc" );
        String sexo = request.getParameter( "sexo" );
        String observacoes = request.getParameter( "observacoes" );

        System.out.println( "Dados do Cliente:" );
        System.out.println( "Nome: " + nome );
        System.out.println( "Sobrenome: " + sobrenome );
        System.out.println( "CPF: " + CPF );
        System.out.println( "Data de Nascimento: " + dataNascimento );

        System.out.print( "Sexo: " );
        if ( sexo.equals( "M" ) ) {
            System.out.println( "Masculino" );
        } else {
            System.out.println( "Feminino" );
        }

        System.out.println( "Observações: " + observacoes );
        
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
