package ejemplos.servlet.curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/verSaludos")
public class VerSaludosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        // Obtener la lista de saludos desde el servlet MyServlet2
        List<String> listaSaludos = MyServlet2.getListaSaludos();

        // Pasar la lista de saludos a la página JSP
        request.setAttribute("listaSaludos", listaSaludos);

        // Redirigir a la página JSP de saludos
        request.getRequestDispatcher("/WEB-INF/views/verSaludos.jsp").forward(request, response);
    }
}
