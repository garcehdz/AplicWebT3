<%@ page import="java.util.*" %>
<%@ page import="display.*" %>

<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Detalle de Profesor</h2>
  <% ProfesorDTO prof = (ProfesorDTO)request.getAttribute("profesor"); %>
  <% List grupos = (List)request.getAttribute("grupos"); %>
  <form name="ActualizarProfesor"
        action="/universidad/actualizarProfesor" method="get">
  <input type="hidden" name="id" value="<%= prof.id %>"/>
  <table>
    <tr><td>Nombre:</td><td><input type="text" name="nombre" value="<%= prof.nombre %>"/></td></tr>
    <tr><td>C&eacute;dula:</td><td><input type="text" name="cedula" value="<%= prof.cedula %>"/></td></tr>
    <tr><td>T&iacute;tulo:</td><td><input type="text" name="titulo" value="<%= prof.titulo %>"/></td></tr>
    <tr><td>Area:</td><td><input type="text" name="area" value="<%= prof.area %>"/></td></tr>
    <tr><td>Tel&eacute;fono:</td><td><input type="text" name="telefono" value="<%= prof.telefono %>"/></td></tr>
    <tr><td></td><td><input type="submit" value="Actualizar" /></td></tr>
  </table>
  <h2>Grupos del Profesor</h2>
  <table>
	<tr><th>Codigo</th><th>Nombre</th><th>Numero</th><th>Horario</th><th>Acciones</th></tr>
	<% for(int i = 0, n = grupos.size(); i < n; i++) {
         GrupoDTO grupo = (GrupoDTO)grupos.get(i); %>
        <tr>
			<td><%= grupo.codigo%></td>
			<td><%= grupo.nombre%></td>
			<td><%= grupo.numero%></td>
			<td><%= grupo.horario%></td>
			<td>
				<a href='/universidad/DetalleGrupo?id=<%= grupo.id %>'><input type="submit" value="Detalle"/></a>
				<a href='/universidad/EliminarGrupo?id=<%= grupo.id %>'><input type="submit" value="Eliminar"/></a>
			</td>
		</tr>
    <% } %>
	
	
  </table>
  </form>
</html>