
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.VestidoController;
/**
 *
 * @author remis
 */
@WebServlet(name = "ServletVestidoListar", urlPatterns = {"/ServletVestidoListar"})

public class ServletVestidoListar extends HttpServlet {
    public ServletVestidoListar(){
        super();
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            VestidoController vestido = new VestidoController();
            boolean filtrar = Boolean.parseBoolean(request.getParameter("filtrar"));
            String filtro = request.getParameter("filtro");
            String result = vestido.listar(filtrar,filtro);

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
