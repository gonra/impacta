<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista Gerentes</title>
</head>
<body>
<%@page import="com.atos.impacta.repositories.*,com.atos.impacta.model.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
RepositorioGerente repo = new RepositorioGerente();
List<Gerente> list=repo.listarDB();  
request.setAttribute("list",list);  
%>  
<div>
<table border="1" width="90%">  
<tr>
 <th>Id</th>
 <th>Nome</th>
 <th>CPF</th>
 <th>Salario</th>  
 <th>Regional</th>
 <th>MetaRegional</th>
 <th></th>
 <th></th>
</tr>  
<c:forEach items="${list}" var="u">  
<tr>
 <td>${u.getId()}</td>
 <td>${u.getNome()}</td>
 <td>${u.getCpf()}</td>  
 <td>${u.getSalario()}</td>
 <td>${u.getRegional()}</td>
 <td>${u.getMetaRegional()}</td>  
 <td><a href="EditarGerente.jsp?cpf=${u.getCpf()}">Editar</a></td>  
 <td><a href="DeletarGerente.jsp?cpf=${u.getCpf()}">Deletar</a></td></tr>  
</c:forEach>  
</table>
</div>  
</body>
</html>