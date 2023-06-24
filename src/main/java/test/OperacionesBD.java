
package test;

import beans.Vestido;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {
    public static void main(String[] args) {
        //listarVestidos();
        actualizarVestidos(1,"Veraniego");
    }
    
    public static void actualizarVestidos(int id, String tipo){
        DBConnection con = new DBConnection();
        String Sql= "Update Vestidos SET tipo = '"  + tipo +  "' where id = " + id;
        
        try{
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(Sql);
        }catch(Exception ex){   
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
    }   

    public static void listarVestidos(){
        DBConnection con = new DBConnection();
        
        String Sql = "Select * from vestidos";
        
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(Sql); 
            
            while(rs.next()){
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String color = rs.getString("color");
                String disenador = rs.getString("disenador");
                int cantidad = rs.getInt("id");
                String talla = rs.getString("talla");
                int anio_modelo = rs.getInt("anio_modelo");
                boolean novedad =rs.getBoolean("novedad");
                double precio =rs.getDouble("precio");
                
                Vestido vestidos = new Vestido(id, tipo, color, disenador, cantidad, talla, anio_modelo, novedad,precio);
                System.out.println(vestidos.toString());
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
        
            
    }
}
