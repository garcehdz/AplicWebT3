<%@ page import="java.util.*" %>
<%@ page import="display.*" %>

<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Nuevo Grupo</h2>
  <% List profesores = (List)request.getAttribute("profesores"); %>
  
  <form name="RegistrarGrupo" action="/universidad/AgregarGrupo" method="get">
  
  <table>
    <tr><td>Nombre:</td><td><input type="text" name="nombre" value=""/></td></tr>
    <tr><td>Codigo:</td><td><input type="text" name="codigo" value=""/></td></tr>
    <tr><td>Numero:</td><td><input type="text" name="numero" value=""/></td></tr>
    <tr><td>Aula:</td><td><input type="text" name="aula" value=""/></td></tr>
    <tr><td>Horario:</td><td><input type="text" name="horario" value=""/></td></tr>
	<tr>
		<td>Profesor:</td>
		<td>
			<Select name="profesor">
				<% for(int i = 0, n = profesores.size(); i < n; i++) {
					ProfesorDTO prof = (ProfesorDTO) profesores.get(i);%>
					<option value="<%=prof.cedula%>"><%=prof.nombre%></option>
				<%}%>
			</select>
		</td>
	</tr>
    <tr><td></td><td><input type="submit" value="Agregar" /></td></tr>
  </table>
	
  </table>
  </form>
</html>