<%@ page import="java.util.*" %>
<%@ page import="display.*" %>

<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Nuevo Grupo</h2>
  <%GrupoDTO grupo = (GrupoDTO)request.getAttribute("grupo");%>
  <%List profesores = (List)request.getAttribute("profesores"); %>
  
  <form name="ActualizarGrupo" action="/universidad/ActualizarGrupo" method="get">
  <input type="hidden" name="id" value="<%= grupo.id %>"/>
  <table>
    <tr><td>Nombre:</td><td><input type="text" name="nombre" value="<%=grupo.nombre%>"/></td></tr>
    <tr><td>Codigo:</td><td><input type="text" name="codigo" value="<%=grupo.codigo%>"/></td></tr>
    <tr><td>Numero:</td><td><input type="text" name="numero" value="<%=grupo.numero%>"/></td></tr>
    <tr><td>Aula:</td><td><input type="text" name="aula" value="<%=grupo.aula%>"/></td></tr>
    <tr><td>Horario:</td><td><input type="text" name="horario" value="<%=grupo.horario%>"/></td></tr>
	<tr>
		<td>Profesor:</td>
		<td>
			<Select name="profesor">
				<% for(int i = 0, n = profesores.size(); i < n; i++) {
					ProfesorDTO prof = (ProfesorDTO) profesores.get(i);
					if(prof.cedula == grupo.profesor){%>
						<option value="<%=prof.cedula%>" selected><%=prof.nombre%></option>
					<%}else{%>
						<option value="<%=prof.cedula%>"><%=prof.nombre%></option>
					<%}%>
				<%}%>
			</select>
		</td>
	</tr>
    <tr><td></td><td><input type="submit" value="Actualizar"/></td></tr>
  </table>
	
  </table>
  </form>
</html>