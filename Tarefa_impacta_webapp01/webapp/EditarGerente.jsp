<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Editar Gerente</title>
</head>
<body>
<%@page import="com.atos.impacta.repositories.RepositorioGerente,com.atos.impacta.model.*,java.util.*"%>
<%  
RepositorioGerente repo = new RepositorioGerente();
String cpf=request.getParameter("cpf");  
Gerente gerente=repo.listarGerenteByCpfDb(cpf);    
%>  
<form>
<table>
 <tr><td>NOME :</td><td><input type="text" name="nome" value="<%=gerente.getNome()%>"></input></td></tr>
 <tr><td>CPF :</td><td><input type="text" name="cpf" value="<%=gerente.getCpf()%>"></input></td></tr>
 <tr><td>SALARIO :</td><td><input type="text" name="salario" value="<%=gerente.getSalario()%>"></input></td></tr>
 <tr><td>REGIONAL :</td><td><input type="text" name="regional" value="<%=gerente.getRegional()%>"></input></td></tr>
 <tr><td>META REGIONAL :</td><td><input type="text" name="metaregional" value="<%=gerente.getMetaRegional()%>"></input></td></tr>
 <tr><td colspan="2"><input type="submit"></input></td></tr>
</table>
</form>
</body>
</html>