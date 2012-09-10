package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoRepository;
import domain.Grupo;

public class EliminarGrupo extends PageController {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
  
	GrupoRepository grupos = (GrupoRepository) context.getBean("grupoRepository");
    
	try {
		String id = request.getParameter("id");
		int idGrupo = Integer.parseInt(id);
		
		Grupo grupo = new Grupo();		
		grupo.setId(idGrupo);

		grupos.deleteGrupo(grupo);
		response.sendRedirect("ListaGrupos");
    } 
	
	catch (Exception e) {
		request.setAttribute("mensaje",e.getMessage());
		forward("/paginaError.jsp",request,response);
	}
  }
}