package interfaces;


import funcionarios.Funcionario;
import java.sql.SQLException;

//METODOS ABSTRACTOS 
public interface DAOFuncionario {
    public void registrar(Funcionario funcionario) throws SQLException;
    public void actualizar(Funcionario funcionario) throws SQLException;
    public void buscar(Funcionario funcionario) throws SQLException;
    public void eliminar(Funcionario funcionario) throws SQLException;
}
