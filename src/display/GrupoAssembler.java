package display;

import domain.Grupo;

public class GrupoAssembler {
  public static GrupoDTO Create(Grupo grupo) {
    GrupoDTO dto = new GrupoDTO();
    dto.id = grupo.getId();
    dto.codigo = grupo.getCodigo();
    dto.nombre = grupo.getNombre();
    dto.horario = grupo.getHorario();
    dto.aula = grupo.getAula();
    dto.numero = grupo.getNumero();
	dto.profesor = grupo.getProfesor();
    return dto;
  }
}