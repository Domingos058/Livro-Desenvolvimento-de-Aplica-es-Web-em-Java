/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package padroesempratica.entidades;

/**
 * Classe Pais.
 *
 * @author David Buzatto
 */
public class Pais {

    private int id;
    private String nome;
    private String sigla;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla( String sigla ) {
        this.sigla = sigla;
    }

}
