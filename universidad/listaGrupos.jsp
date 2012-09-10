<%@ page import="java.util.*" %>
<%@ page import="display.*" %>
<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Listado de profesores</h2>
  <% List grupos = (List)request.getAttribute("grupos"); %>
  <table>
    <tr><th>Nombre</th><th>Codigo</th><th>Numero</th><th>Aula</th><th>Horario</th><th>Acciones</th></tr>
    <% for(int i = 0, n = grupos.size(); i < n; i++) {
         GrupoDTO grupo = (GrupoDTO) grupos.get(i); %>
        <tr>
			<td><%= grupo.nombre%></td>
			<td><%= grupo.codigo%></td>
			<td><%= grupo.numero%></td>
			<td><%= grupo.aula%></td>
			<td><%= grupo.horario%></td>
			<td>
				<a href='/universidad/DetalleGrupo?id=<%= grupo.id %>'><input type="submit" value="Detalle"/></a>
				<a href='/universidad/EliminarGrupo?id=<%= grupo.id %>'><input type="submit" value="Eliminar"/></a>
			</td>
		</tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/universidad/NuevoGrupo'>
        <input type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>