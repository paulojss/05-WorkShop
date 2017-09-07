<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>

<head>
<link href="mercado.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<f:view>
	<h:form>
		<h:panelGrid columns="2">
			<h:graphicImage value="figuras/#{pedidoControl.produto.foto}" styleClass="fotoMaior"></h:graphicImage>
			<h:panelGrid>
				<h:outputText value="Código:#{pedidoControl.produto.id}"/>
				<h:outputText value="#{pedidoControl.produto.descricao}"/>
				<h:outputText value="#{pedidoControl.produto.preco}">
					<f:convertNumber pattern="###,##0.00"/>
				</h:outputText>
				<h:commandButton action="carrinho" actionListener="#{pedidoControl.comprar}" value="Comprar"></h:commandButton>
			</h:panelGrid>
		</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>