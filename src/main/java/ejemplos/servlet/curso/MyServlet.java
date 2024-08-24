package ejemplos.servlet.curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Enviar página HTML con un formulario al cliente
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Formulario de Bienvenida</title></head>");
		out.println("<body>");
		out.println("<h1>Introduce tus datos</h1>");
		out.println("<form action=\"/myServlet2\" method=\"POST\">");
		out.println("Nombre: <input type=\"text\" name=\"nombre\" required><br><br>");
		out.println("Sexo: ");
		out.println("<select name=\"sexo\" required>");
		out.println("<option value=\"hombre\">Hombre</option>");
		out.println("<option value=\"mujer\">Mujer</option>");
		out.println("<option value=\"otr@\">prefiero no decirlo</option>");
		out.println("</select><br><br>");
		out.println("<input type=\"submit\" value=\"Enviar\">");
		out.println("</form>");
		out.println("</body></html>");

		// Cerrar PrintWriter
		out.close();
	}
}

/*
@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// send HTML page to client
		out.println("<html>");
		out.println("<head><title>Ejemplo HTML desde Servlet</title></head>");
		out.println("<body>");
		out.println("<h1>Ejemplo Servlet</h1>");
		out.println("<p>Este es un ejemplo en el curso de Java para generar HTML desde un Servlet.</p>");
		out.println("<p><a href=\"/myServlet2\">Vamos al otro Servlet</a></p>");
		out.println("</body></html>");
	}

}*/
