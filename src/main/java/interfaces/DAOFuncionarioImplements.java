/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dao.Conexion;
import funcionarios.Funcionario;
import java.sql.*;


//DEFINICIÓN DEL COMPORTAMIENTO DE LOS METODOS ABSTRACTOS
public class DAOFuncionarioImplements implements DAOFuncionario {
    
    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionario (id, telefono, nombres, apellidos, numero_identificacion, direccion, sexo, tipo_identificacion,"
            + "estado_civil, fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionario WHERE id = ?";
    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionario SET nombres = ?, numero_identificacion = ?, apellidos = ?,"
            + " fecha_nacimiento = ?, tipo_identificacion =?, estado_civil = ?, direccion = ?, telefono = ?, sexo = ? WHERE id = ?";
    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionario WHERE id = ?";


    @Override
    public void registrar(Funcionario funcionario) throws SQLException {
        Connection conexion = null;
        PreparedStatement insertar = null;
        try{
        conexion = Conexion.getConnection();
        insertar = conexion.prepareStatement(CREATE_FUNCIONARIO);
        insertar.setInt(1, funcionario.getId());
        insertar.setInt(2, funcionario.getTelefono());
        insertar.setString(3, funcionario.getNombres());
        insertar.setString(4, funcionario.getApellidos());
        insertar.setInt(5, funcionario.getNumero_identificacion());
        insertar.setString(6, funcionario.getDireccion());
        insertar.setString(7, funcionario.getSexo());
        insertar.setString(8, funcionario.getTipo_identificacion());
        insertar.setString(9, funcionario.getEstado_civil());
        insertar.setString(10, funcionario.getFecha_nacimiento());
        
        
        
        
        
        
        insertar.executeUpdate();
        }
        finally{
            if(conexion != null){
                conexion.close();
            }
            if(insertar != null){
                insertar.close();
            }
        }
}

    @Override
    public void actualizar(Funcionario funcionario) throws SQLException {
        Connection conexion = null;
        PreparedStatement update = null;  
        
        try{
        conexion = Conexion.getConnection();
        update = conexion.prepareStatement(UPDATE_FUNCIONARIO);
        update.setString(1, funcionario.getNombres());
        update.setInt(2, funcionario.getNumero_identificacion());
        update.setString(3, funcionario.getApellidos());        
        update.setString(4, funcionario.getFecha_nacimiento());
        update.setString(5, funcionario.getTipo_identificacion());
        update.setString(6, funcionario.getEstado_civil());
        update.setString(7, funcionario.getDireccion());
        update.setInt(8, funcionario.getTelefono());
        update.setString(9, funcionario.getSexo());
        update.setInt(10, funcionario.getId());
        update.executeUpdate();
        }
        finally{
            if(conexion != null){
                conexion.close();
            }
            if(update != null){
                update.close();
            }
        }
    }
    
    

    @Override
    public void buscar(Funcionario funcionario) throws SQLException {
        Connection conexion = null;
        PreparedStatement buscar = null;
        ResultSet consulta = null;
        
        try{
        conexion = Conexion.getConnection();
        buscar = conexion.prepareStatement(GET_FUNCIONARIO_BY_ID);
        buscar.setInt(1, funcionario.getId());
        consulta = buscar.executeQuery();
        
        if(consulta.next()){
            funcionario.setId(Integer.parseInt(consulta.getString("id")));
            funcionario.setNombres(consulta.getString("nombres"));
            funcionario.setApellidos(consulta.getString("apellidos"));
            funcionario.setNumero_identificacion(Integer.parseInt(consulta.getString("numero_identificacion")));
            funcionario.setFecha_nacimiento(consulta.getString("fecha_nacimiento"));
            funcionario.setTipo_identificacion(consulta.getString("tipo_identificacion"));
            funcionario.setEstado_civil(consulta.getString("estado_civil"));
            funcionario.setDireccion(consulta.getString("direccion"));
            funcionario.setTelefono(Integer.parseInt(consulta.getString("telefono")));
            funcionario.setSexo(consulta.getString("sexo"));
            }
        }
        finally{
            if(conexion != null){
                conexion.close();
            }
            if(buscar != null){
                buscar.close();
            }
            if(consulta != null){
                consulta.close();
            }
        }

    }

    @Override
    public void eliminar(Funcionario funcionario) throws SQLException {
        Connection conexion = null;
        PreparedStatement eliminar = null;
        
        try{
        conexion = Conexion.getConnection();
        eliminar = conexion.prepareCall(DELETE_FUNCIONARIO);
        eliminar.setInt(1, funcionario.getId());
        eliminar.executeUpdate();
        
        }finally{
            if(conexion != null){
                conexion.close();
            }
            if(eliminar != null){
                eliminar.close();
            }
        }
    }

}


 
   

