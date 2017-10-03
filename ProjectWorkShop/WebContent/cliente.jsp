<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>

<head>
<link href="mercado.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<%@include file="menu.html" %>
<f:view>
	<h:form>
			<div id="geral">
			<h:messages></h:messages>
			
			<rich:panel>
				<f:facet name="header">
					<h:outputText value="Cadastro de Cliente"/>
				</f:facet>
				<h:panelGrid columns="2">
					<h:outputText value="Nome" />
					<h:inputText value="#{clienteControl.cliente.nome}" styleClass="edit"/>
					<h:outputText value="Email"/>
					<h:inputText value="#{clienteControl.cliente.email}" styleClass="edit"/>

					<h:outputText value="Cep:"/>
					<h:panelGroup>
						<h:inputText value="#{clienteControl.cepString}" styleClass="edit"/>
						<h:commandButton actionListener="#{clienteControl.consultarCep}" value="Consultar"/>
					</h:panelGroup>

					<h:outputText value="Senha:" />
					<h:inputSecret value="#{clienteControl.cliente.senha}" styleClass="edit"/>
					
					<h:outputText value="Senha Novamente:" />
					<h:inputSecret value="#{clienteControl.senha}" styleClass="edit"/>
					
					<h:outputText value="Logradouro" />
					<h:outputText value="#{clienteControl.cliente.cep.logradouro}"/>
					<h:outputText value="Bairro" />
					<h:outputText value="#{clienteControl.cliente.cep.bairro}"/>
					<h:outputText value="Municipio" />
					<h:outputText value="#{clienteControl.cliente.cep.municipio.descricao}"/>
					<h:commandButton action="#{clienteControl.confirmarCliente}" value="Confirmar"/>
				</h:panelGrid>
			</rich:panel>
	</div>
	</h:form>
</f:view>
</body>
</html>