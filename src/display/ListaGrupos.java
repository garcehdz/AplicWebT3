package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoRepository;
import domain.Grupo;

public class ListaGrupos extends PageController {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	GrupoRepository grupos = (GrupoRepository) context.getBean("grupoRepository");
    
	try {
		Collection lista = grupos.findAllGrupo();
        List data = new ArrayList();
		Iterator itr = lista.iterator();
		
		while (itr.hasNext()) {
			Grupo gr = (Grupo)itr.next();
			GrupoDTO dto = GrupoAssembler.Create(gr);
			data.add(dto);
		}
      
		request.setAttribute("grupos",data);
		forward("/listaGrupos.jsp",request,response);
	} 
	
	catch (Exception e) {
		request.setAttribute("mensaje",e.getMessage());
		forward("/paginaError.jsp",request,response);
	}
  }
}