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

public class DetalleProfesor extends PageController {

  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	ProfesorRepository profesores = (ProfesorRepository) context.getBean("profesorRepository");
	GrupoRepository grupos = (GrupoRepository)context.getBean("grupoRepository");
	
    try {
		String id = request.getParameter("id");
		int idProf = Integer.parseInt(id);
		
		Profesor prof = profesores.findProfesor(idProf+"");
		ProfesorDTO dto = ProfesorAssembler.Create(prof);
		
		request.setAttribute("profesor",dto);
		request.setAttribute("grupos", obtenerGruposProfe(grupos, dto.cedula));
		forward("/detalleProfesor.jsp",request,response);
	} 
	
	catch (Exception e) {
		request.setAttribute("mensaje",e.getMessage());
		forward("/paginaError.jsp",request,response);
	}
  }
  
  public List<GrupoDTO> obtenerGruposProfe(GrupoRepository grupos, String idProfesor){
	Collection lista = grupos.findGruposProfesor(idProfesor);
	List gruposObtener = new ArrayList();
	Iterator itr = lista.iterator();
	
	while (itr.hasNext()) {
		Grupo grupoActual = (Grupo)itr.next();
		GrupoDTO dto = GrupoAssembler.Create(grupoActual);
		gruposObtener.add(dto);
	}
	
	return gruposObtener;
  }
  
}