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
		<h:messages></h:messages>
		Descricao: <h:inputText value="#{pedidoControl.descricao}"></h:inputText>
		<h:commandButton actionListener="#{pedidoControl.listarProdutos }" value="listar"></h:commandButton>
		<rich:dataTable value="#{pedidoControl.produtos}" var="produto" width="700px">
		
		<f:facet name="header">
		<h:outputText value="Produtos Encontrados"></h:outputText>
		</f:facet>
		<rich:column>
		<f:facet name="header">
		<h:outputText value="Foto"></h:outputText>
		</f:facet>
		<h:graphicImage value="figuras/#{produto.foto}" styleClass="foto"></h:graphicImage>
		</rich:column>
		<rich:column>
		<f:facet name="header">
		<h:outputText value="Descricao"></h:outputText>
		</f:facet>
		<h:outputText value="#{produto.descricao}"/>
		</rich:column>
		<rich:column>
		<f:facet name="header">
		<h:outputText value="Preco"></h:outputText>
		</f:facet>
		<h:outputText value="#{produto.preco}">
		<f:convertNumber pattern="###,##0.00"/>
		</h:outputText>
		</rich:column>
		<rich:column>
			<f:facet name="header">
			<h:outputText value="Detalhes"></h:outputText>
			</f:facet>
			<h:commandButton value="Detalhes" action="detalhes" actionListener="#{pedidoControl.selecionarProdutos}">
			</h:commandButton>
		</rich:column>
	</rich:dataTable>
	</h:form>
</f:view>
</body>
</html>