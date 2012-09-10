package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ProfesorRepository;
import domain.Profesor;

import domain.GrupoRepository;
import domain.Grupo;

public class DetalleGrupo extends PageController {

  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	GrupoRepository grupos = (GrupoRepository)context.getBean("grupoRepository");
	ProfesorRepository profesores = (ProfesorRepository) context.getBean("profesorRepository");
	
    try {
		Collection lista = profesores.findAllProfesor();
        List data = new ArrayList();
		Iterator itr = lista.iterator();
		
		while (itr.hasNext()) {
			Profesor prof = (Profesor)itr.next();
			ProfesorDTO dto = ProfesorAssembler.Create(prof);
			data.add(dto);
		}
	
		String id = request.getParameter("id");
		Grupo grupo = grupos.findGrupo(id);
		GrupoDTO dto = GrupoAssembler.Create(grupo);
		
		request.setAttribute("profesores",data);
		request.setAttribute("grupo",dto);
		forward("/detalleGrupo.jsp",request,response);
	} 
	
	catch (Exception e) {
		request.setAttribute("mensaje",e.getMessage());
		forward("/paginaError.jsp",request,response);
	}
  }
  
}