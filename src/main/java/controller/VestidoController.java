
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Vestido;

import com.google.gson.Gson;
import connection.DBConnection;


public class VestidoController {
  
    public String listar(boolean filtrar, String filtro){
        Gson gson = new Gson();
        
        DBConnection con = new DBConnection();
        
        String sql = "Select * From Vestidos";
        
        if  (filtrar == true)  {
            sql += " where tipo LIKE '%" + filtro + "%' or color LIKE '%" + filtro + "%' or disenador LIKE '%" + filtro + "%' or anio_modelo LIKE '%" + filtro + "%' or precio LIKE '%" + filtro + "%'";
        }
        
        List<String> vestidos = new ArrayList<>();
        
         try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String color = rs.getString("color");
                String disenador = rs.getString("disenador");
                int cantidad = rs.getInt("cantidad");
                String  talla= rs.getString("talla");
                int anio_modelo = rs.getInt("anio_modelo");
                boolean novedad = rs.getBoolean("novedad");
                double precio = rs.getDouble("precio");
                
                Vestido vestido = new Vestido(id,tipo, color, disenador, cantidad, talla, anio_modelo,novedad,precio);
                vestidos.add(gson.toJson(vestido));
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
         
         return gson.toJson(vestidos);
    }
}
