package ejemplos.servlet.curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/myServlet2")
public class MyServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Obtener el nombre y el sexo enviados desde el formulario
		String nombre = request.getParameter("nombre");
		String sexo = request.getParameter("sexo");

		// Generar el mensaje de bienvenida según el sexo
		String saludo;
		if ("mujer".equalsIgnoreCase(sexo)) {
			saludo = "Bienvenida";
		} else if ("hombre".equalsIgnoreCase(sexo)) {
			saludo = "Bienvenido";
		} else {
			saludo = "Bienvenid@";
		}

		// Enviar página HTML con el saludo personalizado
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Bienvenida</title></head>");
		out.println("<body>");
		out.println("<h1>" + saludo + " " + nombre + "!</h1>");
		out.println("</body></html>");

		// Cerrar PrintWriter
		out.close();
	}
}

/*
@WebServlet(urlPatterns = "/myServlet2")
public class MyServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// send HTML page to client
		out.println("<html>");
		out.println("<head><title>Ejemplo HTML desde Servlet</title></head>");
		out.println("<body>");
		out.println("<h1>Bienvenido!!</h1>");
	}

}*/
