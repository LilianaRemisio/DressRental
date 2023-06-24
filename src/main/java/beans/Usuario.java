
package beans;

public class Usuario {
    private String username;
    private String contrasena;
    private String nombres;
    private String apellidos;
    private String email;
    private boolean premium;
    private double saldo;

    public Usuario(String username, String contrasena, String nombres, String apellidos, String email, boolean premium, double saldo) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.premium = premium;
        this.saldo = saldo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "username=" + username + ", contrasena=" + contrasena + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", premium=" + premium + ", saldo=" + saldo + '}';
    }
    
    
}
