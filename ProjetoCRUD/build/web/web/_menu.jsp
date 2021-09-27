<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
          <jsp:useBean class="br.com.alfashop.repository.CategoriaDAO" id="daocat" />
          <c:forEach items="${daocat.lista}" var="objcat">
          <li class="nav-item">
            <a class="nav-link" href="produtos.jsp?idc=${objcat.idcategoria}">${objcat.nome}</a>
          </li>
          </c:forEach>
        </ul>
      </div>
    </div>
</nav>