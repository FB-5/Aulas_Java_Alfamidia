<%@include file="_header.jsp" %>

<h2 class="pb-2 border-bottom">Lista dos Produtos</h2>

<a href="produtos-insert.jsp" class="btn btn-info">Cadastrar Produto</a>
<br><br>

<jsp:useBean class="br.com.alfashop.repository.ProdutoDAO" id="daopro" />
<c:forEach items="${daopro.lista}" var="objpro">
    <a href="">[ X ]</a>
    ::
    <a href="">[ A ]</a>
    :: 
    ${objpro.nome} 
    <br>
</c:forEach>

<br><br>    
<%@include file="_footer.jsp" %>
