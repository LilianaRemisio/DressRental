
package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {
    
    @Override
    public String login(String username, String contrasena){
        Gson gson = new Gson();
        
        DBConnection con = new DBConnection();
        
        String sql = "Select * From Usuarios where username = '" + username 
                + "' and contrasena = '" + contrasena + "'";
        
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                Double saldo = rs.getDouble("saldo");
                boolean premium = rs.getBoolean("premium");
                
                Usuario usuario = new Usuario(username, contrasena, nombres, apellidos, email, premium, saldo);
                return gson.toJson(usuario);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
        
        return "false";
    }
    
    @Override
    public String register(String username, String contrasena, String nombres, String apellidos, 
            String email, boolean premium, double saldo){
        
        Gson gson = new Gson();        
        DBConnection con = new DBConnection();
        
        String sql = "INSERT INTO usuarios VALUES ('" + username + "', '" + contrasena + "', '" + nombres + "',"
                + "'" + apellidos + "', '" + email + "', " + premium + ", " + saldo + ")";
        
        try{
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, contrasena, nombres, apellidos, email, premium, saldo);
           
            st.close();
            return gson.toJson(usuario);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
        
        return "false";
    }
    
    @Override
    public String pedir(String username){
        Gson gson = new Gson();        
        DBConnection con = new DBConnection();
        
        
         String sql = "Select * From Usuarios where username = '" + username +"'";
        
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String contrasena = rs.getString("contrasena");
                Double saldo = rs.getDouble("saldo");
                boolean premium = rs.getBoolean("premium");
                
                Usuario usuario = new Usuario(username, contrasena, nombres, apellidos, email, premium, saldo);
                return gson.toJson(usuario);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
        
        return "false";
    }
}
