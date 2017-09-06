<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mercado.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@include file="menu.html" %>
<f:view>
	<h:form>
		<h:messages></h:messages>
		<rich:panel>
			<f:facet name="header">
				<h:outputText value="Cadastro de Cliente" />
			</f:facet>
			<h:panelGrid columns="2">
				<h:outputText value="Nome" />
				<h:outputText value="#{clienteControl.cliente.nome}" />
				<h:outputText value="Email" />
				<h:outputText value="#{clienteControl.cliente.email}" />
				<h:outputText value="Cep:" />
				<h:panelGroup>
					<h:inputText value="#{clienteControl.cepString}" />
				</h:panelGroup>
			</h:panelGrid>
		</rich:panel>
	</h:form>
</f:view>
</body>
</html>