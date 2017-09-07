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
	
		<h:messages style="color:red;text-align: center;"></h:messages>
		<h:panelGrid columns="2" rendered="#{!clienteControl.autenticado}">
			<h:outputText value="Email:" ></h:outputText>
			<h:inputText value="#{clienteControl.email}" styleClass="edit"></h:inputText>
			<h:outputText value="Senha:" styleClass="rotulos"></h:outputText>
			<h:inputSecret value="#{clienteControl.senha}" styleClass="edit"></h:inputSecret>
			<h:commandButton actionListener="#{clienteControl.autenticar}" value="Entrar"></h:commandButton>
			<h:commandButton action="formularioCliente" value="Fazer Cadastro" />
		</h:panelGrid>
		<h:panelGroup rendered="#{clienteControl.autenticado}">
			<rich:panel>
				<f:facet name="header">
					<h:outputText value="Seus Dados Pessoais"/>
				</f:facet>
				<h:panelGrid columns="2">
					<h:outputText value="Nome"/>
					<h:outputText value="#{clienteControl.cliente.nome}" />
					<h:outputText value="Email" styleClass="rotulos"/>
					<h:outputText value="#{clienteControl.cliente.email}"/>
					<h:outputText value="Logradouro" styleClass="rotulos"/>
					<h:outputText value="#{clienteControl.cliente.cep.logradouro}" />
					<h:outputText value="Bairro" styleClass="rotulos"/>
					<h:outputText value="#{clienteControl.cliente.cep.bairro}" />
					<h:outputText value="Municipio" styleClass="rotulos"/>
					<h:outputText value="#{clienteControl.cliente.cep.municipio.descricao}"/>
					<h:commandButton actionListener="#{pedidoControl.confirmarCompra}" value="Confirmar Compra" styleClass="botoes" />
					<h:commandButton action="formularioCliente" value="Alterar Dados" styleClass="botoes"/>
				</h:panelGrid>
				<h:commandButton actionListener="#{clienteControl.logout}" value="Sair" styleClass="botoes"></h:commandButton>
			</rich:panel>
		</h:panelGroup>
	</div>
	</h:form>
</f:view>
</body>
</html>
