<%@include file="_header.jsp" %>
<%@include file="_menu.jsp" %>  
<%
String filtro = "";
if (request.getParameter("idc") != null) {
    String sidc = request.getParameter("idc");
    filtro = "categorias_idcategorias = '"+sidc+"' ";
}
else if (request.getParameter("nom") != null) {
    String nome = request.getParameter("nom");
    filtro = "p.nome like '%"+nome+"%' ";
}
else {
    response.sendRedirect("index.jsp");
}

pageContext.setAttribute("filtro", filtro);
%>
  
  <div class="container px-4 py-4" id="custom-cards">
    <h2 class="pb-2 border-bottom">Lista dos Produtos</h2>
    <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
      
      <jsp:useBean class="br.com.alfashop.repository.ProdutoDAO" id="daopro" />
      <c:forEach items="${daopro.buscar(filtro)}" var="objpro">
      <div class="col">
        <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" 
             style="background-image: url('https://picsum.photos/400/200?random=${objpro.idproduto}');">
          <div class="d-flex flex-column h-100 p-3 pb-3 text-white text-shadow-1">
            <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">
                <a href="detalhes.jsp?idp=${objpro.idproduto}">${objpro.nome}</a>
            </h2>
            <ul class="d-flex list-unstyled mt-auto">
              <li class="me-auto">
                R$ ${objpro.valor}
              </li>
              <li class="d-flex align-items-center me-3">
                <small>${objpro.catnome}</small>
              </li>
            </ul>
          </div>
        </div>
      </div>
      </c:forEach>

    </div>
  </div>

  
<%@include file="_footer.jsp" %>
