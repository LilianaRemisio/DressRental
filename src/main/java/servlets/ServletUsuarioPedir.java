
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;
/**
 *
 * @author remis
 */
@WebServlet(name = "ServletUsuarioPedir", urlPatterns = {"/ServletUsuarioPedir"})

public class ServletUsuarioPedir extends HttpServlet {
    
    public ServletUsuarioPedir(){
        super();
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            UsuarioController usuario = new UsuarioController();
            String username = request.getParameter("username");
            String result = usuario.pedir(username);

            response.setContentType("text/html;charset-UTF-8");
            PrintWriter out = response.getWriter();
            out.println(result);
            out.flush();
            out.close();
        
        }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
