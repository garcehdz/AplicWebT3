package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoRepository;
import domain.Grupo;

public class AgregarGrupo extends PageController {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
  
	GrupoRepository grupos = (GrupoRepository) context.getBean("grupoRepository");
    
	try {
		Grupo grupo = new Grupo();		
		Random generator = new Random();
		int id = generator.nextInt();
		
		String nombre = request.getParameter("nombre");
		String codigo = request.getParameter("codigo");
		String numero = request.getParameter("numero");
		String aula = request.getParameter("aula");
		String horario = request.getParameter("horario");
        String profesor = request.getParameter("profesor");

		grupo.setId(id);
		
		if (nombre!=null) grupo.setNombre(nombre);
		if (numero!=null) grupo.setNumero(numero);
		if (codigo!=null) grupo.setCodigo(codigo);
		if (aula!=null) grupo.setAula(aula);
		if (horario!=null) grupo.setHorario(horario);
		if (profesor!=null) grupo.setProfesor(profesor);
		
		grupos.insertGrupo(grupo);
		response.sendRedirect("ListaGrupos");
    } 
	
	catch (Exception e) {
		request.setAttribute("mensaje",e.getMessage());
		forward("/paginaError.jsp",request,response);
	}
  }
}