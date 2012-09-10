package domain;
import java.util.*;

public class GrupoRepository {
  private Map<String,Grupo> grupos;

  GrupoRepository() {
    grupos = new HashMap<String,Grupo>();
  }
  
  public boolean insertGrupo(Grupo grupo) {
    if (grupos.containsKey(grupo.getId()))
      return false;
    else
      grupos.put(grupo.getId()+"",grupo);
    return true;
  }
  
  public boolean deleteGrupo(Grupo grupo) {
    if (!grupos.containsKey(grupo.getId()+""))
      return false;
    else
      grupos.remove(grupo.getId()+"");
    return true;
  }
  
  public Grupo findGrupo(String id) {
    if (!grupos.containsKey(id))
      return null;
    else
      return grupos.get(id);
  }
  
  public boolean updateGrupo(Grupo grupo) {
    if (!grupos.containsKey(grupo.getId()+""))
      return false;
    else
      grupos.put(grupo.getId()+"",grupo);
    return true;
  }
  
  public Collection findAllGrupo() {
    return grupos.values();
  }
  
  public Collection findGruposProfesor(String idProfesor){
	Map<String,Grupo> gruposProfe = new HashMap<String,Grupo>();
	
	for(Grupo grupo : grupos.values()){
		if(grupo.getProfesor() == idProfesor)
			gruposProfe.put(grupo.getId()+"",grupo);
	}
 
	return gruposProfe.values();
  }
  
  public void setGrupos(Map grupos) {
    this.grupos = grupos;
  }
}