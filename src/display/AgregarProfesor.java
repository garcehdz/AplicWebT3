package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ProfesorRepository;
import domain.Profesor;

public class AgregarProfesor extends PageController {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
  
	ProfesorRepository profesores = (ProfesorRepository) context.getBean("profesorRepository");
    
	try {
		//String id = request.getParameter("id");
		//int idProf = Integer.parseInt(id);
		
		Profesor prof = new Profesor();		
		Random generator = new Random();
		int id = generator.nextInt();
		
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String titulo = request.getParameter("titulo");
        String area = request.getParameter("area");
        String telefono = request.getParameter("telefono");
        
		prof.setId(id);
		
		if (cedula!=null) prof.setCedula(cedula);
		if (nombre!=null) prof.setNombre(nombre);
		if (titulo!=null) prof.setTitulo(titulo);
		if (area!=null) prof.setArea(area);
		if (telefono!=null) prof.setTelefono(telefono);
		
		profesores.insertProfesor(prof);
		response.sendRedirect("listaProfesores");
    } 
	
	catch (Exception e) {
		request.setAttribute("mensaje",e.getMessage());
		forward("/paginaError.jsp",request,response);
	}
  }
}