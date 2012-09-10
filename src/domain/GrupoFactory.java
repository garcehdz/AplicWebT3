package domain;

public class GrupoFactory {
  public Grupo Create(int id,String nombre,String numero,String codigo,String aula,String horario, String idProfesor) {
    try {
      Grupo grupo = new Grupo();
      grupo.setId(id);
      grupo.setNombre(nombre);
	  grupo.setNumero(numero);
      grupo.setCodigo(codigo);
      grupo.setAula(aula);
      grupo.setHorario(horario);
	  grupo.setProfesor(idProfesor);
      return grupo;
    } catch (Exception e) {
      return null;
    }
  }
}