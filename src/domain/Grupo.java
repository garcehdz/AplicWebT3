package domain;

public class Grupo {
  private int id;
  private String nombre;
  private String numero;
  private String codigo;
  private String aula;
  private String horario;
  private String profesor;

  public Grupo () {};
  public void setId(int id) {this.id=id;}
  public void setNombre(String nombre) {this.nombre=nombre;}
  public void setNumero(String numero) {this.numero=numero;}
  public void setCodigo(String codigo) {this.codigo=codigo;}
  public void setAula(String aula) {this.aula=aula;}
  public void setHorario(String horario) {this.horario=horario;}
  public void setProfesor(String profesor) {this.profesor=profesor;}
  
  public int getId() {return id;}
  public String getProfesor() {return profesor;}
  public String getNombre() {return nombre;}
  public String getNumero() {return numero;}
  public String getCodigo() {return codigo;}
  public String getAula() {return aula;}
  public String getHorario() {return horario;}
}	