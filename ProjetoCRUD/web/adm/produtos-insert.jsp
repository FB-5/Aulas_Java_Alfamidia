<%@include file="_header.jsp" %>

<h2 class="pb-2 border-bottom">Cadastro de Produto</h2>

<a href="produtos.jsp" class="btn btn-info">Voltar para a Lista</a>
<br><br>

<form action="produtos-exec" method="post">
    Categoria: <br>
    <select name="cid">
        <jsp:useBean class="br.com.alfashop.repository.CategoriaDAO" id="daocat" />
        <c:forEach items="${daocat.lista}" var="objcat">
            <option value="${objcat.idcategoria}">${objcat.nome}</option>
        </c:forEach>
    </select>
    <br><br>
    
    Nome: <br>
    <input type="text" name="nom">
    <br><br>
    
    <button>Cadastrar</button>
</form>

<br><br>    
<%@include file="_footer.jsp" %>
