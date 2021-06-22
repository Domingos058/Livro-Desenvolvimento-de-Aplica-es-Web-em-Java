/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroclientes.controladores;

import cadastroclientes.dao.ClienteDAO;
import cadastroclientes.entidades.Cidade;
import cadastroclientes.entidades.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para tratar Clientes.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet( name = "ClientesServlet", urlPatterns = { "/processaClientes" } )
public class ClientesServlet extends HttpServlet {

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
        
        String acao = request.getParameter( "acao" );
        ClienteDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new ClienteDAO();

            if ( acao.equals( "criar" ) ) {

                String nome = request.getParameter( "nome" );
                String sobrenome = request.getParameter( "sobrenome" );
                String dataNascimento = request.getParameter( "dataNascimento" );
                String cpf = request.getParameter( "cpf" );
                String email = request.getParameter( "email" );
                String logradouro = request.getParameter( "logradouro" );
                String numero = request.getParameter( "numero" );
                String bairro = request.getParameter( "bairro" );
                String cep = request.getParameter( "cep" );
                int idCidade = Integer.parseInt( request.getParameter( "idCidade" ) );

                Cidade ci = new Cidade();
                ci.setId( idCidade );

                Cliente c = new Cliente();
                c.setNome( nome );
                c.setSobrenome( sobrenome );
                c.setCpf( cpf );
                c.setEmail( email );
                c.setLogradouro( logradouro );
                c.setNumero( numero );
                c.setBairro( bairro );
                c.setCep( cep );
                c.setCidade( ci );

                SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );

                try {
                    java.util.Date data = sdf.parse( dataNascimento );
                    c.setDataNascimento( new java.sql.Date( data.getTime() ) );
                } catch ( ParseException exc ) {
                    
                }

                dao.salvar( c );

                disp = request.getRequestDispatcher(
                        "/formularios/clientes/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                String nome = request.getParameter( "nome" );
                String sobrenome = request.getParameter( "sobrenome" );
                String dataNascimento = request.getParameter( "dataNascimento" );
                String cpf = request.getParameter( "cpf" );
                String email = request.getParameter( "email" );
                String logradouro = request.getParameter( "logradouro" );
                String numero = request.getParameter( "numero" );
                String bairro = request.getParameter( "bairro" );
                String cep = request.getParameter( "cep" );
                int idCidade = Integer.parseInt( request.getParameter( "idCidade" ) );

                Cidade ci = new Cidade();
                ci.setId( idCidade );

                Cliente c = new Cliente();
                c.setId( id );
                c.setNome( nome );
                c.setSobrenome( sobrenome );
                c.setCpf( cpf );
                c.setEmail( email );
                c.setLogradouro( logradouro );
                c.setNumero( numero );
                c.setBairro( bairro );
                c.setCep( cep );
                c.setCidade( ci );

                SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );

                try {
                    java.util.Date data = sdf.parse( dataNascimento );
                    c.setDataNascimento( new java.sql.Date( data.getTime() ) );
                } catch ( ParseException exc ) {

                }

                dao.atualizar( c );

                disp = request.getRequestDispatcher(
                        "/formularios/clientes/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );

                Cliente c = new Cliente();
                c.setId( id );

                dao.excluir( c );

                disp = request.getRequestDispatcher(
                        "/formularios/clientes/listagem.jsp" );

            } else if ( acao.equals( "prepAlteracao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Cliente c = dao.obterPorId( id );
                request.setAttribute( "cliente", c );

                disp = request.getRequestDispatcher(
                        "/formularios/clientes/alterar.jsp" );

            } else if ( acao.equals( "prepExclusao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Cliente c = dao.obterPorId( id );
                request.setAttribute( "cliente", c );

                disp = request.getRequestDispatcher(
                        "/formularios/clientes/excluir.jsp" );

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
