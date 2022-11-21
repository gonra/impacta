<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Resultado</title>
</head>
<body>
<h2>O funcionario já esta registrado com os seguintes dados</h2>
<%@page import="com.atos.impacta.model.*" %>
<%
  Gerente gerente = (Gerente)request.getAttribute("gerente");
  
%>
<div>Nome</div>
<div><%=gerente.getNome() %></div> 
</body>
</html>