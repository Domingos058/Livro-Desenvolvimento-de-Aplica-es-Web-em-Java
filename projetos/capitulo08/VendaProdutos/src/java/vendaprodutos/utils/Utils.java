/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaprodutos.utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Classe de métodos utilitários.
 * 
 * @author Prof. Dr. David Buzatto
 */
public abstract class Utils {
    
    // tanto o validador quanto o formatador
    // são thread safe
    private static Validator validador = Validation
            .buildDefaultValidatorFactory()
            .getValidator();
    
    private static DateTimeFormatter dtf = DateTimeFormatter
            .ofPattern( "yyyy-MM-dd" );
    
    /*
     * Lê um parâmetro Long do request.
     * Se a String for inválida, retorna null.
     */
    public static Long getLong( 
            HttpServletRequest request,
            String nomeParametro ) {
        
        Long v = null;
        
        try {
            v = Long.valueOf( request.getParameter( nomeParametro ) );
        } catch ( NumberFormatException exc ) {
        }
        
        return v;
        
    }
    
    /*
     * Converte uma String para Long.
     * Se a String for inválida, retorna null.
     */
    public static Long getLong( String valor ) {
        
        Long v = null;
        
        try {
            v = Long.valueOf( valor );
        } catch ( NumberFormatException exc ) {
        }
        
        return v;
        
    }
    
    /*
     * Converte uma String no formato dd/MM/yyyy
     * para um java.sql.Date.
     *
     * Se a String for inválida, retorna null.
     */
    public static Date getDate( String data ) {
        
        Date d = null;
        
        try {
            d = Date.valueOf( LocalDate.parse( data, dtf ) );
        } catch ( DateTimeParseException exc ) {
        }
        
        return d;
        
    }
    
    /*
     * Faz a leitura da chave primária após inserção no banco.
     * Assume que  o PreparedStatement foi configurado apropriadamente.
     */
    public static Long getChavePrimariaAposInsercao( 
            PreparedStatement stmt, String nomeColunaChave ) 
            throws SQLException {
        
        Long pk = null;
        
        try ( ResultSet rsPK = stmt.getGeneratedKeys() ) {
            if ( rsPK.next() ) {
                pk = rsPK.getLong( nomeColunaChave );
            }
        }
        
        return pk;
        
    }
    
    /*
     * Realiza a validação e retorna um conjunto de violações de
     * restrições.
     *
     * Não insere no retorno os campos que devem ser ignorados.
     */
    public static <T> Set<ConstraintViolation<T>> validar( 
            T obj,
            String... ignorar ) {
        
        // uma lista dos campos à ignorar
        List<String> ignorarCampos = Arrays.<String>asList( ignorar );
        
        // conjunto que conterá todas as violações de restrição
        // que tenham caminho da propriedade igual
        // à alguma da lista de ignorar
        Set<ConstraintViolation<T>> cvs = new LinkedHashSet<>();
        
        // valida e percorre todas as restrições
        // violadas
        for ( ConstraintViolation<T> cv : validador.validate( obj ) ) {
            
            // se a lista de campos à ignorar não tiver
            // o caminho da propriedade
            if ( !ignorarCampos.contains( 
                    cv.getPropertyPath().toString() ) ) {
                cvs.add( cv );
            }
        }
        
        return cvs;
        
    }
    
    /*
     * Gera a mensagem de erro para a validação das entidades.
     * Retorna null se não houve erro.
     */
    public static <T> String validarGerarMensagem(
            T obj,
            String... ignorar ) {
        
        StringBuilder sb = new StringBuilder();
        Set<ConstraintViolation<T>> cvs = Utils.<T>validar( obj, ignorar );
        
        if ( cvs.size() != 0 ) {
            
            for ( ConstraintViolation<T> cv : cvs ) {
                sb.append( String.format( 
                        "<li>%s: %s</li>", 
                        cv.getPropertyPath(), 
                        cv.getMessage() ) );
            }
            
            return sb.toString();
            
        }
        
        return null;
        
    }
    
    /**
     * Prepara o despacho para a página de erro de aplicação.
     */
    public static RequestDispatcher prepararDespachoErro( 
            HttpServletRequest request,
            String mensagem ) {
        
        // "Referer" é de onde veio a requisição
        request.setAttribute( "mensagemErro", mensagem );
        request.setAttribute( "voltarPara", request.getHeader( "Referer" ) );
        
        return request.getRequestDispatcher( "/erro.jsp" );
        
    }
    
}
