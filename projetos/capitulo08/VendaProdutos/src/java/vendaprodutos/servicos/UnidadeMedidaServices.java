package vendaprodutos.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vendaprodutos.dao.UnidadeMedidaDAO;
import vendaprodutos.entidades.UnidadeMedida;

/**
 * Classe de serviços para a entidade UnidadeMedida.
 *
 * @author Prof. Dr. David Buzatto
 */
public class UnidadeMedidaServices {

    /**
     * Usa o UnidadeMedidaDAO para obter todos as unidades
     * de medida.
     *
     * @return Lista de Unidades de Medida.
     */
    public List<UnidadeMedida> getTodos() {

        List<UnidadeMedida> lista = new ArrayList<>();
        UnidadeMedidaDAO dao = null;

        try {
            dao = new UnidadeMedidaDAO();
            lista = dao.listarTodos();
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

        return lista;

    }

}
