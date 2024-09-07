package ejemplos.servlet.curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = "/myServlet2")
public class MyServlet2 extends HttpServlet {

	// Lista estática para almacenar los saludos
	private static List<String> listaSaludos = new ArrayList<>();

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {

		// Obtener el nombre y el sexo enviados desde el formulario
		String nombre = request.getParameter("nombre");
		String sexo = request.getParameter("sexo");
		String accion = request.getParameter("accion");

		// Generar el saludo según el sexo
		String saludo;
		if ("mujer".equalsIgnoreCase(sexo)) {
			saludo = "Bienvenida";
		} else if ("hombre".equalsIgnoreCase(sexo)) {
			saludo = "Bienvenido";
		} else {
			saludo = "Bienvenid@";
		}

		// Si la acción solicitada es un mensaje divertido
		if ("divertido".equalsIgnoreCase(accion)) {
			saludo = generarMensajeDivertido(nombre);
		}

		// Formar el saludo completo con el nombre
		String saludoCompleto = saludo + " " + nombre + "!";

		// Almacenar el saludo en la lista
		listaSaludos.add(saludoCompleto);

		// Pasar los datos a la página JSP
		request.setAttribute("nombre", nombre);
		request.setAttribute("saludo", saludoCompleto);

		// Redirigir a la página JSP de bienvenida
		request.getRequestDispatcher("/WEB-INF/views/bienvenida.jsp").forward(request, response);
	}

	// Método para generar un mensaje divertido
	private String generarMensajeDivertido(String nombre) {
		// Lista de frases divertidas
		List<String> frasesDivertidas = Arrays.asList(
				"¡Eres una estrella, %s! 🌟",
				"¡Hoy es tu día de suerte! 🍀",
				"¡Sigue brillando! ✨",
				"¡El mundo es tuyo! 🌍",
				"¡Wow! ¡Estás a punto de conquistar el universo! 🚀"
		);

		// Elegir una frase aleatoria
		Random random = new Random();
		String fraseElegida = frasesDivertidas.get(random.nextInt(frasesDivertidas.size()));

		// Devolver la frase divertida con el nombre integrado
		return String.format(fraseElegida, nombre);
	}

	// Método para devolver la lista de saludos
	public static List<String> getListaSaludos() {
		return listaSaludos;
	}
}

/*package ejemplos.servlet.curso;

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
}*/

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
